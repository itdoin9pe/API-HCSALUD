package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.PagoDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearPagoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarPagoDTO;
import com.saludSystem.application.services.Paciente.EstadoCuenta.PagoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.EstadoCuenta.PagoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasPagos")
@RestController
@RequestMapping("/api/PacientesEstadosCuentasPagos")
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping("/SavePacienteEstadoCuentaPago")
    public ApiResponse stored(@Valid @RequestBody CrearPagoDTO crearPagoDTO) {
        return pagoService.savePago(crearPagoDTO);
    }

    @GetMapping("/GetAllPacienteEstadoCuentaPago")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PagoResponse.class)))
    })
    public ListResponse<PagoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return pagoService.getAllPago(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEstadoCuentaPago/{pacienteEstadoCuentaPagoId}")
    public PagoDTO getById(@PathVariable UUID pec_pagoId) {
        return pagoService.getPagoById(pec_pagoId);
    }

    @PutMapping("/UpdatePacienteEstadoCuentaPago/{pacienteEstadoCuentaPagoId}")
    public ApiResponse update(@PathVariable UUID pec_pagoId, @RequestBody ActualizarPagoDTO actualizarPagoDTO) {
        return pagoService.updatePago(pec_pagoId, actualizarPagoDTO);
    }

    @DeleteMapping("/DeletePacienteEstadoCuentaPago/{pacienteEstadoCuentaPagoId}")
    public ApiResponse destroy(@PathVariable UUID pec_pagoId) {
        return pagoService.deletePago(pec_pagoId);
    }

}