package com.saludsystem.submodules.medico.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class DoctorDTO extends CrearDoctorDTO {

    private UUID doctorId;

}