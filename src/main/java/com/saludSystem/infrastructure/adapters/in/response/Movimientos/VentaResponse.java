package com.saludSystem.infrastructure.adapters.in.response.Movimientos;

import com.saludSystem.application.dtos.Movimientos.GET.VentaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class VentaResponse {

    @Schema(description = "Lista de registro para ventas")
    private List<VentaDTO> data;

    @Schema(description = "Total de registros para ventas", example = "0")
    private long totalData;

}