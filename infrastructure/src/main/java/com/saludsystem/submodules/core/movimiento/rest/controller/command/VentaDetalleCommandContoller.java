package com.saludsystem.submodules.core.movimiento.rest.controller.command;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "VentasDetalles")
@RestController
@RequestMapping("/api/VentasDetalles")
public class VentaDetalleContoller {

    /*
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
    }*/
}