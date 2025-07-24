package com.saludsystem.submodules.medico.dtos;

import com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario.NumeroDocumento;
import com.saludsystem.submodules.medico.model.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class DoctorDTO extends CrearDoctorDTO {

    private UUID doctorId;

    public DoctorDTO(DoctorId id, TipoDocumento tipoDocumento, NumeroDocumento numeroDocumento,
                     Apellido apellidos, Nombre nombres, Direccion direccion, Correo correo,
                     String abreviatura, Rne rne, LocalDate fechaNacimiento, Celular celular,
                     Telefono telefono, String sexo, EspecialidadId especialidadId,
                     Colegiatura colegiatura, String color, Integer estado,
                     String fotoDoctor, String fotoFirma) {
        this.setDoctorId(id.value());
        this.setTipoDocumento(tipoDocumento.value());
        this.setNumeroDocumento(numeroDocumento.value());
        this.setApellidos(apellidos.value());
        this.setNombres(nombres.value());
        this.setDireccion(direccion.value());
        this.setCorreo(correo.value());
        this.setAbreviatura(abreviatura);
        this.setRne(rne.value());
        this.setFechaNacimiento(fechaNacimiento);
        this.setCelular(celular.value());
        this.setTelefono(telefono.value());
        this.setSexo(sexo);
        this.setEspecialidadId(especialidadId.value());
        this.setColegiatura(colegiatura.value());
        this.setColor(color);
        this.setEstado(estado);
        this.setFotoDoctor(fotoDoctor);
        this.setFotoFirma(fotoFirma);
    }
}