package com.saludsystem.submodules.configuracion.model.entity;

import com.saludsystem.submodules.configuracion.model.dto.command.create.UserCreateCommand;
import com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario.*;
import com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario.TipoDocumentoUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class Usuario {
    private UserId id;
    private Nombre firstName;
    private Apellido lastName;
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

    public Usuario(UUID id, String firstName, String lastName,
                   String email, String username, String password,
                   String phoneNumber, String addrees, String documentType,
                   String documentNumber, String photo, Integer estado,
                   UUID rolId, UUID hospitalId) {
        this.id = new UserId(id);
        this.firstName = new Nombre(firstName);
        this.lastName = new Apellido(lastName);
        this.email = new Email(email);
        this.username = new Username(username);
        this.password = new Password(password);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.address = new Direccion(addrees);
        this.documentType = new TipoDocumentoUsuario(documentType);
        this.documentNumber = new NumeroDocumento(documentNumber);
        this.photo = new Foto(photo);
        this.estado = new EstadoUsuario(estado);
        this.rolId = new UserRole(rolId);
        this.hospitalId = new UserHospital(hospitalId);
    }

    public Usuario(UUID id, String firstName, String lastName, String email, String username,
                   String phoneNumber, String address, String documentType, String documentNumber,
                   String photo, Integer estado, UUID rolId, UUID hospitalId) {
        this.id = new UserId(id);
        this.firstName = new Nombre(firstName);
        this.lastName = new Apellido(lastName);
        this.email = new Email(email);
        this.username = new Username(username);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.address = new Direccion(address);
        this.documentType = new TipoDocumentoUsuario(documentType);
        this.documentNumber = new NumeroDocumento(documentNumber);
        this.photo = new Foto(photo);
        this.estado = new EstadoUsuario(estado);
        this.rolId = new UserRole(rolId);
        this.hospitalId = new UserHospital(hospitalId);
    }

    public Usuario requestToCreate(UserCreateCommand userCreateCommand){
        this.firstName = new Nombre(userCreateCommand.getFirstName());
        this.lastName = new Apellido(userCreateCommand.getLastName());
        this.email = new Email(userCreateCommand.getEmail());
        this.username = new Username(userCreateCommand.getUsername());
        this.password = new Password(userCreateCommand.getPassword());
        this.phoneNumber = new PhoneNumber(userCreateCommand.getPhoneNumber());
        this.address = new Direccion(userCreateCommand.getAddress());
        this.documentType = new TipoDocumentoUsuario(userCreateCommand.getDocumentType());
        this.documentNumber = new NumeroDocumento(userCreateCommand.getDocumentNumber());
        this.photo = new Foto(userCreateCommand.getPhoto());
        this.estado = new EstadoUsuario(userCreateCommand.getEstado());
        this.rolId = new UserRole(userCreateCommand.getRolId());
        return this;
    }
}
