package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

import com.saludsystem.catalogo.application.dtos.res.AlergiaDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearAlergiaDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.in.response.AlergiaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Alergias")
@RestController
@RequestMapping("/api/Alergias")
public class AlergiaController extends GenericController<CrearAlergiaDTO, AlergiaDTO, UUID> {

    protected AlergiaController(GenericService<CrearAlergiaDTO, AlergiaDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlergiaResponse.class)))
    })
    public ListResponse<AlergiaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}