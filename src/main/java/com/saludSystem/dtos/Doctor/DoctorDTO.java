package com.saludSystem.dtos.Doctor;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class DoctorDTO {

    private UUID doctorId;
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

    @Schema(description = "Estado del Registro de Medico (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;
    private byte[] fotoDoctor;
    private byte[] fotoFirma;

}