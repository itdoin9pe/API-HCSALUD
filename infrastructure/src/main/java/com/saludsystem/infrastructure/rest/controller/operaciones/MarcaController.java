package com.saludsystem.infrastructure.rest.controller.operaciones;

import com.saludsystem.operaciones.application.dto.get.MarcaDTO;
import com.saludsystem.operaciones.application.dto.post.CrearMarcaDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarMarcaDTO;
import com.saludsystem.operaciones.infrastructure.adapters.in.response.MarcaListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "MarcasMateriales")
@RestController
@RequestMapping("/api/MarcasMateriales")
public class MarcaController extends GenericController<MarcaDTO, CrearMarcaDTO, ActualizarMarcaDTO, UUID> {

    protected MarcaController(GenericService<MarcaDTO, CrearMarcaDTO, ActualizarMarcaDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MarcaListResponse.class)))
    })
    public ListResponse<MarcaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}