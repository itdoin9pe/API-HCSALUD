package com.saludsystem.submodules.core.paciente.rest.controller.command.historialclinico.tratamiento;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PacientesProcedimientos")
@RestController
@RequestMapping("/api/Pacientes/Procedimientos")
public class ProcedimientoController  {

    /*
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProcedimientoListResponse.class)))
    })
    public ListResponse<ProcedimientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

     */
}