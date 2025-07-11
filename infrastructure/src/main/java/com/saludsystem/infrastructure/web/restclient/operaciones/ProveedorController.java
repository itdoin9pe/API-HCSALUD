package com.saludsystem.infrastructure.web.restclient.operaciones;

import com.saludsystem.operaciones.application.dto.get.ProveedorDTO;
import com.saludsystem.operaciones.application.dto.post.CrearProveedorDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarProveedorDTO;
import com.saludsystem.operaciones.infrastructure.adapters.in.response.ProveedorListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Proveedor")
@RestController
@RequestMapping("/api/Proveedor")
public class ProveedorController extends GenericController<ProveedorDTO, CrearProveedorDTO,
        ActualizarProveedorDTO, UUID> {

    protected ProveedorController(
            GenericService<ProveedorDTO, CrearProveedorDTO, ActualizarProveedorDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProveedorListResponse.class)))
    })
    public ListResponse<ProveedorDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}