package com.saludsystem.submodules.mantenimiento.dtos.get;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearCajaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CajaDTO extends CrearCajaDTO {
    private UUID cajaId;
}