package com.saludsystem.submodules.paciente.mapper;

import com.saludsystem.submodules.paciente.model.dtos.command.create.EstudioMedicoCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.EstudioMedicoEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.EstudioMedicoDTO;
import com.saludsystem.submodules.paciente.model.entity.EstudioMedico;

import java.util.UUID;

public class EstudioMedicoMapper {

    public EstudioMedico fromCreateDto(EstudioMedicoCreateCommand createCommand) {

        return new EstudioMedico(null,createCommand.getTipo(), createCommand.getDescripcion(),
                createCommand.getEstado(), createCommand.getPacienteId(), createCommand.getDoctorId(),
                createCommand.getPacienteEstudioResultadoId());

    }

    public EstudioMedico fromUpdateDto(Long id, EstudioMedicoEditCommand editCommand) {

        return new EstudioMedico(null,editCommand.getTipo(), editCommand.getDescripcion(),
                editCommand.getEstado(), editCommand.getPacienteId(), editCommand.getDoctorId(),
                editCommand.getPacienteEstudioResultadoId());

    }

    public EstudioMedicoDTO toDto(EstudioMedico model) {

        return new EstudioMedicoDTO(
                model.getId(),
                model.getDescripcion(),
                model.getEstado(),
                model.getPacienteId(),
                model.getDoctorId(),
                model.getEstudioResultadoId());

    }

}