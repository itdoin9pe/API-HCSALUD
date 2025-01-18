package com.saludSystem.dtos.responses.Generals;

import com.saludSystem.dtos.Generals.AseguradoraDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class AseguradoraResponse {

    @Schema(description = "Lista de aseguradoras")
    private List<AseguradoraDTO> data;

    @Schema(description = "Número total de aseguradoras")
    private long totalData;

    // Getters y setters

    public List<AseguradoraDTO> getData() {
        return data;
    }

    public void setData(List<AseguradoraDTO> data) {
        this.data = data;
    }

    public long getTotalData() {
        return totalData;
    }

    public void setTotalData(long totalData) {
        this.totalData = totalData;
    }

}
