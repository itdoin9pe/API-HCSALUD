package com.saludsystem.infrastructure.web.restclient.principal;

import com.saludsystem.application.dto.get.AseguradoraDTO;
import com.saludsystem.application.dto.post.CrearAseguradoraDTO;
import com.saludsystem.application.dto.put.ActualizarAseguradoraDTO;
import com.saludsystem.infrastructure.adapters.in.response.AseguradoraListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Aseguradoras")
@RestController
@RequestMapping("/api/Aseguradoras")
public class AseguradoraController extends GenericController<AseguradoraDTO, CrearAseguradoraDTO,
        ActualizarAseguradoraDTO, UUID> {

    protected AseguradoraController(
            GenericService<AseguradoraDTO, CrearAseguradoraDTO, ActualizarAseguradoraDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AseguradoraListResponse.class)))
    })
    public ListResponse<AseguradoraDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}