package com.saludsystem.paciente.application.dto.get.historialclinico;

import com.saludsystem.paciente.application.dto.post.historialclinico.CrearPacienteAlergiaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PacienteAlergiaDTO extends CrearPacienteAlergiaDTO {

    private UUID pacienteAlergiaId;

}