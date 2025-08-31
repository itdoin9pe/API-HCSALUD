package com.saludsystem.submodules.core.paciente.adapter.mapper.historialclinico;

import com.saludsystem.submodules.core.catalogo.adapter.entity.EspecialidadEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.SysSaludEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.PacienteEntity;
import com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.ConsultaEntity;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;

import java.util.UUID;

public class ConsultaDboMapper {

    public static ConsultaEntity toEntity(Consulta model, UUID userId, UUID hospitalId) {
        ConsultaEntity entity = new ConsultaEntity();
        entity.setPacienteConsultaId(model.getPacienteConsultaId());
        // Paciente
        var pacienteEntity = new PacienteEntity();
        pacienteEntity.setPacienteId(model.getPacienteId());
        entity.setPacienteEntity(pacienteEntity);
        // Especialidad
        var especialidadEntity = new EspecialidadEntity();
        especialidadEntity.setEspecialidadId(model.getEspecialidadId());
        entity.setEspecialidadEntity(especialidadEntity);
        // Campos simples
        entity.setMotivoConsulta(model.getMotivoConsulta());
        entity.setDiagnosticoPresuntivo(model.getDiagnosticoPresuntivo());
        entity.setTieneAlergia(model.isTieneAlergia());
        entity.setTieneAlergiaTexto(model.getTieneAlergiaTexto());
        entity.setTomaMedicamento(model.isTomaMedicamento());
        entity.setTomaMedicamentoTexto(model.getTomaMedicamentoTexto());
        entity.setCirugiasPrevias(model.isCirugiasPrevias());
        entity.setCirugiasPreviasTexto(model.getCirugiasPreviasTexto());
        entity.setEnfermedadesCronicas(model.getEnfermedadesCronicas());
        entity.setTransfusionesSanguineas(model.isTransfusionesSanguineas());
        entity.setHistorialPsiquiatrico(model.isHistorialPsiquiatrico());
        entity.setFuma(model.isFuma());
        entity.setConsumeAlcohol(model.isConsumeAlcohol());
        entity.setActividadFisica(model.getActividadFisica());
        entity.setEmbarazada(model.isEmbarazada());
        entity.setUltimaMenstruacion(model.getUltimaMenstruacion());
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

    public static Consulta toDomain(ConsultaEntity entity) {
        return new Consulta(
                entity.getPacienteConsultaId(),
                entity.getPacienteEntity().getPacienteId(),
                entity.getEspecialidadEntity().getEspecialidadId(),
                entity.getMotivoConsulta(),
                entity.getDiagnosticoPresuntivo(),
                entity.isTieneAlergia(),
                entity.getTieneAlergiaTexto(),
                entity.isTomaMedicamento(),
                entity.getTomaMedicamentoTexto(),
                entity.isCirugiasPrevias(),
                entity.getCirugiasPreviasTexto(),
                entity.getEnfermedadesCronicas(),
                entity.isTransfusionesSanguineas(),
                entity.isHistorialPsiquiatrico(),
                entity.isFuma(),
                entity.isConsumeAlcohol(),
                entity.getActividadFisica(),
                entity.isEmbarazada(),
                entity.getUltimaMenstruacion()
        );
    }
}