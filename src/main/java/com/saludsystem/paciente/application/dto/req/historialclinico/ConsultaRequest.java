package com.saludsystem.paciente.application.dto.req.historialclinico;

import com.saludsystem.paciente.application.dto.base.historialclinico.ConsultaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ConsultaRequest extends ConsultaBaseDTO {
    protected UUID pacienteConsultaId;
}