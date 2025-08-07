package com.saludsystem.submodules.core.paciente.adapter.mapper;

import com.saludsystem.submodules.core.catalogo.adapter.entity.MedicamentoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.MedicamentoRecetadoEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.RecetaEntity;
import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;

import java.util.UUID;

public class MedicamentoRecetadoDboMapper {

    public static MedicamentoRecetadoEntity toEntity(MedicamentoRecetado model, UUID userId, UUID hospitalId) {

        MedicamentoRecetadoEntity entity = new MedicamentoRecetadoEntity();
        entity.setId(model.getId());

        RecetaEntity receta = new RecetaEntity();
        receta.setPacienteRecetaId(model.getPacienteRecetaId());
        entity.setRecetaEntity(receta);

        MedicamentoEntity medicamento = new MedicamentoEntity();
        medicamento.setMedicamentoId(model.getMedicamentoId());
        entity.setMedicamentoEntity(medicamento);

        entity.setDosis(model.getDosis());
        entity.setFrecuencia(model.getFrecuencia());
        entity.setDuracionDias(model.getDuracionDias());
        entity.setIndicaciones(model.getIndicaciones());

        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);

        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);

        return entity;

    }

    public static MedicamentoRecetado toDomain(MedicamentoRecetadoEntity entity) {

        return new MedicamentoRecetado(
                entity.getId(),
                entity.getRecetaEntity().getPacienteRecetaId(),
                entity.getMedicamentoEntity().getMedicamentoId(),
                entity.getDosis(),
                entity.getFrecuencia(),
                entity.getDuracionDias(),
                entity.getDosis());

    }

}
