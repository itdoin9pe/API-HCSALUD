package com.saludSystem.dtos.Paciente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarPacienteDTO extends CrearPacienteDTO{
    private UUID hospitalId;
    private UUID pacienteId;
}
