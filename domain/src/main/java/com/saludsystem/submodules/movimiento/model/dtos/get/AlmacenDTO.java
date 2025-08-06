package com.saludsystem.submodules.movimiento.dtos.get;

import com.saludsystem.submodules.movimiento.dtos.post.CrearAlmacenDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlmacenDTO extends CrearAlmacenDTO {

    private UUID sedeId;

}