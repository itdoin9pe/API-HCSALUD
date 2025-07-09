package com.saludsystem.configuracion.application.dto.put;

import com.saludsystem.configuracion.application.dto.post.CrearSysSaludDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarHospitalDTO extends CrearSysSaludDTO {
    private UUID hospitalId;
}