package com.saludSystem.infrastructure.adapters.in.controllers.Configuracion;

import com.saludSystem.application.dtos.Configuracion.PUT.ActualizarSedeDTO;
import com.saludSystem.application.dtos.Configuracion.POST.CrearSedeDTO;
import com.saludSystem.application.dtos.Configuracion.GET.SedeDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.Configuracion.SedeResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Sedes")
@RestController
@RequestMapping("/api/Sedes")
public class SedeController extends GenericController<SedeDTO, UUID, CrearSedeDTO, ActualizarSedeDTO> {

    protected SedeController(GenericService<SedeDTO, UUID, CrearSedeDTO, ActualizarSedeDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SedeResponse.class)))
    })
    public ListResponse<SedeDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}