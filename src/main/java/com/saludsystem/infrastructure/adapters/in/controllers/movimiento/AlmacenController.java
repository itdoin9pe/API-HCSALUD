package com.saludsystem.infrastructure.adapters.in.controllers.movimiento;

import com.saludsystem.application.dtos.movimientos.get.AlmacenDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearAlmacenDTO;
import com.saludsystem.application.dtos.movimientos.put.ActualizarAlmacenDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.movimientos.AlmacenResponse;
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
public class AlmacenController extends GenericController<AlmacenDTO, UUID, CrearAlmacenDTO, ActualizarAlmacenDTO> {

    protected AlmacenController(GenericService<AlmacenDTO, UUID, CrearAlmacenDTO, ActualizarAlmacenDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlmacenResponse.class)))
    })
    public ListResponse<AlmacenDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}