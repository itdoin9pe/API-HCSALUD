package com.saludsystem.submodules.operaciones.model.dtos.get;

import com.saludsystem.submodules.operaciones.model.dtos.post.CrearUnidadDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class UnidadDTO extends CrearUnidadDTO {

    private UUID unidadId;

}