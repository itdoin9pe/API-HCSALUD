package com.saludSystem.dtos.Paciente;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarPacienteDTO extends CrearPacienteDTO{
    private UUID hospitalId;
    private UUID pacienteId;
}
