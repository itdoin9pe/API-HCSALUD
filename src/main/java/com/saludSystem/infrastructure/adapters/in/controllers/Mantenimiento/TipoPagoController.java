package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoPagoDTO;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.TipoPagoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposPagos")
@RestController
@RequestMapping("/api/TiposPagos")
public class TipoPagoController extends GenericController<TipoPagoDTO, UUID, CrearTipoPagoDTO, ActualizarTipoPagoDTO> {

    protected TipoPagoController(GenericService<TipoPagoDTO, UUID, CrearTipoPagoDTO, ActualizarTipoPagoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoPagoResponse.class)))
    })
    public ListResponse<TipoPagoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}