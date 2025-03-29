package com.saludSystem.Mantenimiento.Moneda.infraestructura.controller;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos.ActualizarMonedaDTO;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos.CrearMonedaDTO;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.dtos.MonedaDTO;
import com.saludSystem.Mantenimiento.Moneda.aplicacion.services.MonedaService;
import com.saludSystem.Mantenimiento.Moneda.dominio.MonedaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TiposMonedas")
@RestController
@RequestMapping("/api/TiposMonedas")
public class MonedaController {

    private final MonedaService monedaService;

    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }

    @PostMapping("/SaveTipoMoneda")
    public ApiResponse store(@Valid @RequestBody CrearMonedaDTO crearMonedaDTO) {
        return monedaService.saveMoneda(crearMonedaDTO);
    }

    @GetMapping("/GetAllTipoMoneda")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MonedaResponse.class)))
    })
    public ListResponse<MonedaDTO> getAllPage
            (@RequestParam(name = "hospitalId") UUID hospitalId,
             @RequestParam(name = "Page", defaultValue = "") int page, @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return monedaService.getAllMoneda(hospitalId, page, rows);
    }

    @GetMapping("/GetTipoMonedaList")
    public ResponseEntity<List<MonedaDTO>> getAllList() {
        return ResponseEntity.ok(monedaService.getMonedaList());
    }

    @GetMapping("/GetTipoMoneda/{tipoMonedaId}")
    public MonedaDTO getById(@PathVariable UUID tipoMonedaId) {
        return monedaService.getMonedaById(tipoMonedaId);
    }

    @PutMapping("/UpdateTipoMoneda/{tipoMonedaId}")
    public ApiResponse update(@PathVariable UUID tipoMonedaId, @RequestBody ActualizarMonedaDTO actualizarMonedaDTO) {
        return monedaService.updateMoneda(tipoMonedaId, actualizarMonedaDTO);
    }

    @DeleteMapping("/DeleteTipoMoneda/{tipoMonedaId}")
    public ApiResponse destroy(@PathVariable UUID tipoMonedaId) {
        return monedaService.deleteMoneda(tipoMonedaId);
    }

}