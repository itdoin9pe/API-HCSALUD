package com.saludSystem.Mantenimiento.Banco.aplicacion.services;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.ActualizarBancoDTO;
import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.BancoDTO;
import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.CrearBancoDTO;

import java.util.List;
import java.util.UUID;

public interface BancoService {

    ApiResponse saveBanco(CrearBancoDTO crearBancoDTO);

    List<BancoDTO> getBancoList();

    BancoDTO getBancoById(UUID bancoId);

    ListResponse<BancoDTO> getAllBanco(UUID hospitalId, int page, int rows);

    ApiResponse updateBanco(UUID bancoId, ActualizarBancoDTO actualizarBancoDTO);

    ApiResponse deleteBanco(UUID bancoId);

}
