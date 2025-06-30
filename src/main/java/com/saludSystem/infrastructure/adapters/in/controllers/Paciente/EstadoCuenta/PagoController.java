package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.PagoDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearPagoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarPagoDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.EstadoCuenta.PagoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasPagos")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/Pagos")
public class PagoController extends GenericController<PagoDTO, UUID, CrearPagoDTO, ActualizarPagoDTO> {

    protected PagoController(GenericService<PagoDTO, UUID, CrearPagoDTO, ActualizarPagoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PagoResponse.class)))
    })
    public ListResponse<PagoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}