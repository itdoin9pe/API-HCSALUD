package com.saludsystem.paciente.application.service.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.ConsultaDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.CrearConsultaDTO;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface ConsultaService extends GenericService<
        CrearConsultaDTO,
        ConsultaDTO,
        UUID> {
}