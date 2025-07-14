package com.saludsystem.submodules.configuracion.dtos.put;

import com.saludsystem.submodules.configuracion.dtos.post.CrearSysSaludDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarHospitalDTO extends CrearSysSaludDTO {
    private UUID hospitalId;
}