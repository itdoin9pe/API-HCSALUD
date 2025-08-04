package com.saludsystem.submodules.configuracion.model.dtos;

import com.saludsystem.submodules.configuracion.model.vo.usuario.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UsuarioDTO {

    private UUID userId;

    private String lastName;
    private String firstName;
    @NotBlank
    @jakarta.validation.constraints.Email
    private String email;
    private String username;
    private String password;
    private String phoneNumber;
    private String address;
    private String documentType;
    private String documentNumber;
    private String photo;
    //private MultipartFile photo;
    private UUID roleId;
    private UUID hospitalId;
    @Schema(example = "0")
    private Integer estado;

    public UsuarioDTO(UserId id, Apellido lastName, Nombre firstName, Email email,
                      Username username, PhoneNumber phoneNumber,
                      Direccion address, TipoDocumentoUsuario documentType,
                      NumeroDocumento documentNumber, Foto photo, UserRole rolId,
                      UserHospital hospitalId , EstadoUsuario estado) {
        this.setUserId(id.value());
        this.setLastName(lastName.value());
        this.setFirstName(firstName.value());
        this.setEmail(email.value());
        this.setUsername(username.value());
        //this.setPassword(password.value());
        this.setPhoneNumber(phoneNumber.value());
        this.setAddress(address.value());
        this.setDocumentType(documentType.value());
        this.setDocumentNumber(documentNumber.value());
        this.setPhoto(photo.url());
        this.setRoleId(rolId.value());
        this.setHospitalId(hospitalId.value());
        this.setEstado(estado.value());
    }

}