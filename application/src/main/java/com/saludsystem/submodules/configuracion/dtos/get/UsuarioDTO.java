package com.saludsystem.submodules.configuracion.dtos.get;

import com.saludsystem.submodules.configuracion.dtos.post.NewUserDto;
import com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class UsuarioDTO extends NewUserDto {
    private UUID userId;

    public UsuarioDTO(UserId id, Apellido lastName, Nombre firstName, Email email,
                      Username username, Password password, PhoneNumber phoneNumber,
                      Direccion address, TipoDocumentoUsuario documentType,
                      NumeroDocumento documentNumber, Foto photo, UserRole rolId,
                      UserHospital hospitalId, EstadoUsuario estado) {
        this.setUserId(id.value());
        this.setLastName(lastName.value());
        this.setFirstName(firstName.value());
        this.setEmail(email.value());
        this.setUsername(username.value());
        this.setPassword(password.value());
        this.setAddress(address.value());
        this.setDocumentType(documentType.value());
        this.setDocumentNumber(documentNumber.value());
        this.setPhoto(photo.url());
        this.setRoleId(rolId.value());
        this.setHospitalId(hospitalId.value());
        this.setEstado(estado.value());
    }
}