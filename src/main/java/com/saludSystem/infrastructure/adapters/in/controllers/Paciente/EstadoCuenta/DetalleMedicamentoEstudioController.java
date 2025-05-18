package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.DetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludSystem.application.services.Paciente.EstadoCuenta.DetalleMedicamentoEstudioService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.EstadoCuenta.DetalleMedicamentoEstudioResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasEstudiosDetallesMedicamentos")
@RestController
@RequestMapping("/api/PacientesEstadosCuentasEstudiosDetallesMedicamentos")
public class DetalleMedicamentoEstudioController {

    private final DetalleMedicamentoEstudioService detalleMedicamentoEstudioService;

    public DetalleMedicamentoEstudioController(DetalleMedicamentoEstudioService detalleMedicamentoEstudioService) {
        this.detalleMedicamentoEstudioService = detalleMedicamentoEstudioService;
    }

    @PostMapping("/SavePacienteEstadoCuentaEstudioDetalleMedicamento")
    public ApiResponse stored(@Valid @RequestBody CrearDetalleMedicamentoEstudioDTO crearDetalleMedicamentoEstudioDTO) {
        return detalleMedicamentoEstudioService.saveDetalleMedicamentoEstudio(crearDetalleMedicamentoEstudioDTO);
    }

    @GetMapping("/GetAllPacienteEstadoCuentaEstudioDetalleMedicamento")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DetalleMedicamentoEstudioResponse.class)))
    })
    public ListResponse<DetalleMedicamentoEstudioDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return detalleMedicamentoEstudioService.getAllDetalleMedicamentoEstudio(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEstadoCuentaEstudioDetalleMedicamento/{pacienteEstadoCuentaEstudioDetalleMedicamentoId}")
    public DetalleMedicamentoEstudioDTO getById(@PathVariable UUID pec_detalleMedicamentoId) {
        return detalleMedicamentoEstudioService.getDetalleMedicamentoById(pec_detalleMedicamentoId);
    }

    @PutMapping("/UpdatePacienteEstadoCuentaEstudioDetalleMedicamento/{pacienteEstadoCuentaEstudioDetalleMedicamentoId}")
    public ApiResponse update(@PathVariable UUID pec_detalleMedicamentoId, @RequestBody ActualizarDetalleMedicamentoEstudioDTO actualizarCostoHospitalizacionDTO) {
        return detalleMedicamentoEstudioService.updateDetalleMedicamento(pec_detalleMedicamentoId);
    }

    @DeleteMapping("/DeletePacienteEstadoCuentaEstudioDetalleMedicamento/{pacienteEstadoCuentaEstudioDetalleMedicamentoId}")
    public ApiResponse destroy(@PathVariable UUID pec_detalleMedicamentoId) {
        return detalleMedicamentoEstudioService.deleteDetalleMedicamentoEstudio(pec_detalleMedicamentoId);
    }

}