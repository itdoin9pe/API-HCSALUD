package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.TipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearTipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarTipoMaterialDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.TipoMaterialResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TiposMateriales")
@RestController
@RequestMapping("/api/TiposMateriales")
public class TipoMaterialController extends GenericController<TipoMaterialDTO, UUID,
        CrearTipoMaterialDTO, ActualizarTipoMaterialDTO> {

    protected TipoMaterialController(GenericService<TipoMaterialDTO, UUID, CrearTipoMaterialDTO, ActualizarTipoMaterialDTO> genericService) {
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