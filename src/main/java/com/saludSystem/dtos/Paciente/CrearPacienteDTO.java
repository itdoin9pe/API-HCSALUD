package com.saludSystem.dtos.Paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class CrearPacienteDTO {
    private Long tipoDocumentoId;
    private String numeroDocumento;
    private String apellidos;
    private String nombres;
    private Date fechaNacimiento;
    private Integer edad;
    private Integer estado;
    private String ocupacion;
    private String direccion;
    private Long paisId;
    private String ubigeo;
    private Integer tipoPacienteId;
    private String estadoCivil;
    private String sexo;
    private String nombreContacto;
    private String tipoHistoria;
    private Integer aseguradoraId;
    private Integer empresaId;
    private String email;
    private byte[] fotoPaciente;
    private String titulo;
    private String observacion;
    private Long informacionClinicaId;
    private Integer estudioId;
    private Long sedeId;
    private String celular;
}
