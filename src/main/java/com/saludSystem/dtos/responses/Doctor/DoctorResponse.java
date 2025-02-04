package com.saludSystem.dtos.responses.Doctor;

import com.saludSystem.dtos.Doctor.DoctorDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorResponse {
    @Schema(description = "Lista de Doctores")
    private List<DoctorDTO> data;

    @Schema(description = "Número total de Doctores", example = "0")
    private long totalData;
}
