package com.saludSystem.infrastructure.adapters.in.controllers.Configuracion;

import com.saludSystem.application.dtos.Configuracion.GET.TipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearTipoDocumentoDTO;
import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarTipoDocumentoDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.Configuracion.TipoDocumentoResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TipoDocumentos")
@RestController
@RequestMapping("/api/TipoDocumentos")
public class TipoDocumentoController extends GenericController<TipoDocumentoDTO, UUID,
        CrearTipoDocumentoDTO, ActualizarTipoDocumentoDTO> {

    protected TipoDocumentoController(GenericService<TipoDocumentoDTO, UUID,
            CrearTipoDocumentoDTO, ActualizarTipoDocumentoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoDocumentoResponse.class)))
    })
    public ListResponse<TipoDocumentoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}