package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTarifarioDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTarifarioDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TarifarioDTO;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.TarifarioResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Tarifarios")
@RestController
@RequestMapping("/api/Tarifarios")
public class TarifarioController extends GenericController<TarifarioDTO, UUID,
        CrearTarifarioDTO, ActualizarTarifarioDTO> {

    protected TarifarioController(GenericService<TarifarioDTO, UUID, CrearTarifarioDTO, ActualizarTarifarioDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TarifarioResponse.class)))
    })
    public ListResponse<TarifarioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}