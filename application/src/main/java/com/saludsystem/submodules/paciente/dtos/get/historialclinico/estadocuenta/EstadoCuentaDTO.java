package com.saludsystem.submodules.paciente.dtos.get.historialclinico.estadocuenta;

import com.saludsystem.submodules.paciente.dtos.post.historialclinico.estadocuenta.CrearEstadoCuentaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstadoCuentaDTO extends CrearEstadoCuentaDTO {

    private UUID pacEstadoCuentaId;

}