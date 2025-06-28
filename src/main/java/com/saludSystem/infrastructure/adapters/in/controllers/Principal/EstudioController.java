package com.saludSystem.infrastructure.adapters.in.controllers.Principal;

import com.saludSystem.application.dtos.Principal.GET.EstudioDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearEstudioDTO;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarEstudioDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.Principal.EstudioResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Estudios")
@RestController
@RequestMapping("/api/Estudios")
public class EstudioController extends GenericController<EstudioDTO, UUID, CrearEstudioDTO, ActualizarEstudioDTO> {

    protected EstudioController(GenericService<EstudioDTO, UUID, CrearEstudioDTO, ActualizarEstudioDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstudioResponse.class)))
    })
    public ListResponse<EstudioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}