package com.saludsystem.application.catalogo.mapper;

import com.saludsystem.application.catalogo.dtos.get.MedidaDTO;
import com.saludsystem.application.catalogo.dtos.post.CrearMedidaDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarMedidaDTO;
import com.saludsystem.domain.catalogo.model.Medida;

import java.util.UUID;

public class MedidaMapper {

    public static Medida fromCreatDto(CrearMedidaDTO dto) {
        return new Medida(null, dto.getNombre(), dto.getEstado());
    }

    public static Medida fromUpdateDto(UUID uuid, ActualizarMedidaDTO dto){
        return new Medida(uuid, dto.getNombre(), dto.getEstado());
    }

    public static MedidaDTO toDto(Medida model) {
        return new MedidaDTO(model.getId(), model.getNombre(), model.getEstado());
    }

}