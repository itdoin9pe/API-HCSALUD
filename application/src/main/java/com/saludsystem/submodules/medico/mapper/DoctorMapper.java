package com.saludsystem.submodules.medico.mapper;

import com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario.NumeroDocumento;
import com.saludsystem.submodules.medico.dtos.ActualizarDoctorDTO;
import com.saludsystem.submodules.medico.dtos.CrearDoctorDTO;
import com.saludsystem.submodules.medico.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.model.*;

import java.util.UUID;

public class DoctorMapper {

    public static Doctor fromCreateDto(CrearDoctorDTO dto) {
        return new Doctor(
                null,
                new TipoDocumento(dto.getTipoDocumento()),
                new NumeroDocumento(dto.getNumeroDocumento()),
                new Apellido(dto.getApellidos()),
                new Nombre(dto.getNombres()),
                new Direccion(dto.getDireccion()),
                new Correo(dto.getCorreo()),
                dto.getAbreviatura(),
                new Rne(dto.getRne()),
                dto.getFechaNacimiento(),
                new Celular(dto.getCelular()),
                new Telefono(dto.getTelefono()),
                dto.getSexo(),
                new EspecialidadId(dto.getEspecialidadId()),
                new Colegiatura(dto.getColegiatura()),
                dto.getColor(),
                dto.getEstado(),
                dto.getFotoDoctor(),
                dto.getFotoFirma());
    }

    public static Doctor fromUpdateDto(UUID uuid, ActualizarDoctorDTO dto) {
        return new Doctor(
                new DoctorId(dto.getDoctorId()),
                new TipoDocumento(dto.getTipoDocumento()),
                new NumeroDocumento(dto.getNumeroDocumento()),
                new Apellido(dto.getApellidos()),
                new Nombre(dto.getNombres()),
                new Direccion(dto.getDireccion()),
                new Correo(dto.getCorreo()),
                dto.getAbreviatura(),
                new Rne(dto.getRne()),
                dto.getFechaNacimiento(),
                new Celular(dto.getCelular()),
                new Telefono(dto.getTelefono()),
                dto.getSexo(),
                new EspecialidadId(dto.getEspecialidadId()),
                new Colegiatura(dto.getColegiatura()),
                dto.getColor(),
                dto.getEstado(),
                dto.getFotoDoctor(),
                dto.getFotoFirma());
    }

    public static DoctorDTO toDto(Doctor model) {
        return new DoctorDTO(model.getId(), model.getTipoDocumento(), model.getNumeroDocumento(),
                model.getApellidos(), model.getNombres(), model.getDireccion(), model.getCorreo(),
                model.getAbreviatura(), model.getRne(), model.getFechaNacimiento(), model.getCelular(),
                model.getTelefono(), model.getSexo(), model.getEspecialidadId(), model.getColegiatura(),
                model.getColor(), model.getEstado(), model.getFotoDoctor(),
                model.getFotoFirma());
    }
}
