package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarUnidadDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearUnidadDTO;
import com.saludSystem.application.dtos.Operaciones.GET.UnidadDTO;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.UnidadResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Unidades")
@RestController
@RequestMapping("/api/Unidades")
public class UnidadController extends GenericController<UnidadDTO, UUID, CrearUnidadDTO, ActualizarUnidadDTO> {

    protected UnidadController(GenericService<UnidadDTO, UUID, CrearUnidadDTO, ActualizarUnidadDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UnidadResponse.class)))
    })
    public ListResponse<UnidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}