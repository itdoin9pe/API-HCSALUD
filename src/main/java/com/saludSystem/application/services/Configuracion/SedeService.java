package com.saludSystem.application.services.Configuracion;

import com.saludSystem.application.dtos.Configuracion.GET.SedeDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearSedeDTO;
import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarSedeDTO;
import com.saludSystem.application.services.GenericService;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public interface SedeService extends GenericService<
        SedeDTO,
        UUID,
        CrearSedeDTO,
        ActualizarSedeDTO> {
}