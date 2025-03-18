package com.saludSystem.Paciente.aplicacion.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class ActualizarPacienteDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pacienteId;

    @NotBlank(message = "El tipo documento no puede estar vacío")
    private String tipoDocumentoId;

    @NotBlank(message = "El número de documento no puede estar vacío")
    private String numeroDocumento;

    @NotBlank(message = "Los apellidos del paciente no pueden estar vacíos")
    private String apellidos;

    @NotBlank(message = "Los nombres del paciente no pueden estar vacíos")
    private String nombres;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaNacimiento;

    @Schema(description = "Edad (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Integer edad;

    @NotNull(message = "El estado no puede estar vacío")
    @Schema(description = "Estado del paciente (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Integer estado;

    private String ocupacion;

    private String direccion;

    @Schema(description = "ID del país (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Integer paisId;

    private String ubigeo;

    @NotNull(message = "El tipo de paciente no puede estar vacío")
    @Schema(description = "tipo paciente (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Long tipoPacienteId;

    private String estadoCivil;

    private String sexo;

    private String nombreContacto;

    private String tipoHistoria;

    private UUID aseguradoraId;

    private UUID empresaId;

    @Email(message = "El email debe ser válido")
    private String email;

    private String fotoPaciente;

    private String titulo;

    private String observacion;

    private UUID informacionClinicaId;

    private UUID estudioId;

    private UUID sedeId;

    @NotBlank(message = "El número de celular no puede estar vacío")
    private String celular;

}