package com.saludsystem.submodules.core.configuracion.adapter.mapper;

import com.saludsystem.submodules.configuracion.vo.usuario.*;
import com.saludsystem.submodules.core.configuracion.adapter.entity.RoleEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.configuracion.model.Usuario;

import java.util.UUID;

public class UserDboMapper {

    public static UserEntity toEntity(Usuario model, UUID hospitalId) {
        UserEntity entity = new UserEntity();
        entity.setLastName(model.getLastName().value());
        entity.setFirstName(model.getFirstName().value());
        entity.setEmail(model.getEmail().value());
        entity.setUsername(model.getUsername().value());
        entity.setPassword(model.getPassword().value());
        entity.setPhoneNumber(model.getPhoneNumber().value());
        entity.setAddress(model.getAddress().value());
        entity.setDocumentType(model.getDocumentType().value());
        entity.setDocumentNumber(model.getDocumentNumber().value());
        entity.setPhoto(model.getPhoto().url());
        //entity.setPhoto(model.getPhoto() != null ? model.getPhoto().url() : null);

        RoleEntity role = new RoleEntity();
        role.setRoleId(model.getRolId().value());
        entity.setRol(role);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        entity.setEstado(model.getEstado().value());

        return entity;
    }

    public static Usuario toDomain(UserEntity entity) {

        return new Usuario(
                new UserId(entity.getUserId()),
                new Apellido(entity.getLastName()),
                new Nombre(entity.getFirstName()),
                new Email(entity.getEmail()),
                new Username(entity.getUsername()),
                new Password(entity.getPassword()),
                new PhoneNumber(entity.getPhoneNumber()),
                new Direccion(entity.getAddress()),
                new TipoDocumentoUsuario(entity.getDocumentType()),
                new NumeroDocumento(entity.getDocumentNumber()),
                new Foto(entity.getPhoto()),
                new UserRole(entity.getRol().getRoleId()),
                new UserHospital(entity.getHospital().getHospitalId()),
                new EstadoUsuario(entity.getEstado()));

    }
}
