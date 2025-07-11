package com.saludsystem.infrastructure.web.restclient.mantenimiento;

import com.saludsystem.mantenimiento.application.dto.get.TipoGastoDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearTipoGastoDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarTipoGastoDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.TIpoGastoListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "ConceptosGastos")
@RestController
@RequestMapping("/api/ConceptosGastos")
public class TipoGastoController extends GenericController<TipoGastoDTO, CrearTipoGastoDTO,
        ActualizarTipoGastoDTO, UUID> {

    protected TipoGastoController(
            GenericService<TipoGastoDTO, CrearTipoGastoDTO, ActualizarTipoGastoDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TIpoGastoListResponse.class)))
    })
    public ListResponse<TipoGastoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}