package com.saludSystem.dtos.Doctor;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ActualizarDoctorDTO extends CrearDoctorDTO {
    private UUID hospitalId;
    private UUID pacienteId;
}
