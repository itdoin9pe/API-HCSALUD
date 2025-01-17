package com.saludSystem.dtos.Paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Blob;
import java.util.Date;

@Data
public class CrearPacienteDTO {

    @NotBlank(message = "El tipo documento no puede estar vacío")
    private String tipoDocumentoId;

    @NotBlank(message = "El número de documento no puede estar vacío")
    private String numeroDocumento;

    @NotBlank(message = "Los apellidos del paciente no pueden estar vacíos")
    private String apellidos;

    @NotBlank(message = "Los nombres del paciente no pueden estar vacíos")
    private String nombres;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    private Date fechaNacimiento;

    private Integer edad;

    @NotNull(message = "El estado no puede estar vacío")
    private Integer estado;

    private String ocupacion;

    private String direccion;

    private Integer paisId;

    private String ubigeo;

    @NotNull(message = "El tipo de paciente no puede estar vacío")
    private int tipoPacienteId;

    private String estadoCivil;

    private String sexo;

    private String nombreContacto;

    private String tipoHistoria;

    private int aseguradoraId;

    private Integer empresaId;

    @Email(message = "El email debe ser válido")
    private String email;

    private byte[] fotoPaciente;

    //private String fotoPaciente;

    private String titulo;

    private String observacion;

    private Integer informacionClinicaId;

    private Integer estudioId;

    private Integer sedeId;

    @NotBlank(message = "El número de celular no puede estar vacío")
    private String celular;

}