package com.saludsystem.movimientos.infrastructure.adapters.in.response;

import com.saludsystem.movimientos.application.dto.res.AlmacenDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class AlmacenResponse {

    @Schema(description = "Lista de alamacenes")
    private List<AlmacenDTO> data;

    @Schema(description = "Total de almacences", example = "0")
    private long totalData;

}