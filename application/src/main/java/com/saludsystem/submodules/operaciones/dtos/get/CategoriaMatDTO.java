package com.saludsystem.submodules.operaciones.dtos.get;

import com.saludsystem.submodules.operaciones.dtos.post.CrearCategotiaMatDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoriaMatDTO extends CrearCategotiaMatDTO {

    private UUID categoriaMaterialId;

}