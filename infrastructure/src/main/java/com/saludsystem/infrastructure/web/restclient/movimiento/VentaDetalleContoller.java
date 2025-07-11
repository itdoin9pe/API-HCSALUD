package com.saludsystem.infrastructure.web.restclient.movimiento;

import com.saludsystem.movimientos.application.dto.get.VentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.post.CrearVentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarVentaDetalleDTO;
import com.saludsystem.movimientos.application.service.VentaDetalleService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.movimientos.infrastructure.adapters.in.response.VentaDetalleListResponse;
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
    public ApiResponse store(@Valid @RequestBody VentaDetalleDTO crearVentaDetalleDTO) {
        return ventaDetalleService.saveVentaDetalle(crearVentaDetalleDTO);
    }

    @GetMapping("/GetAllVentaDetalle")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VentaDetalleListResponse.class)))
    })
    public ListResponse<CrearVentaDetalleDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return ventaDetalleService.getAllVentaDetalle(hospitalId, page, rows);
    }

    @GetMapping("/GetVentaDetalle/{ventaDetalleId}")
    public CrearVentaDetalleDTO getById(@PathVariable UUID ventaDetalleId) {
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