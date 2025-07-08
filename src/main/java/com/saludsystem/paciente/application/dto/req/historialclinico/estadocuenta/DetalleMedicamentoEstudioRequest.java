package com.saludsystem.paciente.application.dto.req.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.base.historialclinico.estadocuenta.DetalleMedicamentoEstudioBaseDTO;
import lombok.Data;

import java.util.UUID;

@Data
public class DetalleMedicamentoEstudioRequest extends DetalleMedicamentoEstudioBaseDTO {

    private UUID pacDetalleMedicamentoId;

}