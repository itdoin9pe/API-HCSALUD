package com.saludsystem.submodules.core.catalogo.adapter.mapper;

import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.core.catalogo.adapter.entity.AlergiaEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;

import java.util.UUID;

public class AlergiaDboMapper {
    
    public static AlergiaEntity toEntity(Alergia model, UUID userId, UUID hospitalId) {
        AlergiaEntity entity = new AlergiaEntity();
        entity.setAlergiaId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setEstado(model.getEstado());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;
    }

    public static Alergia toDomain(AlergiaEntity entity) {
        return new Alergia(entity.getAlergiaId(), entity.getNombre(), entity.getEstado());
    }
}
