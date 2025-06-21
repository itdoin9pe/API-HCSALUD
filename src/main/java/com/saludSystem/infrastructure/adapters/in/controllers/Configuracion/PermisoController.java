package com.saludSystem.infrastructure.adapters.in.controllers.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarPermisoDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearPermisoDTO;
import com.saludSystem.application.dtos.Configuracion.GET.PermisoDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.Configuracion.PermisoResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Permisos")
@RestController
@RequestMapping("/api/Permisos")
public class PermisoController extends GenericController<PermisoDTO, UUID, CrearPermisoDTO, ActualizarPermisoDTO> {

    protected PermisoController(GenericService<PermisoDTO, UUID, CrearPermisoDTO,
            ActualizarPermisoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PermisoResponse.class)))
    })
    public ListResponse<PermisoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}