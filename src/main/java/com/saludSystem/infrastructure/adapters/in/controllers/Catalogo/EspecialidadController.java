package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarEspecialidadDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearEspecialidadDTO;
import com.saludSystem.application.dtos.Catalogo.GET.EspecialidadDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.Catalogo.EspecialidadResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "Especialidades")
@RestController
@RequestMapping("/api/Especialidades")
public class EspecialidadController extends GenericController<EspecialidadDTO, UUID,
        CrearEspecialidadDTO, ActualizarEspecialidadDTO> {

    protected EspecialidadController(GenericService<EspecialidadDTO, UUID, CrearEspecialidadDTO,
            ActualizarEspecialidadDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EspecialidadResponse.class)))
    })
    public ListResponse<EspecialidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}