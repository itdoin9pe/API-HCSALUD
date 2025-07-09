package com.saludsystem.movimientos.application.dto.get;

import com.saludsystem.movimientos.application.dto.post.CrearAlmacenDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AlmacenDTO extends CrearAlmacenDTO {

    private UUID sedeId;

}