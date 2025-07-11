package com.saludsystem.application.movimiento.dtos.get;

import com.saludsystem.application.dto.post.CrearAlmacenDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlmacenDTO extends CrearAlmacenDTO {

    private UUID sedeId;

}