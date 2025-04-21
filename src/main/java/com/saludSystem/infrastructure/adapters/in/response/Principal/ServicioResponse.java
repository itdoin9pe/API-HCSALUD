package com.saludSystem.infrastructure.adapters.in.response.Principal;

import com.saludSystem.application.dtos.Principal.GET.ServicioDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ServicioResponse {

    @Schema(description = "Lista de servicio")
    private List<ServicioDTO> data;

    @Schema(description = "Total de registro de servicios", example = "0")
    private long totalData;

}