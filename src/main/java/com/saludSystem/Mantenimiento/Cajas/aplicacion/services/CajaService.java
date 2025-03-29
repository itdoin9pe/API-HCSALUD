package com.saludSystem.Mantenimiento.Cajas.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.dtos.ActualizarCajaDTO;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.dtos.CajaDTO;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.dtos.CrearCajaDTO;

import java.util.List;
import java.util.UUID;

public interface CajaService {

    ApiResponse saveCaja(CrearCajaDTO crearCajaDTO);

    List<CajaDTO> getCajaList();

    ListResponse<CajaDTO> getAllCaja(UUID hospitalId, int page, int rows);

    CajaDTO getCajaById(UUID cajaId);

    ApiResponse updateCaja(UUID cajaId, ActualizarCajaDTO actualizarCajaDTO);

    ApiResponse deleteCaja(UUID cajaId);

}