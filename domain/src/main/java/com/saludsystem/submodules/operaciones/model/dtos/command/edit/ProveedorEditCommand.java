package com.saludsystem.submodules.operaciones.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProveedorEditCommand extends BaseDTO {

    private UUID proveedorId;

    private String ruc;

    private String nombre;

    private String direccion;

    private String telefono;

    private String correo;

    private String contacto;
}
