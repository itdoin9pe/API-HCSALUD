package com.saludSystem.dtos.Generals.Empresa;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarEmpresaDTO extends CrearEmpresaDTO{
    private UUID hospitalId;
    private UUID empresaId;
}
