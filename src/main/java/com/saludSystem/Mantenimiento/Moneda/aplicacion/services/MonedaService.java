package com.saludSystem.Mantenimiento.Moneda.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos.ActualizarMonedaDTO;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos.CrearMonedaDTO;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos.MonedaDTO;

import java.util.List;
import java.util.UUID;

public interface MonedaService {

    ApiResponse saveMoneda(CrearMonedaDTO crearMonedaDTO);

    ListResponse<MonedaDTO> getAllMoneda(UUID hospitalId, int page, int rows);

    List<MonedaDTO> getMonedaList();

    MonedaDTO getMonedaById(UUID monedaId);

    ApiResponse updateMoneda(UUID monedaId, ActualizarMonedaDTO actualizarMonedaDTO);

    ApiResponse deleteMoneda(UUID monedaId);

}