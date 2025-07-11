package com.saludsystem.application.paciente.dtos.get.historialclinico.estadocuenta;

import com.saludsystem.application.dto.post.historialclinico.estadocuenta.CrearPagoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PagoDTO extends CrearPagoDTO {

    private UUID pecPagoId;

}