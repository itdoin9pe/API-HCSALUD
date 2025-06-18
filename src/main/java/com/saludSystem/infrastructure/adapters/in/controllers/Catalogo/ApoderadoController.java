package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearApoderadoDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Apoderados")
@RestController
@RequestMapping("/api/Apoderados")
public class ApoderadoController extends GenericController<
        ApoderadoDTO,
        UUID,
        CrearApoderadoDTO,
        ActualizarApoderadoDTO> {

    protected ApoderadoController(GenericService<ApoderadoDTO, UUID,
            CrearApoderadoDTO, ActualizarApoderadoDTO> genericService) {
        super(genericService);
    }
}