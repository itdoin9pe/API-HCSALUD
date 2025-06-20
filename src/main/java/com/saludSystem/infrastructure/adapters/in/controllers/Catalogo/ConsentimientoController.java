package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.ConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarConsentimientoDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.Catalogo.ConsentimientoResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Consentimientos")
@RestController
@RequestMapping("/api/Consentimientos")
public class ConsentimientoController extends GenericController<
        ConsentimientoDTO, UUID, CrearConsentimientoDTO, ActualizarConsentimientoDTO> {

    protected ConsentimientoController(GenericService<ConsentimientoDTO, UUID, CrearConsentimientoDTO,
            ActualizarConsentimientoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsentimientoResponse.class)))
    })
    public ListResponse<ConsentimientoDTO> getAllPaginated(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}