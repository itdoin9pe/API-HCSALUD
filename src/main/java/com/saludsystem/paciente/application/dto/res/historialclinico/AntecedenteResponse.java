package com.saludsystem.paciente.application.dto.res.historialclinico;

import com.saludsystem.paciente.application.dto.base.historialclinico.AntecedenteBaseDTO;
import lombok.Data;
import java.util.UUID;

@Data
public class AntecedenteResponse extends AntecedenteBaseDTO {
    private UUID hospitalId;
    private UUID userId;
}