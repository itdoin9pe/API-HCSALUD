package com.saludSystem.dtos.Paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CrearPacienteDTO {
    @NotNull
    private Long tipoDocumentoId;

    @NotBlank
    private String numeroDocumento;

    @NotBlank
    private String apellidos;

    @NotBlank
    private String nombres;

    @NotNull
    private Date fechaNacimiento;

    private Integer edad;
    private Integer estado;
    private String ocupacion;
    private String direccion;

    @NotNull
    private Long paisId;

    private String ubigeo;
    private Integer tipoPacienteId;
    private String estadoCivil;
    private String sexo;
    private String nombreContacto;
    private String tipoHistoria;
    private Integer aseguradoraId;
    private Integer empresaId;

    @Email
    private String email;

    private String titulo;
    private String observacion;
    private Integer informacionClinicaId;
    private Integer estudioId;
    private Long sedeId;
    private String celular;
}
