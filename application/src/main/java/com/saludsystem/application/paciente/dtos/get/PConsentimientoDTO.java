package com.saludsystem.application.paciente.dtos.get;

import com.saludsystem.application.dto.post.CrearPConsentimientoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PConsentimientoDTO extends CrearPConsentimientoDTO {

    private UUID pacienteConsentimientoId;

}