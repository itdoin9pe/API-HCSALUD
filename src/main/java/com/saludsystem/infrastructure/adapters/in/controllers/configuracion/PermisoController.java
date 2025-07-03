package com.saludsystem.infrastructure.adapters.in.controllers.configuracion;

import com.saludsystem.application.dtos.configuracion.get.PermisoDTO;
import com.saludsystem.application.dtos.configuracion.post.CrearPermisoDTO;
import com.saludsystem.application.dtos.configuracion.put.ActualizarPermisoDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.configuracion.PermisoResponse;
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