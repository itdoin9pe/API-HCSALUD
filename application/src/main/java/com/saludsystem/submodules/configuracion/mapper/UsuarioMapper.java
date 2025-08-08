package com.saludsystem.submodules.configuracion.mapper;

import com.saludsystem.submodules.configuracion.model.dtos.UsuarioDTO;
import com.saludsystem.submodules.configuracion.model.dtos.auth.NewUserDto;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.UsuarioEditCommand;
import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.configuracion.model.vo.usuario.*;

import java.util.UUID;

public class UsuarioMapper {

    public Usuario fromCreateDto(NewUserDto dto) {
        return new Usuario(
                null,
                new Apellido(dto.getLastName()),
                new Nombre(dto.getFirstName()),
                new Email(dto.getEmail()),
                new Username(dto.getUsername()),
                new Password(dto.getPassword()),
                new PhoneNumber(dto.getPhoneNumber()),
                new Direccion(dto.getAddress()),
                new TipoDocumentoUsuario(dto.getDocumentType()),
                new NumeroDocumento(dto.getDocumentNumber()),
                new Foto(dto.getPhoto()),
                new UserRole(dto.getRoleId()),
                new UserHospital(dto.getHospitalId()),
                new EstadoUsuario(dto.getEstado()));
    }

    public Usuario fromUpdateDto(UUID uuid, UsuarioEditCommand dto) {
        return new Usuario(
                new UserId(dto.getUserId()),
                new Apellido(dto.getLastName()),
                new Nombre(dto.getFirstName()),
                new Email(dto.getEmail()),
                new Username(dto.getUsername()),
                new Password(dto.getPassword()),
                new PhoneNumber(dto.getPhoneNumber()),
                new Direccion(dto.getAddress()),
                new TipoDocumentoUsuario(dto.getDocumentType()),
                new NumeroDocumento(dto.getDocumentNumber()),
                new Foto(dto.getPhoto()),
                new UserRole(dto.getRoleId()),
                new UserHospital(dto.getHospitalId()),
                new EstadoUsuario(dto.getEstado()));
    }

    public UsuarioDTO toDto(Usuario model) {
        return new UsuarioDTO(model.getId().value(), model.getLastName().value(), model.getFirstName().value(),
                model.getEmail().value(), model.getUsername().value(), model.getPhoneNumber().value(),
                model.getAddress().value(), model.getDocumentType().value(), model.getDocumentNumber().value(),
                model.getPhoto().url(), model.getRolId().value(), model.getHospitalId().value(),
                model.getEstado().value());
    }

}
