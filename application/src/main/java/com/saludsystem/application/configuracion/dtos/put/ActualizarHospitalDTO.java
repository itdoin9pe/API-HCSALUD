package com.saludsystem.application.configuracion.dtos.put;

import com.configuracion.application.dto.post.CrearSysSaludDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarHospitalDTO extends CrearSysSaludDTO {
    private UUID hospitalId;
}