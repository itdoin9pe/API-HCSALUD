package com.saludsystem.application.operaciones.dtos.get;

import com.saludsystem.application.dto.post.CrearMarcaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MarcaDTO extends CrearMarcaDTO {

    private UUID marcaId;

}