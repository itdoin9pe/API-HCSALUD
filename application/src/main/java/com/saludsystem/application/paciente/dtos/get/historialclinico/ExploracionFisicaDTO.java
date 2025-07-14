package com.saludsystem.application.paciente.dtos.get.historialclinico;

import com.saludsystem.application.paciente.dtos.post.historialclinico.CrearExploracionFisicaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ExploracionFisicaDTO extends CrearExploracionFisicaDTO {
    private UUID pacienteExploracionId;
}