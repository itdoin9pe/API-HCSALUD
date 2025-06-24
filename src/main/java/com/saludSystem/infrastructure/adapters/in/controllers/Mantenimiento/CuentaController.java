package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCuentaDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.GET.CuentaDTO;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.CuentaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "CuentasPagar")
@RestController
@RequestMapping("/api/CuentasPagar")
public class CuentaController extends GenericController<CuentaDTO, UUID, CrearCuentaDTO, ActualizarCuentaDTO> {

    protected CuentaController(GenericService<CuentaDTO, UUID, CrearCuentaDTO, ActualizarCuentaDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaResponse.class)))
    })
    public ListResponse<CuentaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}