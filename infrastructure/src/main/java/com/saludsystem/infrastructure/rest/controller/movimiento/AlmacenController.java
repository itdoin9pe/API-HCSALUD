package com.saludsystem.infrastructure.rest.controller.movimiento;

import com.saludsystem.movimientos.application.dto.post.CrearAlmacenDTO;
import com.saludsystem.movimientos.application.dto.get.AlmacenDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarAlmacenDTO;
import com.saludsystem.movimientos.infrastructure.adapters.in.response.AlmacenListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Almacenes")
@RestController
@RequestMapping("/api/Almacenes")
public class AlmacenController extends GenericController<AlmacenDTO, CrearAlmacenDTO, ActualizarAlmacenDTO, UUID> {

    protected AlmacenController(
            GenericService<AlmacenDTO, CrearAlmacenDTO, ActualizarAlmacenDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlmacenListResponse.class)))
    })
    public ListResponse<AlmacenDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}