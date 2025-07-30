package com.saludsystem.submodules.configuracion.model;

import com.saludsystem.submodules.configuracion.vo.usuario.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
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

}
