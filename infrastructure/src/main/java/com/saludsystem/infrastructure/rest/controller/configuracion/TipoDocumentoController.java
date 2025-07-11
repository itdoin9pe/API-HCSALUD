package com.saludsystem.infrastructure.rest.controller.configuracion;

import com.configuracion.application.dto.get.TipoDocumentoDTO;
import com.configuracion.application.dto.post.CrearTipoDocumentoDTO;
import com.configuracion.application.dto.put.ActualizarTipoDocumentoDTO;
import com.configuracion.infrastructure.adapters.in.response.TipoDocumentoListResponse;
import com.configuracion.application.services.GenericService;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TipoDocumentos")
@RestController
@RequestMapping("/api/TipoDocumentos")
public class TipoDocumentoController extends GenericController<TipoDocumentoDTO, CrearTipoDocumentoDTO,
        ActualizarTipoDocumentoDTO, UUID> {

    protected TipoDocumentoController(
            GenericService<TipoDocumentoDTO, CrearTipoDocumentoDTO, ActualizarTipoDocumentoDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoDocumentoListResponse.class)))
    })
    public ListResponse<TipoDocumentoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}