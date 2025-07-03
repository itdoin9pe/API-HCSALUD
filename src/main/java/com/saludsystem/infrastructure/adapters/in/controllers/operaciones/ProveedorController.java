package com.saludsystem.infrastructure.adapters.in.controllers.operaciones;

import com.saludsystem.application.dtos.operaciones.get.ProveedorDTO;
import com.saludsystem.application.dtos.operaciones.post.CrearProveedorDTO;
import com.saludsystem.application.dtos.operaciones.put.ActualizarProveedorDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.operaciones.ProveedorResponse;
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