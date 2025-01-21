package com.saludSystem.services.modules.configuration.SysSalud;

import com.saludSystem.dtos.configuration.SysSaludDTO;
import com.saludSystem.entities.configuracion.SysSalud;

import java.util.List;

public interface SysSaludService {
    SysSalud saveClinica(SysSaludDTO sysSaludDTO);
    List<SysSaludDTO> getAllClinica(int page, int rows);
    long getTotalCount();
}
