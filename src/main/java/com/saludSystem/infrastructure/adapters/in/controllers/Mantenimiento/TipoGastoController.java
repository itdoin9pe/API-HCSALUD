package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoGastoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoGastoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoGastoDTO;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.TIpoGastoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "ConceptosGastos")
@RestController
@RequestMapping("/api/ConceptosGastos")
public class TipoGastoController extends GenericController<TipoGastoDTO, UUID,
        CrearTipoGastoDTO, ActualizarTipoGastoDTO> {

    protected TipoGastoController(GenericService<TipoGastoDTO, UUID, CrearTipoGastoDTO, ActualizarTipoGastoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TIpoGastoResponse.class)))
    })
    public ListResponse<TipoGastoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}