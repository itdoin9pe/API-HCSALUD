package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.CrearExploracionFisicaDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.ActualizarExploracionFisicaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ExploracionFisicaService extends GenericService<
        ExploracionFisicaDTO,
        CrearExploracionFisicaDTO,
        ActualizarExploracionFisicaDTO,
        UUID> {
}