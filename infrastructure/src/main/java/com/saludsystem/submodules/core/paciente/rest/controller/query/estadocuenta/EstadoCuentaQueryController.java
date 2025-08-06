package com.saludsystem.submodules.core.paciente.rest.controller.query.estadocuenta;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PacientesEstadosCuentas")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas")
public class EstadoCuentaQueryController {

    /*
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstadoCuentaListResponse.class)))
    })
    public ListResponse<EstadoCuentaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

     */
}