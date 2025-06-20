package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarTipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearTipoConceptoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.TipoConceptoDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.Catalogo.TipoConceptoResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposConceptos")
@RestController
@RequestMapping("/api/TiposConceptos")
public class TipoConceptoController extends GenericController<TipoConceptoDTO, UUID,
        CrearTipoConceptoDTO, ActualizarTipoConceptoDTO> {

    protected TipoConceptoController(GenericService<TipoConceptoDTO, UUID,
            CrearTipoConceptoDTO, ActualizarTipoConceptoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoConceptoResponse.class)))
    })
    public ListResponse<TipoConceptoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}