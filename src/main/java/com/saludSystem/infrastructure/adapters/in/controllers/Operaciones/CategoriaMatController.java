package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarCategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.GET.CategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearCategotiaMatDTO;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.CategoriaMatResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CategoriasMateriales")
@RestController
@RequestMapping("/api/CategoriasMateriales")
public class CategoriaMatController extends GenericController<CategoriaMatDTO, UUID, CrearCategotiaMatDTO, ActualizarCategoriaMatDTO> {

    protected CategoriaMatController(GenericService<CategoriaMatDTO, UUID, CrearCategotiaMatDTO, ActualizarCategoriaMatDTO> genericService) {
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