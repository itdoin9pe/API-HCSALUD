package com.saludsystem.configuracion.infrastructure.adapters.in.controller;

import com.saludsystem.configuracion.application.dto.res.TipoDocumentoResponse;
import com.saludsystem.configuracion.application.dto.req.TipoDocumentoRequest;
import com.saludsystem.configuracion.infrastructure.adapters.in.response.TipoDocumentoListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TipoDocumentos")
@RestController
@RequestMapping("/api/TipoDocumentos")
public class TipoDocumentoController extends GenericController<TipoDocumentoRequest, TipoDocumentoResponse, UUID> {

    protected TipoDocumentoController(GenericService<TipoDocumentoRequest, TipoDocumentoResponse, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoDocumentoListResponse.class)))
    })
    public ListResponse<TipoDocumentoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}