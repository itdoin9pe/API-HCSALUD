package com.saludsystem.application.operaciones.dtos.get;

import com.saludsystem.application.dto.post.CrearCategotiaMatDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoriaMatDTO extends CrearCategotiaMatDTO {

    private UUID categoriaMaterialId;

}