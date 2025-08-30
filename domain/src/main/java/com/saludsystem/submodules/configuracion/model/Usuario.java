package com.saludsystem.submodules.configuracion.model;

import com.saludsystem.submodules.configuracion.model.vo.usuario.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Usuario {
	private UserId id;
	private Apellido lastName;
	private Nombre firstName;
	private Email email;
	private Username username;
	private Password password;
	private PhoneNumber phoneNumber;
	private Direccion address;
	private TipoDocumentoUsuario documentType;
	private NumeroDocumento documentNumber;
	private Foto photo;
	private UserRole rolId;
	private UserHospital hospitalId;
	private EstadoUsuario estado;

	public Usuario(UserId id, Apellido lastName, Nombre firstName, Email email, Username username, Password password,
			PhoneNumber phoneNumber, Direccion address, TipoDocumentoUsuario documentType,
			NumeroDocumento documentNumber, Foto photo, UserRole rolId, UserHospital hospitalId, EstadoUsuario estado) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.photo = photo;
		this.rolId = rolId;
		this.hospitalId = hospitalId;
		this.estado = estado;
	}
}