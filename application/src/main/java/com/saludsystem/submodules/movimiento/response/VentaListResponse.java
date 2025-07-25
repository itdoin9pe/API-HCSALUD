package com.saludsystem.submodules.movimiento.response;

import com.saludsystem.submodules.movimiento.model.dtos.get.VentaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class VentaListResponse {

    @Schema(description = "Lista de registro para ventas")
    private List<VentaDTO> data;

    @Schema(description = "Total de registros para ventas", example = "0")
    private long totalData;

}