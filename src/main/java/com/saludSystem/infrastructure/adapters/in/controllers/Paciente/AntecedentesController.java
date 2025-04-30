package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAntecedenteDTO;
import com.saludSystem.application.services.Paciente.AntecedenteService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.AntecedenteResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Tag(name = "PacientesEnfermedadesActuales")
@RestController
@RequestMapping("/api/PacientesEnfermedadesActuales")
public class AntecedentesController {

    private final AntecedenteService antecedenteService;

    public AntecedentesController(AntecedenteService antecedenteService) {
        this.antecedenteService = antecedenteService;
    }

    @PostMapping("/SavePacienteEnfermedadActual")
    public ApiResponse stored(@Valid @RequestBody CrearAntecedenteDTO crearAntecedenteDTO) {
        return antecedenteService.saveAntecedentes(crearAntecedenteDTO);
    }

    @GetMapping("/GetAllEnfermedadActual")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AntecedenteResponse.class)))
    })
    public ListResponse<AntecedenteDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return antecedenteService.getAllAntecedentes(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEnfermedadActual/{pacienteEnfermedadActualId}")
    public AntecedenteDTO getById(@PathVariable UUID antecedenteId) {
        return antecedenteService.getAntecedenteById(antecedenteId);
    }

    @PutMapping("/UpdatePacienteEnfermedadActual/{pacienteEnfermedadActualId}")
    public ApiResponse update(@PathVariable UUID antecedenteId, @RequestBody ActualizarAntecedenteDTO actualizarAntecedenteDTO) {
        return antecedenteService.updateAntecentes(antecedenteId, actualizarAntecedenteDTO);
    }

    @DeleteMapping("/DeletePacienteEnfermedadActual/{pacienteEnfermedadActualId}")
    public ApiResponse destroy(@PathVariable UUID antecedenteId) {
        return antecedenteService.deleteAntecedente(antecedenteId);
    }

}