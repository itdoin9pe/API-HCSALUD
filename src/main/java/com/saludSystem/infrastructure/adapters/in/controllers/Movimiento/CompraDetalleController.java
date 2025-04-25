package com.saludSystem.infrastructure.adapters.in.controllers.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.CompraDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearCompraDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarCompraDetalleDTO;
import com.saludSystem.application.services.Movimiento.CompraDetalleService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Movimientos.CompraDetalleResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Tag(name = "ComprasDetalles")
@RestController
@RequestMapping("/api/ComprasDetalles")
public class CompraDetalleController {

    private final CompraDetalleService compraDetalleService;

    public CompraDetalleController(CompraDetalleService compraDetalleService) {
        this.compraDetalleService = compraDetalleService;
    }

    @PostMapping("/SaveCompraDetalle")
    public ApiResponse store(@Valid @RequestBody CrearCompraDetalleDTO crearCompraDetalleDTO) {
        return compraDetalleService.saveCompraDetalle(crearCompraDetalleDTO);
    }

    @GetMapping("/GetAllCompraDetalle")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompraDetalleResponse.class)))
    })
    public ListResponse<CompraDetalleDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return compraDetalleService.getAllCompraDetalle(hospitalId, page, rows);
    }

    @GetMapping("/GetCompraDetalle/{compraDetalleId}")
    public CompraDetalleDTO getById(@PathVariable UUID compraDetalleId) {
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
    }

}