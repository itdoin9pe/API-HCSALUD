package com.saludsystem.submodules.configuracion.mapper;

import com.saludsystem.submodules.configuracion.model.dto.UserDto;
import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public class UsuarioDtoMapper {

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "documentType", target = "documentType")
    @Mapping(source = "documentNumber", target = "documentNumber")
    @Mapping(source = "photo", target = "photo")
    @Mapping(source = "estado", target = "estado")
    @Mapping(source = "rolId", target = "rolId")
    UserDto toDto(Usuario domain);

    // Métodos auxiliares para mapear value objects
    default UUID map(UserId value) {
        return value != null ? value.value() : null;
    }

    default String map(Nombre value) {
        return value != null ? value.valor() : null;
    }

    default String map(Apellido value) {
        return value != null ? value.valor() : null;
    }

    default String map(Email value) {
        return value != null ? value.value() : null;
    }

    default String map(Username value) {
        return value != null ? value.value() : null;
    }

    default String map(Password value) {
        return value != null ? value.value() : null;
    }

    default String map(PhoneNumber value) {
        return value != null ? value.value() : null;
    }

    default String map(Direccion value) {
        return value != null ? value.valor() : null;
    }

    default String map(TipoDocumentoUsuario value) {
        return value != null ? value.valor() : null;
    }

    default String map(NumeroDocumento value) {
        return value != null ? value.value() : null;
    }

    default String map(Foto value) {
        return value != null ? value.url() : null;
    }

    default Integer map(EstadoUsuario value) {
        return value != null ? value.valor() : null;
    }
    default UUID map(UserRole value) {
        return value != null ? value.value() : null;
    }

    default UUID map(UserHospital value) {
        return value != null ? value.value() : null;
    }
}

