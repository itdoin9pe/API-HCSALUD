package com.saludsystem.paciente.application.dto.req.historialclinico;

import com.saludsystem.paciente.application.dto.base.historialclinico.ExploracionFisicaBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class ExploracionFisicaRequest extends ExploracionFisicaBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}