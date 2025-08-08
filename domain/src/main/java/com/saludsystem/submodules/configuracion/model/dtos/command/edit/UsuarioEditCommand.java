package com.saludsystem.submodules.configuracion.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioEditCommand extends BaseDTO {
    private String lastName;
    private String firstName;
    private String address;
    private String email;
    private String phoneNumber;
    private String documentType;
    private String documentNumber;
    private String photo;
    private String username;
    private String password;
    private Integer estado;
    private UUID roleId;
}