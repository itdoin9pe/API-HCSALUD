package com.saludsystem.submodules.paciente.mapper;

import com.saludsystem.submodules.paciente.model.dtos.command.create.PacienteCreateCommand;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.PacienteEditCommand;
import com.saludsystem.submodules.paciente.model.dtos.get.PacienteDTO;
import com.saludsystem.submodules.paciente.model.entity.Paciente;
import com.saludsystem.submodules.paciente.model.vo.paciente.*;

import java.util.UUID;

public class PacienteMapper {

    public Paciente fromCreateDto(PacienteCreateCommand createCommand) {

        return new Paciente(
                null,
                new TipoDocumentoPaciente(createCommand.getTipoDocumentoId()),
                new NumeroDocPaciente(createCommand.getNumeroDocumento()),
                new ApellidoPaciente(createCommand.getApellidos()),
                new NombrePaciente(createCommand.getNombres()),
                new FNacimientoPaciente(createCommand.getFechaNacimiento()),
                new EdadPaciente(createCommand.getEdad()),
                new EstadoPaciente(createCommand.getEstado()),
                new OcupacionPaciente(createCommand.getOcupacion()),
                new DireccionPaciente(createCommand.getDireccion()),
                new IdPaisPaciente(createCommand.getPaisId()),
                new DepartamentoPaciente(createCommand.getDepartamento()),
                new ProvinciaPaciente(createCommand.getProvincia()),
                new DistritoPaciente(createCommand.getDistrito()),
                new UbigeoPaciente(createCommand.getUbigeo()),
                new IdTipoPaciente(createCommand.getTipoPacienteId()),
                new EstadoCivilPaciente(createCommand.getEstadoCivil()),
                new SexoPaciente(createCommand.getSexo()),
                new NombreContactoPaciente(createCommand.getNombreContacto()),
                new TipoHistoriaPaciente(createCommand.getTipoHistoria()),
                new IdAseguradoraPaciente(createCommand.getAseguradoraId()),
                new IdEmpresaPaciente(createCommand.getEmpresaId()),
                new EmailPaciente(createCommand.getEmail()),
                new FotoPaciente(createCommand.getFotoPaciente()),
                new TituloPaciente(createCommand.getTitulo()),
                new ObservacionPaciente(createCommand.getObservacion()),
                new InformacionClinicaPaciente(createCommand.getInformacionClinicaId()),
                new IdEstudioPaciente(createCommand.getEstudioId()),
                new IdSedePaciente(createCommand.getSedeId()),
                new CelularPaciente(createCommand.getCelular()));
    }

    public Paciente fromUpdateDto(UUID uuid, PacienteEditCommand editCommand) {

        return new Paciente(
                new IdPaciente(editCommand.getPacienteId()),
                new TipoDocumentoPaciente(editCommand.getTipoDocumentoId()),
                new NumeroDocPaciente(editCommand.getNumeroDocumento()),
                new ApellidoPaciente(editCommand.getApellidos()),
                new NombrePaciente(editCommand.getNombres()),
                new FNacimientoPaciente(editCommand.getFechaNacimiento()),
                new EdadPaciente(editCommand.getEdad()),
                new EstadoPaciente(editCommand.getEstado()),
                new OcupacionPaciente(editCommand.getOcupacion()),
                new DireccionPaciente(editCommand.getDireccion()),
                new IdPaisPaciente(editCommand.getPaisId()),
                new DepartamentoPaciente(editCommand.getDepartamento()),
                new ProvinciaPaciente(editCommand.getProvincia()),
                new DistritoPaciente(editCommand.getDistrito()),
                new UbigeoPaciente(editCommand.getUbigeo()),
                new IdTipoPaciente(editCommand.getTipoPacienteId()),
                new EstadoCivilPaciente(editCommand.getEstadoCivil()),
                new SexoPaciente(editCommand.getSexo()),
                new NombreContactoPaciente(editCommand.getNombreContacto()),
                new TipoHistoriaPaciente(editCommand.getTipoHistoria()),
                new IdAseguradoraPaciente(editCommand.getAseguradoraId()),
                new IdEmpresaPaciente(editCommand.getEmpresaId()),
                new EmailPaciente(editCommand.getEmail()),
                new FotoPaciente(editCommand.getFotoPaciente()),
                new TituloPaciente(editCommand.getTitulo()),
                new ObservacionPaciente(editCommand.getObservacion()),
                new InformacionClinicaPaciente(editCommand.getInformacionClinicaId()),
                new IdEstudioPaciente(editCommand.getEstudioId()),
                new IdSedePaciente(editCommand.getSedeId()),
                new CelularPaciente(editCommand.getCelular()));

    }

    public PacienteDTO toDto(Paciente model) {
        return new PacienteDTO(model.getPacienteId(), model.getTipoDocumento(), model.getNumeroDocumento(),
                model.getApellidos(), model.getNombres(), model.getFechaNacimiento(),
                model.getEdad(), model.getEstado(), model.getOcupacion(), model.getDireccion(),
                model.getPaisId(), model.getDepartamento(), model.getProvincia(), model.getDistrito(),
                model.getUbigeo(), model.getTipoPacienteId(), model.getEstadoCivil(), model.getSexo(),
                model.getNombreContacto(), model.getTipoHistoria(), model.getAseguradoraId(),
                model.getEmpresaId(), model.getEmail(), model.getFotoPaciente(), model.getTitulo(),
                model.getObservacion(), model.getInformacionClinicaId(), model.getEstudioId(),
                model.getSedeId(), model.getCelular());
    }

}