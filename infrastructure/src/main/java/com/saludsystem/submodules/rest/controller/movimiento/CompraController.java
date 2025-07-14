package com.saludsystem.submodules.rest.controller.movimiento;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Compras")
@RestController
@RequestMapping("/api/Compras")
public class CompraController {

    /*
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping("/SaveCompra")
    public ApiResponse store(@Valid @RequestBody CompraDTO compraDTO) {
        return compraService.saveCompra(compraDTO);
    }

    @GetMapping("/GetAllCompra")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VentaListResponse.class)))
    })
    public ListResponse<CrearCompraDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return compraService.getAllCompra(hospitalId, page, rows);
    }

    @GetMapping("/GetCompra/{compraId}")
    public CrearCompraDTO getById(@PathVariable UUID compraId) {
        return compraService.getCompraById(compraId);
    }

    @DeleteMapping("/DeleteCompra/{compraId}")
    public ApiResponse destroy(@PathVariable UUID compraId) {
        return compraService.deleteCompra(compraId);
    }*/
}