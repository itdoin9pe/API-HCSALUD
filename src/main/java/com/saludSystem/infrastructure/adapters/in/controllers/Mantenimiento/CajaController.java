package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CajaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCajaDTO;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.CajaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Cajas")
@RestController
@RequestMapping("/api/Cajas")
public class CajaController extends GenericController<CajaDTO, UUID, CrearCajaDTO, ActualizarCajaDTO> {

    protected CajaController(GenericService<CajaDTO, UUID, CrearCajaDTO, ActualizarCajaDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CajaResponse.class)))
    })
    public ListResponse<CajaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}