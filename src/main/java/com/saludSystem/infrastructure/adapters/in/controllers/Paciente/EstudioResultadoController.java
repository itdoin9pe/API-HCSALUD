package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.EstudioResultadoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearEstudioResultadoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarEstudioResultadoDTO;
import com.saludSystem.application.services.Paciente.EstudioResultadoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.EstudioResultadoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstudiosResultados")
@RestController
@RequestMapping("/api/PacientesEstudiosResultados")
public class EstudioResultadoController {

    private final EstudioResultadoService estudioResultadoService;

    public EstudioResultadoController(EstudioResultadoService estudioResultadoService) {
        this.estudioResultadoService = estudioResultadoService;
    }

    @PostMapping("/SavePacienteEstudioResultado")
    public ApiResponse stored(@Valid @RequestBody CrearEstudioResultadoDTO crearEstudioResultadoDTO) {
        return estudioResultadoService.saveEstudioResultado(crearEstudioResultadoDTO);
    }

    @GetMapping("/GetAllPacienteEstudioResultado")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstudioResultadoResponse.class)))
    })
    public ListResponse<EstudioResultadoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return estudioResultadoService.getAllEstudioResultado(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEstudioResultado/{pacienteEstudioResultadoId}")
    public EstudioResultadoDTO getById(@PathVariable Long pacienteEstudioResultadoId) {
        return estudioResultadoService.getEstudioResultadoById(pacienteEstudioResultadoId);
    }

    @PutMapping("/UpdatePacienteEstudioResultado/{pacienteEstudioResultadoId}")
    public ApiResponse update(@PathVariable Long pacienteEstudioResultadoId, @RequestBody ActualizarEstudioResultadoDTO actualizarEstudioResultadoDTO) {
        return estudioResultadoService.updateEstudioResultado(pacienteEstudioResultadoId, actualizarEstudioResultadoDTO);
    }

    @DeleteMapping("/DeletePacienteEstudioResultado/{pacienteEstudioResultadoId}")
    public ApiResponse destroy(@PathVariable Long pacienteEstudioResultadoId) {
        return estudioResultadoService.deleteEstudioResultado(pacienteEstudioResultadoId);
    }

}