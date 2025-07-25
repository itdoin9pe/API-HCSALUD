package com.saludsystem.submodules.principal.response;

import com.saludsystem.submodules.principal.model.dtos.get.InformacionClinicaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class InformacionClinicaListResponse {

    @Schema(description = "Lista de Informaciones Clinicas")
    private List<InformacionClinicaDTO> data;

    @Schema(description = "Número total de Informaciones Clinicas", example = "0")
    private long totalData;

}