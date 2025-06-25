package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarMonedaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearMonedaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.MonedaDTO;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.MonedaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposMonedas")
@RestController
@RequestMapping("/api/TiposMonedas")
public class MonedaController extends GenericController<MonedaDTO, UUID, CrearMonedaDTO, ActualizarMonedaDTO> {

    protected MonedaController(GenericService<MonedaDTO, UUID, CrearMonedaDTO, ActualizarMonedaDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MonedaResponse.class)))
    })
    public ListResponse<MonedaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}