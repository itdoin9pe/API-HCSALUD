package com.saludsystem.medico.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class DoctorDTO extends CrearDoctorDTO {

    private UUID doctorId;

}