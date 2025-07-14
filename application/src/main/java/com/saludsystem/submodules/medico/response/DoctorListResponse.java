package com.saludsystem.submodules.medico.response;

import com.saludsystem.submodules.medico.dtos.DoctorDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DoctorListResponse {

    @Schema(description = "Lista de Doctores")
    private List<DoctorDTO> data;

    @Schema(description = "Número total de Doctores", example = "0")
    private long totalData;

}