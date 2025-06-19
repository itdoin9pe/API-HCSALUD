package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.MedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedicamentoDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Medicamentos")
@RestController
@RequestMapping("/api/Medicamentos")
public class MedicamentoController extends GenericController<
        MedicamentoDTO,
        UUID,
        CrearMedicamentoDTO,
        ActualizarMedicamentoDTO> {

    protected MedicamentoController(GenericService<MedicamentoDTO, UUID,
            CrearMedicamentoDTO, ActualizarMedicamentoDTO> genericService) {
        super(genericService);
    }
}