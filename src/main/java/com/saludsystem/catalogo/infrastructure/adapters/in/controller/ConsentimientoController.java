package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

import com.saludsystem.catalogo.application.dtos.res.ConsentimientoRequest;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.in.response.ConsentimientoListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Consentimientos")
@RestController
@RequestMapping("/api/Consentimientos")
public class ConsentimientoController extends GenericController<com.saludsystem.catalogo.application.dtos.req.ConsentimientoRequest, ConsentimientoRequest, UUID> {

    protected ConsentimientoController(GenericService<com.saludsystem.catalogo.application.dtos.req.ConsentimientoRequest, ConsentimientoRequest, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsentimientoListResponse.class)))
    })
    public ListResponse<ConsentimientoRequest> getAllPaginated(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}