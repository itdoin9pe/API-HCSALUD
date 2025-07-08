package com.saludsystem.movimientos.infrastructure.adapters.in.controller;

import com.saludsystem.movimientos.application.dto.res.CompraResponse;
import com.saludsystem.movimientos.application.dto.req.CompraRequest;
import com.saludsystem.movimientos.application.service.CompraService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.movimientos.infrastructure.adapters.in.response.VentaListResponse;
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
    public ApiResponse store(@Valid @RequestBody CompraRequest compraRequest) {
        return compraService.saveCompra(compraRequest);
    }

    @GetMapping("/GetAllCompra")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VentaListResponse.class)))
    })
    public ListResponse<CompraResponse> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return compraService.getAllCompra(hospitalId, page, rows);
    }

    @GetMapping("/GetCompra/{compraId}")
    public CompraResponse getById(@PathVariable UUID compraId) {
        return compraService.getCompraById(compraId);
    }

    @DeleteMapping("/DeleteCompra/{compraId}")
    public ApiResponse destroy(@PathVariable UUID compraId) {
        return compraService.deleteCompra(compraId);
    }
}