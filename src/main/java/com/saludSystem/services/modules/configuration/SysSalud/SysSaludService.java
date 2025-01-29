package com.saludSystem.services.modules.configuration.SysSalud;

import com.saludSystem.dtos.configuration.SysSaludModule.CrearSysSaludDTO;
import com.saludSystem.dtos.configuration.SysSaludModule.SysSaludDTO;
import com.saludSystem.entities.configuracion.SysSalud;

import java.util.List;

public interface SysSaludService {
    SysSalud saveClinica(CrearSysSaludDTO crearSysSaludDTO);
    List<SysSaludDTO> getAllClinica(int page, int rows);
    long getTotalCount();
}
