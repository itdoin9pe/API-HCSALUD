package com.saludsystem.application.operaciones.dtos.get;

import com.saludsystem.application.operaciones.dtos.post.CrearUnidadDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class UnidadDTO extends CrearUnidadDTO {

    private UUID unidadId;

}