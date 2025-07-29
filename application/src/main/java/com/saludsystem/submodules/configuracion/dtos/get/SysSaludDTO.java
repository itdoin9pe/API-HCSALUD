package com.saludsystem.submodules.configuracion.dtos.get;

import com.saludsystem.submodules.configuracion.dtos.post.CrearSysSaludDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysSaludDTO extends CrearSysSaludDTO {
    private UUID hospitalId;
}