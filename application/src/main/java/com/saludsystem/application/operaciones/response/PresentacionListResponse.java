package com.saludsystem.application.operaciones.response;

import com.saludsystem.application.operaciones.dtos.get.PresentacionDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class PresentacionListResponse {

    @Schema(description = "Lista de presentaciones")
    private List<PresentacionDTO> data;

    @Schema(description = "Total de registros de Presentacion", example = "0")
    private long totalData;

}