package com.saludsystem.submodules.paciente.mapper.historialclinico;

import com.saludsystem.submodules.paciente.model.dtos.command.create.historialclinico.AntecedenteCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.AntecedenteEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.AntecedenteDTO;
import com.saludsystem.submodules.paciente.model.entity.historialclinico.Antecedente;

import java.util.UUID;

public class AntecedenteMapper {

    public Antecedente fromCreateDto(AntecedenteCreateCommand createCommand) {

        return new Antecedente(null, createCommand.getPacienteId(), createCommand.getMotivo(),
                createCommand.getEnfermedad(), createCommand.getTiempoEnfermedad(), createCommand.getSigno(),
                createCommand.getRelato(), createCommand.getFunciones(), createCommand.getAntecedentesPersonales(),
                createCommand.getAntecedentesFamiliares(), createCommand.getMedicamento(),
                createCommand.getNombreMedicamento(), createCommand.getMotivoMedicamento(), createCommand.getDosis());

    }

    public Antecedente fromUpdateDto(UUID uuid, AntecedenteEditCommand editCommand) {

        return new Antecedente(uuid, editCommand.getPacienteId(), editCommand.getMotivo(),
                editCommand.getEnfermedad(), editCommand.getTiempoEnfermedad(), editCommand.getSigno(),
                editCommand.getRelato(), editCommand.getFunciones(), editCommand.getAntecedentesPersonales(),
                editCommand.getAntecedentesFamiliares(), editCommand.getMedicamento(),
                editCommand.getNombreMedicamento(), editCommand.getMotivoMedicamento(), editCommand.getDosis());

    }

    public AntecedenteDTO toDto(Antecedente model) {

        return new AntecedenteDTO(

                model.getPacienteEnfermedadActualId(),
                model.getPacienteId(),
                model.getMotivo(),
                model.getEnfermedad(),
                model.getTiempoEnfermedad(),
                model.getSigno(),
                model.getRelato(),
                model.getFunciones(),
                model.getAntecedentesPersonales(),
                model.getAntecedentesFamiliares(),
                model.getMedicamento(),
                model.getNombreMedicamento(),
                model.getMotivoMedicamento(),
                model.getDosis()

        );

    }

}