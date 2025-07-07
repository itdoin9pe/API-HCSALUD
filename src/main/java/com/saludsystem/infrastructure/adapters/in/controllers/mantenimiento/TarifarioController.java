package com.saludsystem.infrastructure.adapters.in.controllers.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.TarifarioDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearTarifarioDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.mantenimiento.TarifarioResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Tarifarios")
@RestController
@RequestMapping("/api/Tarifarios")
public class TarifarioController extends GenericController<CrearTarifarioDTO, TarifarioDTO, UUID> {

    protected TarifarioController(GenericService<CrearTarifarioDTO, TarifarioDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TarifarioResponse.class)))
    })
    public ListResponse<TarifarioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}