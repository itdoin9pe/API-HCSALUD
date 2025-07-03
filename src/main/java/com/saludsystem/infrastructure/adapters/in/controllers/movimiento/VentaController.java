package com.saludsystem.infrastructure.adapters.in.controllers.movimiento;

import com.saludsystem.application.dtos.movimientos.get.VentaByIdDTO;
import com.saludsystem.application.dtos.movimientos.get.VentaDTO;
import com.saludsystem.application.dtos.movimientos.post.CrearVentaDTO;
import com.saludsystem.application.services.movimiento.VentaService;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.movimientos.VentaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "Ventas")
@RestController
@RequestMapping("/api/Ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("/SaveVenta")
    public ApiResponse store(@Valid @RequestBody CrearVentaDTO crearVentaDTO) {
        return ventaService.saveVenta(crearVentaDTO);
    }

    @GetMapping("/GetAllVenta")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VentaResponse.class)))
    })
    public ListResponse<VentaDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return ventaService.getAllVenta(hospitalId, page, rows);
    }

    @GetMapping("/GetVentaList")
    public ResponseEntity<List<VentaDTO>> getAllList() {
        return ResponseEntity.ok(ventaService.getVentaList());
    }

    @GetMapping("/GetVenta/{ventaId}")
    public VentaByIdDTO getById(@PathVariable UUID ventaId) {
        return ventaService.getVentaById(ventaId);
    }

    @DeleteMapping("/DeleteVenta/{ventaId}")
    public ApiResponse destroy(@PathVariable UUID ventaId) {
        return ventaService.deleteVenta(ventaId);
    }
}