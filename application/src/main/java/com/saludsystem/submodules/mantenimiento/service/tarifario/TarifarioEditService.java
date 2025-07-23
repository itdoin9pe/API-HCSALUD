package com.saludsystem.submodules.mantenimiento.service.tarifario;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.Tarifario;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTarifarioDTO;
import com.saludsystem.submodules.mantenimiento.model.exception.business.TarifarioBusinessRuleException;
import com.saludsystem.submodules.mantenimiento.model.exception.validation.TarifarioValidationException;
import com.saludsystem.submodules.mantenimiento.model.validators.TarifarioValidator;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class TarifarioEditService {

    private final TarifarioRepository tarifarioRepository;
    private final TarifarioValidator tarifarioValidator;
    private static final Logger logger = LoggerFactory.getLogger(TarifarioEditService.class);

    public TarifarioEditService(TarifarioRepository tarifarioRepository, TarifarioValidator tarifarioValidator) {
        this.tarifarioRepository = tarifarioRepository;
        this.tarifarioValidator = tarifarioValidator;
    }

    public Tarifario execute(UUID uuid, ActualizarTarifarioDTO dto) {

        try {
            // 1. Validar UUID
            if (uuid == null) {
                throw new TarifarioValidationException("El ID del tarifario es obligatorio");
            }

            // 2. Validaciones del DTO
            tarifarioValidator.validateForUpdate(uuid, dto);

            // 3. Lógica de negocio
            applyBusinessLogic(dto);

            var updateToSave = TarifarioMapper.fromUpdateDto(uuid, dto);

            return tarifarioRepository.update(uuid, updateToSave);

        } catch (TarifarioValidationException | TarifarioBusinessRuleException e) {
            logger.error("Error de validación al actualizar tarifario {}: {}", uuid, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Error inesperado al actualizar tarifario {}", uuid, e);
            throw new RuntimeException("Error interno al actualizar el tarifario", e);
        }

    }

    private void applyBusinessLogic(ActualizarTarifarioDTO dto) {
        // Misma lógica que en create
        if (dto.getDescripcion() != null) {
            dto.setDescripcion(dto.getDescripcion().trim().toUpperCase());
        }

        if (dto.getGrupo() != null && !dto.getGrupo().trim().isEmpty()) {
            dto.setGrupo(dto.getGrupo().trim().toUpperCase());
        }
    }

}
