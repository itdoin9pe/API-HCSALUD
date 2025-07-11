package com.saludsystem.domain.paciente.port.in.service.historialclinico;

import com.saludsystem.application.dto.get.historialclinico.ConsultaDTO;
import com.saludsystem.application.dto.post.historialclinico.CrearConsultaDTO;
import com.saludsystem.application.dto.put.historialclinico.ActualizarConsultaDTO;
import com.configuracion.application.services.GenericService;

import java.util.UUID;

public interface ConsultaService extends GenericService<
        ConsultaDTO,
        CrearConsultaDTO,
        ActualizarConsultaDTO,
        UUID> {
}