package com.saludsystem.catalogo.application.dtos.get;

import com.saludsystem.catalogo.application.dtos.post.CrearApoderadoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApoderadoDTO extends CrearApoderadoDTO {
    private UUID apoderadoId;
}