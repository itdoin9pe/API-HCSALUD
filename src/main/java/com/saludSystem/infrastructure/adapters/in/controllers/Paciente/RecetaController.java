package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.RecetaDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearRecetaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarRecetaDTO;
import com.saludSystem.application.services.Paciente.RecetaService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.RecetaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesRecetas")
@RestController
@RequestMapping("/api/PacientesRecetas")
public class RecetaController {

    private final RecetaService recetaService;

    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }

    @PostMapping("/SavePacienteReceta")
    public ApiResponse stored(@Valid @RequestBody CrearRecetaDTO crearRecetaDTO) {
        return recetaService.saveReceta(crearRecetaDTO);
    }

    @GetMapping("/GetAllPacienteReceta")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RecetaResponse.class)))
    })
    public ListResponse<RecetaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return recetaService.getAllReceta(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteReceta/{pacienteRecetaId}")
    public RecetaDTO getById(@PathVariable UUID pacienteRecetaId) {
        return recetaService.getRecetaById(pacienteRecetaId);
    }

    @PutMapping("/UpdatePacienteReceta/{pacienteRecetaId}")
    public ApiResponse update(@PathVariable UUID pacienteRecetaId, @RequestBody ActualizarRecetaDTO actualizarRecetaDTO) {
        return recetaService.updateReceta(pacienteRecetaId, actualizarRecetaDTO);
    }

    @DeleteMapping("/DeletePacienteReceta/{pacienteRecetaId}")
    public ApiResponse destroy(@PathVariable UUID pacienteRecetaId) {
        return recetaService.deleteReceta(pacienteRecetaId);
    }

}