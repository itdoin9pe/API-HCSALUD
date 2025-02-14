package com.saludSystem.dtos.Doctor;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarDoctorDTO {

    private UUID hospitalId;
    private UUID userId;
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
    private byte[] fotoDoctor;
    private byte[] fotoFirma;

}