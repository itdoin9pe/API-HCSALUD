package com.saludsystem.submodules.core.movimiento.rest.controller.command;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "ComprasDetalles")
@RestController
@RequestMapping("/api/ComprasDetalles")
public class CompraDetalleController {

    /*
    private final CompraDetalleService compraDetalleService;

    public CompraDetalleController(CompraDetalleService compraDetalleService) {
        this.compraDetalleService = compraDetalleService;
    }

    @PostMapping("/SaveCompraDetalle")
    public ApiResponse store(@Valid @RequestBody CompraDetalleDTO compraDetalleDTO) {
        return compraDetalleService.saveCompraDetalle(compraDetalleDTO);
    }

    @GetMapping("/GetAllCompraDetalle")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompraDetalleListResponse.class)))
    })
    public ListResponse<CrearCompraDetalleDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return compraDetalleService.getAllCompraDetalle(hospitalId, page, rows);
    }

    @GetMapping("/GetCompraDetalle/{compraDetalleId}")
    public CrearCompraDetalleDTO getById(@PathVariable UUID compraDetalleId) {
        return compraDetalleService.getCompraDetalleById(compraDetalleId);
    }

    @PutMapping("/UpdateCompraDetalle/{compraDetalleId}")
    public ApiResponse update(
            @PathVariable UUID compraDetalleId,
            @RequestBody ActualizarCompraDetalleDTO actualizarCompraDetalleDTO) {
        return compraDetalleService.updateCompraDetalle(compraDetalleId, actualizarCompraDetalleDTO);
    }

    @DeleteMapping("/DeleteCompraDetalle/{compraDetalleId}")
    public ApiResponse destroy(@PathVariable UUID compraDetalleId) {
        return compraDetalleService.deleteCompraDetalle(compraDetalleId);
    }*/
}