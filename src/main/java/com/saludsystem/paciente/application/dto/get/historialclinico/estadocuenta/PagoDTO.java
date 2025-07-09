package com.saludsystem.paciente.application.dto.get.historialclinico.estadocuenta;

import com.saludsystem.paciente.application.dto.post.historialclinico.estadocuenta.CrearPagoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PagoDTO extends CrearPagoDTO {

    private UUID pecPagoId;

}