package com.saludSystem.Catalogo.Medida.dominio;

import com.saludSystem.Catalogo.Medida.aplicacion.dtos.MedidaDTO;
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