package com.saludsystem.application.configuracion.dtos.put;

import com.saludsystem.application.configuracion.dtos.post.CrearSysSaludDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarHospitalDTO extends CrearSysSaludDTO {
    private UUID hospitalId;
}