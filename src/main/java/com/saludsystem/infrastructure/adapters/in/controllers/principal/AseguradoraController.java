package com.saludsystem.infrastructure.adapters.in.controllers.principal;

import com.saludsystem.application.dtos.principal.get.AseguradoraDTO;
import com.saludsystem.application.dtos.principal.post.CrearAseguradoraDTO;
import com.saludsystem.application.dtos.principal.put.ActualizarAseguradoraDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.principal.AseguradoraResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Aseguradoras")
@RestController
@RequestMapping("/api/Aseguradoras")
public class AseguradoraController extends GenericController<AseguradoraDTO, UUID,
        CrearAseguradoraDTO, ActualizarAseguradoraDTO> {

    protected AseguradoraController(GenericService<AseguradoraDTO, UUID, CrearAseguradoraDTO,
            ActualizarAseguradoraDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AseguradoraResponse.class)))
    })
    public ListResponse<AseguradoraDTO> getAllPaginated(UUID hospitalId, int page,  int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}