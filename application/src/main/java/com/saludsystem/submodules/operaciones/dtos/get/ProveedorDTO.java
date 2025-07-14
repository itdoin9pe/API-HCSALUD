package com.saludsystem.submodules.operaciones.dtos.get;

import com.saludsystem.submodules.operaciones.dtos.post.CrearProveedorDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProveedorDTO extends CrearProveedorDTO {

    private UUID proveedorId;

}