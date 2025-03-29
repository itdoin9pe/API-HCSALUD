package com.saludSystem.Mantenimiento.TipoTarjeta.infraestructura.controller;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.ActualizarTipoTarjetaDTO;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.CrearTipoTarjetaDTO;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.TipoTarjetaDTO;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.services.TipoTarjetaService;
import com.saludSystem.Mantenimiento.TipoTarjeta.dominio.TipoTarjetaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TipoTarjeta")
@RestController
@RequestMapping("/api/TipoTarjeta")
public class TipoTarjetaController {

    private final TipoTarjetaService tipoTarjetaService;

    public TipoTarjetaController(TipoTarjetaService tipoTarjetaService) {
        this.tipoTarjetaService = tipoTarjetaService;
    }

    @PostMapping("/SaveTipoTarjeta")
    public ApiResponse store(@Valid @RequestBody CrearTipoTarjetaDTO crearTipoTarjetaDTO) {
        return tipoTarjetaService.saveTipoTarjeta(crearTipoTarjetaDTO);
    }

    @GetMapping("/GetAllTipoTarjeta")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoTarjetaResponse.class)))
    })
    public ListResponse<TipoTarjetaDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return tipoTarjetaService.getAllTipoTarjeta(hospitalId, page, rows);
    }

    @GetMapping("/GetTipoTarjetaList")
    public ResponseEntity<List<TipoTarjetaDTO>> getAllList() {
        return ResponseEntity.ok(tipoTarjetaService.getTipoTarjetaList());
    }

    @GetMapping("/GetTipoTarjeta/{tipoTarjetaId}")
    public TipoTarjetaDTO getById(@PathVariable UUID tipoTarjetaId) {
        return tipoTarjetaService.getTipoTarjetaById(tipoTarjetaId);
    }

    @PutMapping("/UpdateTipoTarjeta/{tipoTarjetaId}")
    public ApiResponse update(@PathVariable UUID tipoTarjetaId, @RequestBody ActualizarTipoTarjetaDTO actualizarTipoTarjetaDTO) {
        return tipoTarjetaService.updateTipoTarjeta(tipoTarjetaId, actualizarTipoTarjetaDTO);
    }

    @DeleteMapping("/DeleteTipoTarjeta/{tipoTarjetaId}")
    public ApiResponse destroy(@PathVariable UUID tipoTarjetaId) {
        return tipoTarjetaService.deleteTipoTarjeta(tipoTarjetaId);
    }

}