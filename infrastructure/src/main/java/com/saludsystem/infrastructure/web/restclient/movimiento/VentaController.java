package com.saludsystem.infrastructure.web.restclient.movimiento;

import com.saludsystem.movimientos.application.dto.post.CrearVentaDTO;
import com.saludsystem.movimientos.application.dto.get.VentaDTO;
import com.saludsystem.movimientos.application.service.VentaService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.movimientos.infrastructure.adapters.in.response.VentaListResponse;
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
                            schema = @Schema(implementation = VentaListResponse.class)))
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
    public VentaDTO getById(@PathVariable UUID ventaId) {
        return ventaService.getVentaById(ventaId);
    }

    @DeleteMapping("/DeleteVenta/{ventaId}")
    public ApiResponse destroy(@PathVariable UUID ventaId) {
        return ventaService.deleteVenta(ventaId);
    }
}