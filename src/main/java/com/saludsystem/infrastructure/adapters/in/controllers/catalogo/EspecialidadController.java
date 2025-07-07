package com.saludsystem.infrastructure.adapters.in.controllers.catalogo;

import com.saludsystem.application.dtos.catalogo.req.EspecialidadDTO;
import com.saludsystem.application.dtos.catalogo.post.CrearEspecialidadDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.catalogo.EspecialidadResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Especialidades")
@RestController
@RequestMapping("/api/Especialidades")
public class EspecialidadController extends GenericController<CrearEspecialidadDTO, EspecialidadDTO, UUID> {

    protected EspecialidadController(GenericService<CrearEspecialidadDTO, EspecialidadDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EspecialidadResponse.class)))
    })
    public ListResponse<EspecialidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}