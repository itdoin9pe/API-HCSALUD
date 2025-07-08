package com.saludsystem.paciente.application.dto.req.historialclinico;

import com.saludsystem.paciente.application.dto.base.historialclinico.AntecedenteBaseDTO;
import lombok.Data;
import java.util.UUID;

@Data
public class AntecedenteRequest extends AntecedenteBaseDTO {

    private UUID pacEnfermedadActualId;

}