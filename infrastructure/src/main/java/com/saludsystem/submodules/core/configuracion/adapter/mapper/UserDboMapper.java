package com.saludsystem.submodules.core.configuracion.adapter.mapper;

import com.saludsystem.submodules.core.configuracion.adapter.entity.RoleEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UserDboMapper {
    public Usuario toDomain(UserEntity entity) {
        if (entity == null) return null;

        return new Usuario(
                entity.getUserId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPassword(),
                entity.getPhoneNumber(),
                entity.getAddress(),
                entity.getDocumentType(),
                entity.getDocumentNumber(),
                entity.getPhoto(),
                entity.getEstado(),
                entity.getRol().getRoleId(),
                entity.getHospital().getHospitalId()
        );
    }

    public Usuario toDomainWithOutRelations(UserEntity entity) {
        if (entity == null) return null;

        return new Usuario(
                entity.getUserId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getUsername(),
                entity.getPhoneNumber(),
                entity.getAddress(),
                entity.getDocumentType(),
                entity.getDocumentNumber(),
                entity.getPhoto(),
                entity.getEstado(),
                null,
                null
        );
    }

    public UserEntity toDbo(Usuario usuario, RoleEntity roleEntity, SysSaludEntity hospitalEntity) {
        if (usuario == null) return null;

        UserEntity entity = new UserEntity();
        entity.setUserId(usuario.getId().value());
        entity.setFirstName(usuario.getFirstName().valor());
        entity.setLastName(usuario.getLastName().valor());
        entity.setEmail(usuario.getEmail().value());
        entity.setUsername(usuario.getUsername().value());
        entity.setPassword(usuario.getPassword().value());
        entity.setPhoneNumber(usuario.getPhoneNumber().value());
        entity.setAddress(usuario.getAddress().valor());
        entity.setDocumentType(usuario.getDocumentType().valor());
        entity.setDocumentNumber(usuario.getDocumentNumber().value());
        entity.setPhoto(usuario.getPhoto().url());
        entity.setEstado(usuario.getEstado().valor());
        entity.setRol(roleEntity);
        entity.setHospital(hospitalEntity);
        return entity;
    }

    public UserEntity toDboForCreate(Usuario usuario) {
        if (usuario == null) return null;

        UserEntity entity = new UserEntity();
        entity.setFirstName(usuario.getFirstName().valor());
        entity.setLastName(usuario.getLastName().valor());
        entity.setEmail(usuario.getEmail().value());
        entity.setUsername(usuario.getUsername().value());
        entity.setPassword(usuario.getPassword().value());
        entity.setPhoneNumber(usuario.getPhoneNumber().value());
        entity.setAddress(usuario.getAddress().valor());
        entity.setDocumentType(usuario.getDocumentType().valor());
        entity.setDocumentNumber(usuario.getDocumentNumber().value());
        entity.setPhoto(usuario.getPhoto().url());
        entity.setEstado(usuario.getEstado().valor());
        return entity;
    }
}
