package com.saludsystem.paciente.application.dto.res.historialclinico;

import com.saludsystem.paciente.application.dto.base.historialclinico.ConsultaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ConsultaResponse extends ConsultaBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}