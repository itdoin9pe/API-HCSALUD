package com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico;

import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.AntecedentesEntity;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;

import java.util.UUID;

public class AntecedenteDboMapper {

    public static AntecedentesEntity toEntity(Antecedente model, UUID userId, UUID hospitalId) {
        AntecedentesEntity entity = new AntecedentesEntity();
        entity.setPacienteEnfermedadActualId(model.getPacienteEnfermedadActualId());
        // Paciente
        var pacienteEntity = new PacienteEntity();
        pacienteEntity.setPacienteId(model.getPacienteId());
        entity.setPacienteEntity(pacienteEntity);
        // Campos simples
        entity.setMotivo(model.getMotivo());
        entity.setEnfermedad(model.getEnfermedad());
        entity.setTiempoEnfermedad(model.getTiempoEnfermedad());
        entity.setSigno(model.getSigno());
        entity.setRelato(model.getRelato());
        entity.setFunciones(model.getFunciones());
        entity.setAntecedentesPersonales(model.getAntecedentesPersonales());
        entity.setAntecedentesFamiliares(model.getAntecedentesFamiliares());
        entity.setMedicamento(model.getMedicamento());
        entity.setNombreMedicamento(model.getNombreMedicamento());
        entity.setMotivoMedicamento(model.getMotivoMedicamento());
        entity.setDosis(model.getDosis());
        // Usuario
        var userEntity = new UserEntity();
        userEntity.setUserId(userId);
        entity.setUser(userEntity);
        // Hospital
        var hospitalEntity = new SysSaludEntity();
        hospitalEntity.setHospitalId(hospitalId);
        entity.setHospital(hospitalEntity);
        return entity;
    }

    public static Antecedente toDomain(AntecedentesEntity entity) {
        return new Antecedente(
                entity.getPacienteEnfermedadActualId(),
                entity.getPacienteEntity().getPacienteId(),
                entity.getMotivo(),
                entity.getEnfermedad(),
                entity.getTiempoEnfermedad(),
                entity.getSigno(),
                entity.getRelato(),
                entity.getFunciones(),
                entity.getAntecedentesPersonales(),
                entity.getAntecedentesFamiliares(),
                entity.getMedicamento(),
                entity.getNombreMedicamento(),
                entity.getMotivoMedicamento(),
                entity.getDosis()
        );
    }
}
