package com.saludsystem.submodules.medico.dtos;

import com.saludsystem.submodules.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarDoctorDTO extends BaseDTO {

    private UUID pacienteId;
    private String tipoDocumento;
    private String numeroDocumento;
    private String apellidos;
    private String nombres;
    private String direccion;
    private String correo;
    private String abreviatura;
    private String rne;
    private LocalDate fechaNacimiento;
    private String celular;
    private String telefono;
    private String sexo;
    private UUID especialidadId;
    private String colegiatura;
    private String color;
    private Integer estado;
    private String fotoDoctor;
    private String fotoFirma;

}