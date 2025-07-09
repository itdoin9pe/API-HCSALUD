package com.saludsystem.configuracion.application.dto.get;

import com.saludsystem.configuracion.application.dto.post.CrearSedeDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class SedeDTO extends CrearSedeDTO {
    private UUID sedeId;
}