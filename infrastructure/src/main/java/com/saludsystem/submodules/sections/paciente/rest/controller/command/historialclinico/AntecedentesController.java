package com.saludsystem.submodules.sections.paciente.rest.controller.command.historialclinico;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PacientesEnfermedadesActuales")
@RestController
@RequestMapping("/api/Pacientes/EnfermedadesActuales")
public class AntecedentesController {

    /*
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AntecedenteListResponse.class)))
    })
    public ListResponse<AntecedenteDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

     */
}