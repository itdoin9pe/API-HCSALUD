package com.saludsystem.submodules.operaciones.model.dtos.command.edit;

import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProveedorEditCommand extends BaseDTO
{
	private UUID proveedorId;

	private String ruc;

	private String nombre;

	private String direccion;

	private String telefono;

	private String correo;

	private String contacto;
}
