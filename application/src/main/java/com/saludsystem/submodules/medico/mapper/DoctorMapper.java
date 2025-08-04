package com.saludsystem.submodules.medico.mapper;

import com.saludsystem.submodules.configuracion.model.vo.usuario.NumeroDocumento;
import com.saludsystem.submodules.medico.model.dtos.DoctorCreateCommand;
import com.saludsystem.submodules.medico.model.dtos.DoctorEditCommand;
import com.saludsystem.submodules.medico.model.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.model.*;
import com.saludsystem.submodules.medico.model.vo.*;

import java.util.UUID;

public class DoctorMapper {

    public Doctor fromCreateDto(DoctorCreateCommand createCommand) {
        return new Doctor(
                null,
                new TipoDocumento(createCommand.getTipoDocumento()),
                new NumeroDocumento(createCommand.getNumeroDocumento()),
                new Apellido(createCommand.getApellidos()),
                new Nombre(createCommand.getNombres()),
                new Direccion(createCommand.getDireccion()),
                new Correo(createCommand.getCorreo()),
                createCommand.getAbreviatura(),
                new Rne(createCommand.getRne()),
                createCommand.getFechaNacimiento(),
                new Celular(createCommand.getCelular()),
                new Telefono(createCommand.getTelefono()),
                createCommand.getSexo(),
                new EspecialidadId(createCommand.getEspecialidadId()),
                new Colegiatura(createCommand.getColegiatura()),
                createCommand.getColor(),
                createCommand.getEstado(),
                createCommand.getFotoDoctor(),
                createCommand.getFotoFirma());
    }

    public Doctor fromUpdateDto(UUID uuid, DoctorEditCommand editCommand) {
        return new Doctor(
                new DoctorId(editCommand.getDoctorId()),
                new TipoDocumento(editCommand.getTipoDocumento()),
                new NumeroDocumento(editCommand.getNumeroDocumento()),
                new Apellido(editCommand.getApellidos()),
                new Nombre(editCommand.getNombres()),
                new Direccion(editCommand.getDireccion()),
                new Correo(editCommand.getCorreo()),
                editCommand.getAbreviatura(),
                new Rne(editCommand.getRne()),
                editCommand.getFechaNacimiento(),
                new Celular(editCommand.getCelular()),
                new Telefono(editCommand.getTelefono()),
                editCommand.getSexo(),
                new EspecialidadId(editCommand.getEspecialidadId()),
                new Colegiatura(editCommand.getColegiatura()),
                editCommand.getColor(),
                editCommand.getEstado(),
                editCommand.getFotoDoctor(),
                editCommand.getFotoFirma());
    }

    public DoctorDTO toDto(Doctor model) {
        return new DoctorDTO(model.getId(), model.getTipoDocumento(), model.getNumeroDocumento(),
                model.getApellidos(), model.getNombres(), model.getDireccion(), model.getCorreo(),
                model.getAbreviatura(), model.getRne(), model.getFechaNacimiento(), model.getCelular(),
                model.getTelefono(), model.getSexo(), model.getEspecialidadId(), model.getColegiatura(),
                model.getColor(), model.getEstado(), model.getFotoDoctor(),
                model.getFotoFirma());
    }

}
