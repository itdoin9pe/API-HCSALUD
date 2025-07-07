package com.saludsystem.operaciones.infrastructure.adapters.in.controller;

import com.saludsystem.operaciones.application.dto.res.ProductoDTO;
import com.saludsystem.operaciones.application.dto.req.CrearProductoDTO;
import com.saludsystem.operaciones.application.dto.req.ActualizarProductoDTO;
import com.saludsystem.operaciones.application.service.ProductoService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.operaciones.infrastructure.adapters.in.response.ProductoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Productos")
@RestController
@RequestMapping("/api/Productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/SaveProducto")
    public ApiResponse store(@Valid @RequestBody CrearProductoDTO crearProductoDTO) {
        return productoService.saveProducto(crearProductoDTO);
    }

    @GetMapping("/GetAllProducto")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductoResponse.class)))
    })
    public ListResponse<ProductoDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return productoService.getAllProducto(hospitalId, page, rows);
    }

    @GetMapping("/GetProductoList")
    public ResponseEntity<List<ProductoDTO>> getAllPage() {
        return ResponseEntity.ok(productoService.getProductoList());
    }

    @GetMapping("/GetProducto/{productoId}")
    public ProductoDTO getById(@PathVariable UUID productoId) {
        return productoService.getProductoById(productoId);
    }

    @PutMapping("/UpdateProducto/{productoId}")
    public ApiResponse update(@PathVariable UUID productoId, @RequestBody ActualizarProductoDTO actualizarProductoDTO) {
        return productoService.updateProducto(productoId, actualizarProductoDTO);
    }

    @DeleteMapping("/DeleteProducto/{productoId}")
    public ApiResponse destroy(@PathVariable UUID productoId) {
        return productoService.deleteProducto(productoId);
    }

}