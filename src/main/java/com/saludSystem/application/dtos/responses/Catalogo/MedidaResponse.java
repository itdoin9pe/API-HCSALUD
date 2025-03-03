package com.saludSystem.application.dtos.responses.Catalogo;

import com.saludSystem.application.dtos.catalago.Medida.MedidaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MedidaResponse {

    @Schema(description = "Lista de Medidas")
    private List<MedidaDTO> data;

    @Schema(description = "Numero total de medidas registradas", example = "0")
    private long totalData;

}
