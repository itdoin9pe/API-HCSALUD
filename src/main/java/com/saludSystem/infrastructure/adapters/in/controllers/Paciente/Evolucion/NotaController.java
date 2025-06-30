package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.NotaDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearNotaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarNotaDTO;
import com.saludSystem.application.services.Paciente.Evolucion.NotaService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.Evolucion.NotaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEvolucionesNotas")
@RestController
@RequestMapping("/api/Pacientes/Evololuciones/Notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService) {
        this.notaService = notaService;
    }

    @PostMapping("/Save")
    public ApiResponse stored(@Valid @RequestBody CrearNotaDTO crearNotaDTO) {
        return notaService.saveNota(crearNotaDTO);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NotaResponse.class)))
    })
    public ListResponse<NotaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return notaService.getAllNota(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{Id}")
    public NotaDTO getById(@PathVariable Long pacienteEvolucionNotaId) {
        return notaService.getNotaById(pacienteEvolucionNotaId);
    }

    @PutMapping("/Update/{Id}")
    public ApiResponse update(@PathVariable Long pacienteEvolucionNotaId, @RequestBody ActualizarNotaDTO actualizarNotaDTO) {
        return notaService.updateNota(pacienteEvolucionNotaId, actualizarNotaDTO);
    }

    @DeleteMapping("/Delete/{Id}")
    public ApiResponse destroy(@PathVariable Long pacienteEvolucionNotaId) {
        return notaService.deleteNota(pacienteEvolucionNotaId);
    }
}