package com.saludsystem.application.services.paciente.historialclinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.ConsultaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.CrearConsultaDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.ActualizarConsultaDTO;
import com.saludsystem.application.services.GenericService;

import java.util.UUID;

public interface ConsultaService extends GenericService<
        ConsultaDTO,
        UUID,
        CrearConsultaDTO,
        ActualizarConsultaDTO> {
}