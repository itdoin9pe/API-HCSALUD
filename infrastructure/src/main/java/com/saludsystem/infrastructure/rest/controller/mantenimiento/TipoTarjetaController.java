package com.saludsystem.infrastructure.rest.controller.mantenimiento;

import com.saludsystem.mantenimiento.application.dto.get.TipoTarjetaDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearTipoTarjetaDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarTipoTarjetaDTO;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.TipoTarjetaListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "TipoTarjeta")
@RestController
@RequestMapping("/api/TipoTarjeta")
public class TipoTarjetaController extends GenericController<TipoTarjetaDTO, CrearTipoTarjetaDTO,
        ActualizarTipoTarjetaDTO, UUID> {

    protected TipoTarjetaController(
            GenericService<TipoTarjetaDTO, CrearTipoTarjetaDTO, ActualizarTipoTarjetaDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoTarjetaListResponse.class)))
    })
    public ListResponse<TipoTarjetaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}