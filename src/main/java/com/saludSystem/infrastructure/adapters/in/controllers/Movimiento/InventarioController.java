package com.saludSystem.infrastructure.adapters.in.controllers.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.AlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.GET.InventarioDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearAlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearInventarioDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarAlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarInventarioDTO;
import com.saludSystem.application.services.Movimiento.InventarioService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Movimientos.AlmacenResponse;
import com.saludSystem.infrastructure.adapters.in.response.Movimientos.InventarioResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Inventarios")
@RestController
@RequestMapping("/api/Inventarios")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @PostMapping("/SaveInventario")
    public ApiResponse store(@Valid @RequestBody CrearInventarioDTO crearInventarioDTO) {
        return inventarioService.saveInventario(crearInventarioDTO);
    }

    @GetMapping("/GetAllInventario")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InventarioResponse.class)))
    })
    public ListResponse<InventarioDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return inventarioService.getAllInventario(hospitalId, page, rows);
    }

    @GetMapping("/GetInventario/{inventarioId}")
    public InventarioDTO getById(@PathVariable UUID inventarioId) {
        return inventarioService.getInventarioById(inventarioId);
    }

    @PutMapping("/UpdateInventario/{inventarioId}")
    public ApiResponse update(@PathVariable UUID inventarioId, @RequestBody ActualizarInventarioDTO actualizarInventarioDTO) {
        return inventarioService.updateInventario(inventarioId, actualizarInventarioDTO);
    }

    @DeleteMapping("/DeleteInventario/{inventarioId}")
    public ApiResponse destroy(@PathVariable UUID inventarioId) {
        return inventarioService.deleteInventario(inventarioId);
    }

}
