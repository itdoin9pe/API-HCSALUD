package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTarifarioDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTarifarioDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TarifarioDTO;
import com.saludSystem.application.services.Mantenimiento.TarifarioService;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.TarifarioResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Tarifarios")
@RestController
@RequestMapping("/api/Tarifarios")
public class TarifarioController {

    private final TarifarioService tarifarioService;

    public TarifarioController(TarifarioService tarifarioService) {
        this.tarifarioService = tarifarioService;
    }

    @PostMapping("/SaveTarifario")
    public ApiResponse stored(@Valid @RequestBody CrearTarifarioDTO crearTarifarioDTO) {
        return tarifarioService.saveTarifario(crearTarifarioDTO);
    }

    @GetMapping("/GetAllTarifario")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TarifarioResponse.class)))
    })
    public ListResponse<TarifarioDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return tarifarioService.getAllTarifario(hospitalId, page, rows);
    }

    @GetMapping("/GetTarifarioList")
    public ResponseEntity<List<TarifarioDTO>> getAllList() {
        return ResponseEntity.ok(tarifarioService.getTarifarioList());
    }

    @GetMapping("/GetTarifario/{tarifarioId}")
    public TarifarioDTO getById(@PathVariable UUID tarifarioId) {
        return tarifarioService.getTarifarioById(tarifarioId);
    }

    @PutMapping("/UpdateTarifario/{tarifarioId}")
    public ApiResponse update(@PathVariable UUID tarifarioId, @RequestBody ActualizarTarifarioDTO actualizarTarifarioDTO) {
        return tarifarioService.updateTarifario(tarifarioId, actualizarTarifarioDTO);
    }

    @DeleteMapping("/DeleteTarifario/{tarifarioId}")
    public ApiResponse destroy(@PathVariable UUID tarifarioId) {
        return tarifarioService.deleteTarifario(tarifarioId);
    }

}