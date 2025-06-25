package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoTarjetaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoTarjetaDTO;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.TipoTarjetaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TipoTarjeta")
@RestController
@RequestMapping("/api/TipoTarjeta")
public class TipoTarjetaController extends GenericController<TipoTarjetaDTO, UUID,
        CrearTipoTarjetaDTO, ActualizarTipoTarjetaDTO> {

    protected TipoTarjetaController(GenericService<TipoTarjetaDTO, UUID, CrearTipoTarjetaDTO, ActualizarTipoTarjetaDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoTarjetaResponse.class)))
    })
    public ListResponse<TipoTarjetaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}