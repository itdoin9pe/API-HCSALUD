package com.saludsystem.mantenimiento.infrastructure.adapters.in.controller;

import com.saludsystem.mantenimiento.application.dto.get.TarifarioDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearTarifarioDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarTarifarioDTO;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.TarifarioListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Tarifarios")
@RestController
@RequestMapping("/api/Tarifarios")
public class TarifarioController extends GenericController<TarifarioDTO, CrearTarifarioDTO,
        ActualizarTarifarioDTO, UUID> {

    protected TarifarioController(
            GenericService<TarifarioDTO, CrearTarifarioDTO, ActualizarTarifarioDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TarifarioListResponse.class)))
    })
    public ListResponse<TarifarioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}