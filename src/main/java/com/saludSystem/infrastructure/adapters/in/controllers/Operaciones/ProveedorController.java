package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.ProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearProveedorDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarProveedorDTO;
import com.saludSystem.application.services.Operaciones.ProveedorService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.ProveedorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Proveedor")
@RestController
@RequestMapping("/api/Proveedor")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping("/SaveProveedor")
    public ApiResponse store(@Valid @RequestBody CrearProveedorDTO crearProveedorDTO) {
        return proveedorService.saveProveedor(crearProveedorDTO);
    }

    @GetMapping("/GetAllProveedor")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProveedorResponse.class)))
    })
    public ListResponse<ProveedorDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return proveedorService.getAllProveedor(hospitalId, page, rows);
    }

    @GetMapping("/GetProveedorList")
    public ResponseEntity<List<ProveedorDTO>> getAllList() {
        return ResponseEntity.ok(proveedorService.getProveedorList());
    }

    @GetMapping("/GetProveedor/{proveedorId}")
    public ProveedorDTO getById(@PathVariable UUID proveedorId) {
        return proveedorService.getProveedorById(proveedorId);
    }

    @PutMapping("/UpdateProveedor/{proveedorId}")
    public ApiResponse update(@PathVariable UUID proveedorId, @RequestBody ActualizarProveedorDTO actualizarProveedorDTO) {
        return proveedorService.updateProveedor(proveedorId, actualizarProveedorDTO);
    }

    @DeleteMapping("/DeleteProveedor/{proveedorId}")
    public ApiResponse destroy(@PathVariable UUID proveedorId) {
        return proveedorService.deleteProveedor(proveedorId);
    }

}