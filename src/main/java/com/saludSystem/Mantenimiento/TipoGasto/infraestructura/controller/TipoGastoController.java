package com.saludSystem.Mantenimiento.TipoGasto.infraestructura.controller;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos.ActualizarTipoGastoDTO;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos.CrearTipoGastoDTO;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos.TipoGastoDTO;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.services.TipoGastoService;
import com.saludSystem.Mantenimiento.TipoGasto.dominio.TIpoGastoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "ConceptosGastos")
@RestController
@RequestMapping("/api/ConceptosGastos")
public class TipoGastoController {

    private final TipoGastoService tipoGastoService;

    public TipoGastoController(TipoGastoService tipoGastoService) {
        this.tipoGastoService = tipoGastoService;
    }

    @PostMapping("/SaveConceptoGasto")
    public ApiResponse stored(@Valid @RequestBody CrearTipoGastoDTO crearTipoGastoDTO) {
        return tipoGastoService.saveTipoGasto(crearTipoGastoDTO);
    }

    @GetMapping("/GetAllConceptoGasto")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TIpoGastoResponse.class)))
    })
    public ListResponse<TipoGastoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return tipoGastoService.getAllTipoGasto(hospitalId, page, rows);
    }

    @GetMapping("/GetConceptoGastoList")
    public ResponseEntity<List<TipoGastoDTO>> getAllList() {
        return ResponseEntity.ok(tipoGastoService.getTipoGastoList());
    }

    @GetMapping("/GetConceptoGasto/{conceptoGastoId}")
    public TipoGastoDTO getById(@PathVariable UUID conceptoGastoId) {
        return tipoGastoService.getTipoGastoById(conceptoGastoId);
    }

    @PutMapping("/UpdateConceptoGasto/{conceptoGastoId}")
    public ApiResponse update(@PathVariable UUID conceptoGastoId, @RequestBody ActualizarTipoGastoDTO actualizarTipoGastoDTO) {
        return tipoGastoService.updateTipoGasto(conceptoGastoId, actualizarTipoGastoDTO);
    }

    @DeleteMapping("/DeleteConceptoGasto/{conceptoGastoId}")
    public ApiResponse destroy(@PathVariable UUID conceptoGastoId) {
        return tipoGastoService.deleteTipoGasto(conceptoGastoId);
    }

}
