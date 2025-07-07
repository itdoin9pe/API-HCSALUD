package com.saludsystem.application.services.paciente.historialclinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.CrearExploracionFisicaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ExploracionFisicaService extends GenericService<
        CrearExploracionFisicaDTO,
        ExploracionFisicaDTO,
        UUID> {
}