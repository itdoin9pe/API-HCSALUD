package com.saludsystem.infrastructure.rest.controller.mantenimiento;

import com.saludsystem.mantenimiento.application.dto.get.MonedaDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearMonedaDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarMonedaDTO;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.MonedaListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposMonedas")
@RestController
@RequestMapping("/api/TiposMonedas")
public class MonedaController extends GenericController<MonedaDTO, CrearMonedaDTO, ActualizarMonedaDTO, UUID> {

    protected MonedaController(GenericService<MonedaDTO, CrearMonedaDTO, ActualizarMonedaDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MonedaListResponse.class)))
    })
    public ListResponse<MonedaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}