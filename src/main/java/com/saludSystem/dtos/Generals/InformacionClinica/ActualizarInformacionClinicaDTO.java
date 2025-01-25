package com.saludSystem.dtos.Generals.InformacionClinica;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarInformacionClinicaDTO extends CrearInformacionClinicaDTO{
    private UUID informacionClinicaId;
    private UUID hospitalId;
}
