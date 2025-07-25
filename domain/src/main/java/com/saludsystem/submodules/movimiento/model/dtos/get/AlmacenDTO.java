package com.saludsystem.submodules.movimiento.model.dtos.get;

import com.saludsystem.submodules.movimiento.model.dtos.post.CrearAlmacenDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlmacenDTO extends CrearAlmacenDTO {

    private UUID sedeId;

}