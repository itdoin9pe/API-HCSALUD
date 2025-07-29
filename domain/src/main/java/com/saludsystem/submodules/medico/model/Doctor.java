package com.saludsystem.submodules.medico.model;

import com.saludsystem.submodules.configuracion.model.entity.vo.usuario.NumeroDocumento;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Doctor {

    private DoctorId id;
    private TipoDocumento tipoDocumento;
    private NumeroDocumento numeroDocumento;
    private Apellido apellidos;
    private Nombre nombres;
    private Direccion direccion;
    private Correo correo;
    private String abreviatura;
    private Rne rne;
    private LocalDate fechaNacimiento;
    private Celular celular;
    private Telefono telefono;
    private String sexo;
    private EspecialidadId especialidadId;
    private Colegiatura colegiatura;
    private String color;
    private Integer estado;
    private String fotoDoctor;
    private String fotoFirma;

}
