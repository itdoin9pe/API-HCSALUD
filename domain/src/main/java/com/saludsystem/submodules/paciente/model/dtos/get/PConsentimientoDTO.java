package com.saludsystem.submodules.paciente.model.dtos.get;

import com.saludsystem.submodules.paciente.model.dtos.post.CrearPConsentimientoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PConsentimientoDTO extends CrearPConsentimientoDTO {

    private UUID pacienteConsentimientoId;

}