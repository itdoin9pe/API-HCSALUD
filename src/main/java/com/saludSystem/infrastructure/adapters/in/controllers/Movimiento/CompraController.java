package com.saludSystem.infrastructure.adapters.in.controllers.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.CompraDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearCompraDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearVentaDTO;
import com.saludSystem.application.services.Movimiento.CompraService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Movimientos.VentaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Compras")
@RestController
@RequestMapping("/api/Compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/SaveCompra")
    public ApiResponse store(@Valid @RequestBody CrearCompraDTO crearCompraDTO) {
        return compraService.saveCompra(crearCompraDTO);
    }

    @GetMapping("/GetAllCompra")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VentaResponse.class)))
    })
    public ListResponse<CompraDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return compraService.getAllCompra(hospitalId, page, rows);
    }

    @GetMapping("/GetCompra/{compraId}")
    public CompraDTO getById(@PathVariable UUID compraId) {
        return compraService.getCompraById(compraId);
    }

    @DeleteMapping("/DeleteCompra/{compraId}")
    public ApiResponse destroy(@PathVariable UUID compraId) {
        return compraService.deleteCompra(compraId);
    }

}