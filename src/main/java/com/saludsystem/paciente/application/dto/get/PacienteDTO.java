package com.saludsystem.paciente.application.dto.get;

import com.saludsystem.paciente.application.dto.post.CrearPacienteDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PacienteDTO extends CrearPacienteDTO {

    private UUID pacienteId;

}