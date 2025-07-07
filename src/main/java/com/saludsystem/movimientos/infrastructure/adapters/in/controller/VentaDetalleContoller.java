package com.saludsystem.movimientos.infrastructure.adapters.in.controller;

import com.saludsystem.movimientos.application.dto.res.VentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.req.CrearVentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.ActualizarVentaDetalleDTO;
import com.saludsystem.movimientos.application.service.VentaDetalleService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.movimientos.infrastructure.adapters.in.response.VentaDetalleResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "VentasDetalles")
@RestController
@RequestMapping("/api/VentasDetalles")
public class VentaDetalleContoller {

    private final VentaDetalleService ventaDetalleService;

    public VentaDetalleContoller(VentaDetalleService ventaDetalleService) {
        this.ventaDetalleService = ventaDetalleService;
    }

    @PostMapping("/SaveVentaDetalle")
    public ApiResponse store(@Valid @RequestBody CrearVentaDetalleDTO crearVentaDetalleDTO) {
        return ventaDetalleService.saveVentaDetalle(crearVentaDetalleDTO);
    }

    @GetMapping("/GetAllVentaDetalle")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VentaDetalleResponse.class)))
    })
    public ListResponse<VentaDetalleDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return ventaDetalleService.getAllVentaDetalle(hospitalId, page, rows);
    }

    @GetMapping("/GetVentaDetalle/{ventaDetalleId}")
    public VentaDetalleDTO getById(@PathVariable UUID ventaDetalleId) {
        return ventaDetalleService.getVentaDetalleById(ventaDetalleId);
    }

    @PutMapping("/UpdateVentaDetalle/{ventaDetalleId}")
    public ApiResponse update(@PathVariable UUID ventaDetalleId, @RequestBody ActualizarVentaDetalleDTO actualizarVentaDetalleDTO) {
        return ventaDetalleService.updateVentaDetalle(ventaDetalleId, actualizarVentaDetalleDTO);
    }

    @DeleteMapping("/DeleteVentaDetalle/{ventaDetalleId}")
    public ApiResponse destroy(@PathVariable UUID ventaDetalleId) {
        return ventaDetalleService.deleteVentaDetalle(ventaDetalleId);
    }
}