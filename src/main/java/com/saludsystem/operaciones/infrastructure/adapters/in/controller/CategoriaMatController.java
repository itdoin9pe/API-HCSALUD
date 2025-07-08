package com.saludsystem.operaciones.infrastructure.adapters.in.controller;

import com.saludsystem.operaciones.application.dto.res.CategoriaMatResponse;
import com.saludsystem.operaciones.application.dto.req.CategotiaMatRequest;
import com.saludsystem.operaciones.infrastructure.adapters.in.response.CategoriaMatListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CategoriasMateriales")
@RestController
@RequestMapping("/api/CategoriasMateriales")
public class CategoriaMatController extends GenericController<CategotiaMatRequest, CategoriaMatResponse, UUID> {

    protected CategoriaMatController(GenericService<CategotiaMatRequest, CategoriaMatResponse, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoriaMatListResponse.class)))
    })
    public ListResponse<CategoriaMatResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}