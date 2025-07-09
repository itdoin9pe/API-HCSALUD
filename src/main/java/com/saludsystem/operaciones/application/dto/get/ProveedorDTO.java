package com.saludsystem.operaciones.application.dto.get;

import com.saludsystem.operaciones.application.dto.post.CrearProveedorDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProveedorDTO extends CrearProveedorDTO {

    private UUID proveedorId;

}