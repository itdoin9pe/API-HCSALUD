package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.get.historialclinico.ConsultaDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.CrearConsultaDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.ActualizarConsultaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ConsultaService extends GenericService<
        ConsultaDTO,
        CrearConsultaDTO,
        ActualizarConsultaDTO,
        UUID> {
}