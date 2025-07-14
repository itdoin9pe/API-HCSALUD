package com.saludsystem.submodules.rest.controller.mantenimiento;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ConceptosGastos")
@RestController
@RequestMapping("/api/ConceptosGastos")
public class TipoGastoController {

    /*
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TIpoGastoListResponse.class)))
    })
    public ListResponse<TipoGastoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }*/
}