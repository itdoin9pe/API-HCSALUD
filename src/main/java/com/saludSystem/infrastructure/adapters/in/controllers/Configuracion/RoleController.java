package com.saludSystem.infrastructure.adapters.in.controllers.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarRolDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearRolDTO;
import com.saludSystem.application.dtos.Configuracion.GET.RolDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.Configuracion.RolResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Roles")
@RestController
@RequestMapping("/api/Roles")
public class RoleController extends GenericController<RolDTO, UUID, CrearRolDTO, ActualizarRolDTO> {

    protected RoleController(GenericService<RolDTO, UUID, CrearRolDTO, ActualizarRolDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RolResponse.class)))
    })
    public ListResponse<RolDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}