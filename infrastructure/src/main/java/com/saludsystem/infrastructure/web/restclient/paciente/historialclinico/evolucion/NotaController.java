package com.saludsystem.infrastructure.web.restclient.paciente.historialclinico.evolucion;

import com.saludsystem.application.dto.get.historialclinico.evolucion.NotaDTO;
import com.saludsystem.application.dto.post.historialclinico.evolucion.CrearNotaDTO;
import com.saludsystem.application.dto.put.historialclinico.evolucion.ActualizarNotaDTO;
import com.saludsystem.application.service.historialclinico.evolucion.NotaService;
import com.saludsystem.infrastructure.adapters.in.response.evolucion.NotaListResponse;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;
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
                            schema = @Schema(implementation = NotaListResponse.class)))
    })
    public ListResponse<NotaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return notaService.getAllNota(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{pacienteNotaId}")
    public NotaDTO getById(@PathVariable("pacienteNotaId") Long pacienteEvolucionNotaId) {
        return notaService.getNotaById(pacienteEvolucionNotaId);
    }

    @PutMapping("/Update/{pacienteNotaId}")
    public ApiResponse update(@PathVariable("pacienteNotaId") Long pacienteEvolucionNotaId,
                              @RequestBody ActualizarNotaDTO actualizarNotaDTO) {
        return notaService.updateNota(pacienteEvolucionNotaId, actualizarNotaDTO);
    }

    @DeleteMapping("/Delete/{pacienteNotaId}")
    public ApiResponse destroy(@PathVariable("pacienteNotaId") Long pacienteEvolucionNotaId) {
        return notaService.deleteNota(pacienteEvolucionNotaId);
    }
}