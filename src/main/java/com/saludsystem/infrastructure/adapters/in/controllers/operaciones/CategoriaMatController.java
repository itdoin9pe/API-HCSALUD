package com.saludsystem.infrastructure.adapters.in.controllers.operaciones;

import com.saludsystem.application.dtos.operaciones.get.CategoriaMatDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearCategotiaMatDTO;
import com.saludsystem.application.dtos.operaciones.put.ActualizarCategoriaMatDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.operaciones.CategoriaMatResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CategoriasMateriales")
@RestController
@RequestMapping("/api/CategoriasMateriales")
public class CategoriaMatController extends GenericController<CrearCategotiaMatDTO, CategoriaMatDTO, UUID> {

    protected CategoriaMatController(GenericService<CrearCategotiaMatDTO, CategoriaMatDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CategoriaMatResponse.class)))
    })
    public ListResponse<CategoriaMatDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}