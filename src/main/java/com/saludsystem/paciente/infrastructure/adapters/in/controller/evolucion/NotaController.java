package com.saludsystem.paciente.infrastructure.adapters.in.controller.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.NotaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.NotaRequest;
import com.saludsystem.paciente.application.dto.base.evolucion.ActualizarNotaDTO;
import com.saludsystem.paciente.application.service.historialclinico.evolucion.NotaService;
import com.saludsystem.paciente.infrastructure.adapters.in.response.Evolucion.NotaListResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
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
    public ApiResponse stored(@Valid @RequestBody NotaRequest notaRequest) {
        return notaService.saveNota(notaRequest);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NotaListResponse.class)))
    })
    public ListResponse<NotaResponse> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return notaService.getAllNota(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{Id}")
    public NotaResponse getById(@PathVariable Long pacienteEvolucionNotaId) {
        return notaService.getNotaById(pacienteEvolucionNotaId);
    }

    @PutMapping("/Update/{Id}")
    public ApiResponse update(@PathVariable Long pacienteEvolucionNotaId,
                              @RequestBody ActualizarNotaDTO actualizarNotaDTO) {
        return notaService.updateNota(pacienteEvolucionNotaId, actualizarNotaDTO);
    }

    @DeleteMapping("/Delete/{Id}")
    public ApiResponse destroy(@PathVariable Long pacienteEvolucionNotaId) {
        return notaService.deleteNota(pacienteEvolucionNotaId);
    }
}