package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.EstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearEstadoCuentaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarEstadoCuentaDTO;
import com.saludSystem.application.services.Paciente.EstadoCuenta.EstadoCuentaService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.EstadoCuenta.EstadoCuentaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentas")
@RestController
@RequestMapping("/api/PacientesEstadosCuentas")
public class EstadoCuentaController {

    private final EstadoCuentaService estadoCuentaService;

    public EstadoCuentaController(EstadoCuentaService estadoCuentaService) {
        this.estadoCuentaService = estadoCuentaService;
    }

    @PostMapping("/SavePacienteEstadoCuenta")
    public ApiResponse stored(@Valid @RequestBody CrearEstadoCuentaDTO crearEstadoCuentaDTO) {
        return estadoCuentaService.saveEstadoCuenta(crearEstadoCuentaDTO);
    }

    @GetMapping("/GetAllPacienteEstadoCuenta")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstadoCuentaResponse.class)))
    })
    public ListResponse<EstadoCuentaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return estadoCuentaService.getAllEstadoCuenta(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEstadoCuenta/{pacienteEstadoCuentaId}")
    public EstadoCuentaDTO getById(@PathVariable UUID pacienteEstadoCuentaId) {
        return estadoCuentaService.getEstadoCuentaById(pacienteEstadoCuentaId);
    }

    @PutMapping("/UpdatePacienteEstadoCuenta/{pacienteEstadoCuentaId}")
    public ApiResponse update(@PathVariable UUID pacienteEstadoCuentaId, @RequestBody ActualizarEstadoCuentaDTO actualizarEstadoCuentaDTO) {
        return estadoCuentaService.updateEstadoCuenta(pacienteEstadoCuentaId, actualizarEstadoCuentaDTO);
    }

    @DeleteMapping("/DeletePacienteEstadoCuenta/{pacienteEstadoCuentaId}")
    public ApiResponse destroy(@PathVariable UUID pacienteEstadoCuentaId) {
        return estadoCuentaService.deleteEstadoCuenta(pacienteEstadoCuentaId);
    }

}