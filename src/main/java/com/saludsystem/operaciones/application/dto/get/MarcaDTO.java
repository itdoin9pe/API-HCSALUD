package com.saludsystem.operaciones.application.dto.get;

import com.saludsystem.operaciones.application.dto.post.CrearMarcaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MarcaDTO extends CrearMarcaDTO {

    private UUID marcaId;

}