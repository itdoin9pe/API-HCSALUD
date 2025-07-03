package com.saludsystem.infrastructure.adapters.in.controllers.configuracion;

import com.saludsystem.application.dtos.configuracion.get.TipoDocumentoDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearTipoDocumentoDTO;
import com.saludsystem.application.dtos.configuracion.put.ActualizarTipoDocumentoDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.configuracion.TipoDocumentoResponse;
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