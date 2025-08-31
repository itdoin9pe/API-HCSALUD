package com.saludsystem.submodules.paciente.mapper.historialclinico;

import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.ConsultaCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.ConsultaEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ConsultaDTO;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;

import java.util.UUID;

public class ConsultaMapper {

    public Consulta fromCreateDto(ConsultaCreateCommand createCommand) {
        return new Consulta(null, createCommand.getPacienteId(), createCommand.getEspecialidadId(),
                createCommand.getMotivoConsulta(), createCommand.getDiagnosticoPresuntivo(),
                createCommand.isTieneAlergia(), createCommand.getTieneAlergiaTexto(), createCommand.isTomaMedicamento(),
                createCommand.getTomaMedicamentoTexto(), createCommand.isCirugiasPrevias(),
                createCommand.getCirugiasPreviasTexto(), createCommand.getEnfermedadesCronicas(),
                createCommand.isTransfusionesSanguineas(), createCommand.isHistorialPsiquiatrico(),
                createCommand.isFuma(), createCommand.isConsumeAlcohol(), createCommand.getActividadFisica(),
                createCommand.isEmbarazada(), createCommand.getUltimaMenstruacion());
    }

    public Consulta fromUpdateDto(UUID uuid, ConsultaEditCommand editCommand) {
        return new Consulta(uuid, editCommand.getPacienteId(), editCommand.getEspecialidadId(),
         editCommand.getMotivoConsulta(), editCommand.getDiagnosticoPresuntivo(),
         editCommand.isTieneAlergia(), editCommand.getTieneAlergiaTexto(), editCommand.isTomaMedicamento(),
         editCommand.getTomaMedicamentoTexto(), editCommand.isCirugiasPrevias(),
         editCommand.getCirugiasPreviasTexto(), editCommand.getEnfermedadesCronicas(),
         editCommand.isTransfusionesSanguineas(), editCommand.isHistorialPsiquiatrico(),
         editCommand.isFuma(), editCommand.isConsumeAlcohol(), editCommand.getActividadFisica(),
         editCommand.isEmbarazada(), editCommand.getUltimaMenstruacion());
    }

    public ConsultaDTO toDto(Consulta model) {
        return new ConsultaDTO(
                model.getPacienteConsultaId(),
                model.getPacienteId(), model.getEspecialidadId(),
                model.getMotivoConsulta(), model.getDiagnosticoPresuntivo(),
                model.isTieneAlergia(), model.getTieneAlergiaTexto(), model.isTomaMedicamento(),
                model.getTomaMedicamentoTexto(), model.isCirugiasPrevias(),
                model.getCirugiasPreviasTexto(), model.getEnfermedadesCronicas(),
                model.isTransfusionesSanguineas(), model.isHistorialPsiquiatrico(),
                model.isFuma(), model.isConsumeAlcohol(), model.getActividadFisica(),
                model.isEmbarazada(), model.getUltimaMenstruacion()
        );
    }
}