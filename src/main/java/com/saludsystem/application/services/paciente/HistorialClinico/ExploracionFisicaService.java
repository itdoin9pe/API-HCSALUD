package com.saludsystem.application.services.paciente.HistorialClinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.CrearExploracionFisicaDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.ActualizarExploracionFisicaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ExploracionFisicaService extends GenericService<
        ExploracionFisicaDTO,
        UUID,
        CrearExploracionFisicaDTO,
        ActualizarExploracionFisicaDTO> {
}