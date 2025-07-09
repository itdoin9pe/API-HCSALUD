package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

import com.saludsystem.catalogo.application.dtos.get.ConsentimientoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearConsentimientoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarConsentimientoDTO;
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
public class ConsentimientoController extends GenericController<ConsentimientoDTO,
        CrearConsentimientoDTO, ActualizarConsentimientoDTO, UUID> {

    protected ConsentimientoController(GenericService<ConsentimientoDTO, CrearConsentimientoDTO, ActualizarConsentimientoDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsentimientoListResponse.class)))
    })
    public ListResponse<ConsentimientoDTO> getAllPaginated(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}