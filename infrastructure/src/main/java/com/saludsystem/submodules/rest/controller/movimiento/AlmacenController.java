package com.saludsystem.submodules.rest.controller.movimiento;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Almacenes")
@RestController
@RequestMapping("/api/Almacenes")
public class AlmacenController {

    /*
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlmacenListResponse.class)))
    })
    public ListResponse<AlmacenDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }*/
}