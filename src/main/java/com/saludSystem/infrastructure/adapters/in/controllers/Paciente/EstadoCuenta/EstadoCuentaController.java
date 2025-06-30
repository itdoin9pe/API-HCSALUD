package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.EstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearEstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarEstadoCuentaDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.EstadoCuenta.EstadoCuentaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentas")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas")
public class EstadoCuentaController extends GenericController<
        EstadoCuentaDTO, UUID, CrearEstadoCuentaDTO, ActualizarEstadoCuentaDTO> {

    protected EstadoCuentaController(GenericService<EstadoCuentaDTO, UUID, CrearEstadoCuentaDTO,
            ActualizarEstadoCuentaDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstadoCuentaResponse.class)))
    })
    public ListResponse<EstadoCuentaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}