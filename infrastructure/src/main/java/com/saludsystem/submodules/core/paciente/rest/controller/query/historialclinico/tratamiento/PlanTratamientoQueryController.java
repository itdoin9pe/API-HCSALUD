package com.saludsystem.submodules.core.paciente.rest.controller.query.historialclinico.tratamiento;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PacientesPlanesTratamientos")
@RestController
@RequestMapping("/api/Pacientes/PlanesTratamientos")
public class PlanTratamientoQueryController {

    /*
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlanTratamientoListResponse.class)))
    })
    public ListResponse<PlanTratamientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

     */
}