package com.saludsystem.operaciones.application.dto.get;

import com.saludsystem.operaciones.application.dto.post.CrearUnidadDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class UnidadDTO extends CrearUnidadDTO {

    private UUID unidadId;

}