package com.saludsystem.paciente.infrastructure.adapters.in.controller.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.AltaMedicaDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.CrearAltaMedicaDTO;
import com.saludsystem.paciente.application.dto.evolucion.ActualizarAltaMedicaDTO;
import com.saludsystem.paciente.application.service.historialclinico.evolucion.AltaMedicaService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.in.response.Evolucion.AltaMedicaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEvolucionesAltasMedicas")
@RestController 
@RequestMapping("/api/Pacientes/Evoluciones/AltasMedicas")
public class AltaMedicaController {

    private final AltaMedicaService altaMedicaService;

    public AltaMedicaController(AltaMedicaService altaMedicaService) {
        this.altaMedicaService = altaMedicaService;
    }

    @PostMapping("/Save")
    public ApiResponse stored(@Valid @RequestBody CrearAltaMedicaDTO crearAltaMedicaDTO) {
        return altaMedicaService.saveAltaMedica(crearAltaMedicaDTO);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AltaMedicaResponse.class)))
    })
    public ListResponse<AltaMedicaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return altaMedicaService.getAllAltaMedica(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{Id}")
    public AltaMedicaDTO getById(@PathVariable Long evolucionAltaMedicaId) {
        return altaMedicaService.getAltaMedicaById(evolucionAltaMedicaId);
    }

    @PutMapping("/Update/{Id}")
    public ApiResponse update(@PathVariable Long evolucionAltaMedicaId,
                              @RequestBody ActualizarAltaMedicaDTO actualizarAltaMedicaDTO) {
        return altaMedicaService.updateAltaMedica(evolucionAltaMedicaId, actualizarAltaMedicaDTO);
    }

    @DeleteMapping("/Delete/{Id}")
    public ApiResponse destroy(@PathVariable Long evolucionAltaMedicaId) {
        return altaMedicaService.deleteAltaMedica(evolucionAltaMedicaId);
    }
}