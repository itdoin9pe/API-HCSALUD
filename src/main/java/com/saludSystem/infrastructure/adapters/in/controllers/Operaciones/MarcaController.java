package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.GET.MarcaDTO;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.MarcaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "MarcasMateriales")
@RestController
@RequestMapping("/api/MarcasMateriales")
public class MarcaController extends GenericController<MarcaDTO, UUID, CrearMarcaDTO, ActualizarMarcaDTO> {

    protected MarcaController(GenericService<MarcaDTO, UUID, CrearMarcaDTO, ActualizarMarcaDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MarcaResponse.class)))
    })
    public ListResponse<MarcaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}