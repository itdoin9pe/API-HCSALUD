package com.saludsystem.submodules.paciente.model.dtos.get;

import com.saludsystem.submodules.paciente.model.dtos.post.CrearPacienteDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PacienteDTO extends CrearPacienteDTO {

    private UUID pacienteId;

}