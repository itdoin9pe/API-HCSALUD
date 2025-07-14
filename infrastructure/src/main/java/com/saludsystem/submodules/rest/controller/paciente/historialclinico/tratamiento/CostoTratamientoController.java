package com.saludsystem.submodules.rest.controller.paciente.historialclinico.tratamiento;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PacientesCostosTratamientos")
@RestController
@RequestMapping("/api/Pacientes/CostosTratamientos")
public class CostoTratamientoController {

    /*
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CostoTratamientoListResponse.class)))
    })
    public ListResponse<CostoTratamientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

     */
}