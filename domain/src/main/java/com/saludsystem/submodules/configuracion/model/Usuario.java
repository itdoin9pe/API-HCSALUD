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
	
	public void actualizarApellido(Apellido lastName) {
	    if (lastName != null) {
	        this.lastName = lastName;
	    }
	}
	public void actualizarNombre(Nombre firstName) {
	    if (firstName != null) {
	        this.firstName = firstName;
	    }
	}
	public void actualizarEmail(Email email) {
	    if (email != null) {
	        this.email = email;
	    }
	}
	public void actualizarUsername(Username username) {
	    if (username != null) {
	        this.username = username;
	    }
	}
	public void actualizarPassword(Password password) {
	    if (password != null) {
	        this.password = password;
	    }
	}
	public void actualizarPhoneNumber(PhoneNumber phoneNumber) {
	    if (phoneNumber != null) {
	        this.phoneNumber = phoneNumber;
	    }
	}
	public void actualizarAddress(Direccion address) {
	    if (address != null) {
	        this.address = address;
	    }
	}
	public void actualizarTipoDocumento(TipoDocumentoUsuario documentType) {
	    if (documentType != null) {
	        this.documentType = documentType;
	    }
	}
	public void actualizarNumeroDocumento(NumeroDocumento documentNumber) {
	    if (documentNumber != null) {
	        this.documentNumber = documentNumber;
	    }
	}
	public void actualizarFoto(Foto photo) {
	    if (photo != null) {
	        this.photo = photo;
	    }
	}
	public void actualizarRol(UserRole rolId) {
	    if (rolId != null) {
	        this.rolId = rolId;
	    }
	}
	public void actualizarHospital(UserHospital hospitalId) {
	    if (hospitalId != null) {
	        this.hospitalId = hospitalId;
	    }
	}
	public void actualizarEstado(EstadoUsuario estado) {
	    if (estado != null) {
	        this.estado = estado;
	    }
	}
}