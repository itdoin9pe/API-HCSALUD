package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.ProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarProveedorDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.ProveedorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Proveedor")
@RestController
@RequestMapping("/api/Proveedor")
public class ProveedorController extends GenericController<ProveedorDTO, UUID, CrearProveedorDTO, ActualizarProveedorDTO> {

    protected ProveedorController(GenericService<ProveedorDTO, UUID, CrearProveedorDTO, ActualizarProveedorDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProveedorResponse.class)))
    })
    public ListResponse<ProveedorDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}