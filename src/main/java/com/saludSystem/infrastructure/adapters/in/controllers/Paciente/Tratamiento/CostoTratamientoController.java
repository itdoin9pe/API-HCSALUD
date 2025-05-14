package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.CostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearCostoTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarCostoTratamientoDTO;
import com.saludSystem.application.services.Paciente.Tratamiento.CostoTratamientoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesCostosTratamientos")
@RestController
@RequestMapping("/api/PacientesCostosTratamientos")
public class CostoTratamientoController {

    private CostoTratamientoService costoTratamientoService;

    public CostoTratamientoController(CostoTratamientoService costoTratamientoService) {
        this.costoTratamientoService = costoTratamientoService;
    }

    @PostMapping("/SavePacienteCostoTratamiento")
    public ApiResponse stored(@Valid @RequestBody CrearCostoTratamientoDTO crearCostoTratamientoDTO) {
        return costoTratamientoService.saveCostoTratamiento(crearCostoTratamientoDTO);
    }

    @GetMapping("/GetAllPacienteCostoTratamiento")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CostoTratamientoDTO.class)))
    })
    public ListResponse<CostoTratamientoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return costoTratamientoService.getAllCostoTratamiento(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteCostoTratamiento/{pacienteCostoTratamientoId}")
    public CostoTratamientoDTO getById(@PathVariable UUID pacienteCostoTratamientoId) {
        return costoTratamientoService.getCostoTratamientoById(pacienteCostoTratamientoId);
    }

    @PutMapping("/UpdatePacienteCostoTratamiento/{pacienteCostoTratamientoId}")
    public ApiResponse update(@PathVariable UUID pacienteProcedimientoId, @RequestBody ActualizarCostoTratamientoDTO actualizarCostoTratamientoDTO) {
        return costoTratamientoService.updateCostoTratamiento(pacienteProcedimientoId, actualizarCostoTratamientoDTO);
    }

    @DeleteMapping("/DeletePacienteCostoTratamiento/{pacienteCostoTratamientoId}")
    public ApiResponse destroy(@PathVariable UUID pacienteCostoTratamientoId) {
        return costoTratamientoService.deleteCostoTratamiento(pacienteCostoTratamientoId);
    }

}