package com.saludsystem.paciente.application.dto.get.historialclinico;

import com.saludsystem.paciente.application.dto.post.historialclinico.CrearExploracionFisicaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExploracionFisicaDTO extends CrearExploracionFisicaDTO {
    private UUID pacienteExploracionId;
}