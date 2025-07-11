package com.saludsystem.application.configuracion.dtos.get;

import com.configuracion.application.dto.post.CrearSedeDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class SedeDTO extends CrearSedeDTO {
    private UUID sedeId;
}