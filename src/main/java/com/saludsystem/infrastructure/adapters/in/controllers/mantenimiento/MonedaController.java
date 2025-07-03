package com.saludsystem.infrastructure.adapters.in.controllers.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.MonedaDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearMonedaDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarMonedaDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.mantenimiento.MonedaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposMonedas")
@RestController
@RequestMapping("/api/TiposMonedas")
public class MonedaController extends GenericController<MonedaDTO, UUID, CrearMonedaDTO, ActualizarMonedaDTO> {

    protected MonedaController(GenericService<MonedaDTO, UUID, CrearMonedaDTO, ActualizarMonedaDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MonedaResponse.class)))
    })
    public ListResponse<MonedaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}