package com.saludsystem.submodules.mantenimiento.service.tarifario;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTarifarioDTO;
import com.saludsystem.submodules.mantenimiento.exception.business.TarifarioBusinessRuleException;
import com.saludsystem.submodules.mantenimiento.exception.validation.TarifarioValidationException;
import com.saludsystem.submodules.mantenimiento.validators.TarifarioValidator;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TarifarioCreateService {

    private final TarifarioRepository tarifarioRepository;
    private final TarifarioValidator tarifarioValidator;
    private static final Logger logger = LoggerFactory.getLogger(TarifarioCreateService.class);

    public TarifarioCreateService(TarifarioRepository tarifarioRepository, TarifarioValidator tarifarioValidator) {
        this.tarifarioRepository = tarifarioRepository;
        this.tarifarioValidator = tarifarioValidator;
    }

    public Tarifario execute(CrearTarifarioDTO dto) {

        try {
            // 1. Validaciones
            tarifarioValidator.validateForCreation(dto);

            // 2. Lógica de negocio adicional si es necesaria
            applyBusinessLogic(dto);

            var saved = TarifarioMapper.fromCreateDto(dto);

            return tarifarioRepository.save(saved);
        } catch (TarifarioValidationException | TarifarioBusinessRuleException e) {
            logger.error("Error de validación al crear tarifario: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Error inesperado al crear tarifario", e);
            throw new RuntimeException("Error interno al crear el tarifario", e);
        }
    }

    private void applyBusinessLogic(CrearTarifarioDTO dto) {
        // Aquí puedes agregar lógica de negocio específica
        // Por ejemplo: normalizar descripción, calcular descuentos, etc.

        // Normalizar descripción
        if (dto.getDescripcion() != null) {
            dto.setDescripcion(dto.getDescripcion().trim().toUpperCase());
        }

        // Normalizar grupo si existe
        if (dto.getGrupo() != null && !dto.getGrupo().trim().isEmpty()) {
            dto.setGrupo(dto.getGrupo().trim().toUpperCase());
        }
    }

}
