package com.saludsystem.submodules.paciente.dtos.get.historialclinico;

import com.saludsystem.submodules.paciente.dtos.post.historialclinico.CrearPacienteAlergiaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PacienteAlergiaDTO extends CrearPacienteAlergiaDTO {

    private UUID pacienteAlergiaId;

}