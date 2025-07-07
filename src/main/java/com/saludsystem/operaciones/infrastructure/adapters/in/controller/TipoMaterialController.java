package com.saludsystem.operaciones.infrastructure.adapters.in.controller;

import com.saludsystem.operaciones.application.dto.res.TipoMaterialDTO;
import com.saludsystem.operaciones.application.dto.req.CrearTipoMaterialDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.operaciones.infrastructure.adapters.in.response.TipoMaterialResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposMateriales")
@RestController
@RequestMapping("/api/TiposMateriales")
public class TipoMaterialController extends GenericController<CrearTipoMaterialDTO, TipoMaterialDTO, UUID> {

    protected TipoMaterialController(GenericService<CrearTipoMaterialDTO, TipoMaterialDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoMaterialResponse.class)))
    })
    public ListResponse<TipoMaterialDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}