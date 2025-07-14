package com.saludsystem.submodules.catalogo.response;

import com.saludsystem.submodules.catalogo.dtos.get.MedidaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class MedidaListResponse {

    @Schema(description = "Lista de Medidas")
    private List<MedidaDTO> data;

    @Schema(description = "Numero total de medidas registradas", example = "0")
    private long totalData;

}