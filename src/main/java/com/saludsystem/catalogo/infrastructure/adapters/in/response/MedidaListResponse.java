package com.saludsystem.catalogo.infrastructure.adapters.in.response;

import com.saludsystem.catalogo.application.dtos.res.MedidaRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class MedidaListResponse {

    @Schema(description = "Lista de Medidas")
    private List<MedidaRequest> data;

    @Schema(description = "Numero total de medidas registradas", example = "0")
    private long totalData;

}