package com.saludsystem.submodules.mantenimiento.validators;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.TarifarioCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TarifarioEditCommand;
import com.saludsystem.submodules.mantenimiento.model.exception.business.TarifarioBusinessRuleException;
import com.saludsystem.submodules.mantenimiento.model.exception.validation.TarifarioValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class TarifarioValidator {

    public void validateForCreation(TarifarioCreateCommand dto) {
        validateNotNull(dto);
        validateRequiredFields(dto);
        validateBusinessRules(dto);
    }

    public void validateForUpdate(UUID id, TarifarioEditCommand dto) {
        validateNotNull(dto);
        validateRequiredFields(dto);  // Ahora acepta ActualizarTarifarioDTO
        validateBusinessRules(dto);   // Ahora acepta ActualizarTarifarioDTO
        validateEntityExists(id);
    }

    private void validateNotNull(Object dto) {
        if (dto == null) {
            throw new TarifarioValidationException("Los datos del tarifario no pueden ser nulos");
        }
    }

    // ===================================================================
    // OPCIÓN 1: MÉTODOS SOBRECARGADOS (RECOMENDADO)
    // ===================================================================

    private void validateRequiredFields(TarifarioCreateCommand dto) {
        var errors = new ArrayList<String>();

        if (dto.getTipoConceptoId() == null) {
            errors.add("El tipo de concepto es obligatorio");
        }

        if (dto.getCategoriaId() == null) {
            errors.add("La categoría es obligatoria");
        }

        if (dto.getMedidaId() == null) {
            errors.add("La medida es obligatoria");
        }

        if (dto.getUnidadId() == null) {
            errors.add("La unidad es obligatoria");
        }

        if (dto.getDescripcion() == null || dto.getDescripcion().trim().isEmpty()) {
            errors.add("La descripción es obligatoria");
        }

        if (dto.getPrecio() == null) {
            errors.add("El precio es obligatorio");
        }

        if (dto.getEstado() == null) {
            errors.add("El estado es obligatorio");
        }

        if (!errors.isEmpty()) {
            throw new TarifarioValidationException("Errores de validación: " + String.join(", ", errors));
        }
    }

    // Sobrecarga para ActualizarTarifarioDTO
    private void validateRequiredFields(TarifarioEditCommand dto) {
        var errors = new ArrayList<String>();

        if (dto.getTipoConceptoId() == null) {
            errors.add("El tipo de concepto es obligatorio");
        }

        if (dto.getCategoriaId() == null) {
            errors.add("La categoría es obligatoria");
        }

        if (dto.getMedidaId() == null) {
            errors.add("La medida es obligatoria");
        }

        if (dto.getUnidadId() == null) {
            errors.add("La unidad es obligatoria");
        }

        if (dto.getDescripcion() == null || dto.getDescripcion().trim().isEmpty()) {
            errors.add("La descripción es obligatoria");
        }

        if (dto.getPrecio() == null) {
            errors.add("El precio es obligatorio");
        }

        if (dto.getEstado() == null) {
            errors.add("El estado es obligatorio");
        }

        if (!errors.isEmpty()) {
            throw new TarifarioValidationException("Errores de validación: " + String.join(", ", errors));
        }
    }

    private void validateBusinessRules(TarifarioCreateCommand dto) {
        validatePrecio(dto.getPrecio());
        validateEstado(dto.getEstado());
        validateDescripcion(dto.getDescripcion());
        validateGrupo(dto.getGrupo());
    }

    // Sobrecarga para ActualizarTarifarioDTO
    private void validateBusinessRules(TarifarioEditCommand dto) {
        validatePrecio(dto.getPrecio());
        validateEstado(dto.getEstado());
        validateDescripcion(dto.getDescripcion());
        validateGrupo(dto.getGrupo());
    }

    // Métodos auxiliares comunes
    private void validatePrecio(Double precio) {
        if (precio != null && precio < 0) {
            throw new TarifarioBusinessRuleException("El precio no puede ser negativo");
        }

        if (precio != null && precio > 999999.99) {
            throw new TarifarioBusinessRuleException("El precio no puede exceder 999,999.99");
        }
    }

    private void validateEstado(Integer estado) {
        if (estado != null && !isValidEstado(estado)) {
            throw new TarifarioBusinessRuleException("El estado debe ser 0 (inactivo) o 1 (activo)");
        }
    }

    private void validateDescripcion(String descripcion) {
        if (descripcion != null && descripcion.length() > 500) {
            throw new TarifarioBusinessRuleException("La descripción no puede exceder 500 caracteres");
        }
    }

    private void validateGrupo(String grupo) {
        if (grupo != null && !grupo.trim().isEmpty() && grupo.length() > 100) {
            throw new TarifarioBusinessRuleException("El grupo no puede exceder 100 caracteres");
        }
    }

    private void validateEntityExists(UUID id) {
        // Aquí podrías verificar si el tarifario existe para updates
        // Dependería de tu implementación específica
    }

    private boolean isValidEstado(Integer estado) {
        return estado == 0 || estado == 1;
    }
}
