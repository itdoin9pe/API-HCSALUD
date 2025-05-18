package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.EstadoCuenta;

import com.saludSystem.application.dtos.Paciente.GET.EstadoCuenta.CostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.POST.EstadoCuenta.CrearCostoHospitalizacionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta.ActualizarCostoHospitalizacionDTO;
import com.saludSystem.application.services.Paciente.EstadoCuenta.CostoHospitalizacionService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.EstadoCuenta.CostoHospitalizacionResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasCostosHospitalizaciones")
@RestController
@RequestMapping("/api/PacientesEstadosCuentasCostosHospitalizaciones")
public class CostoHospitalizacionController {

    private final CostoHospitalizacionService costoHospitalizacionService;

    public CostoHospitalizacionController(CostoHospitalizacionService costoHospitalizacionService) {
        this.costoHospitalizacionService = costoHospitalizacionService;
    }

    @PostMapping("/SavePacienteEstadoCuentaCostoHospitalizacion")
    public ApiResponse stored(@Valid @RequestBody CrearCostoHospitalizacionDTO crearCostoHospitalizacionDTO) {
        return costoHospitalizacionService.saveCostoHospitalizacion(crearCostoHospitalizacionDTO);
    }

    @GetMapping("/GetAllPacienteEstadoCuentaCostoHospitalizacion")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CostoHospitalizacionResponse.class)))
    })
    public ListResponse<CostoHospitalizacionDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return costoHospitalizacionService.getAllCostoHospitalizacion(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEstadoCuentaCostoHospitalizacion/{pacienteEstadoCuentaCostoHospitalizacionId}")
    public CostoHospitalizacionDTO getById(@PathVariable UUID pec_costoHospitalizacionId) {
        return costoHospitalizacionService.getCostoHospitalizacionById(pec_costoHospitalizacionId);
    }

    @PutMapping("/UpdatePacienteEstadoCuentaCostoHostpitalizacion/{pacienteEstadoCuentaCostoHospitalizacionId}")
    public ApiResponse update(@PathVariable UUID pec_costoHospitalizacionId, @RequestBody ActualizarCostoHospitalizacionDTO actualizarCostoHospitalizacionDTO) {
        return costoHospitalizacionService.updateCostoHospitalizacion(pec_costoHospitalizacionId, actualizarCostoHospitalizacionDTO);
    }

    @DeleteMapping("/DeletePacienteEstadoCuentaCostoHospitalizacionId/{pacienteEstadoCuentaCostoHospitalizacionId}")
    public ApiResponse destroy(@PathVariable UUID pec_costoHospitalizacionId) {
        return costoHospitalizacionService.deleteCostoHospitalizacion(pec_costoHospitalizacionId);
    }

}