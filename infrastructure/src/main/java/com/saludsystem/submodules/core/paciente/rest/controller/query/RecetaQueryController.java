package com.saludsystem.submodules.core.paciente.rest.controller.query;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PacientesRecetas")
@RestController
@RequestMapping("/api/Pacientes/Recetas")
public class RecetaQueryController {

    /*
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RecetaListResponse.class)))
    })
    public ListResponse<RecetaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

     */
}