package com.saludSystem.infrastructure.adapters.in.controllers.Movimiento;

import com.saludSystem.application.dtos.Movimientos.GET.AlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearAlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarAlmacenDTO;
import com.saludSystem.application.services.Movimiento.AlmacenService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Movimientos.AlmacenResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Almacenes")
@RestController
@RequestMapping("/api/Almacenes")
public class AlmacenController {

    private final AlmacenService almacenService;

    public AlmacenController(AlmacenService almacenService) {
        this.almacenService = almacenService;
    }

    @PostMapping("/SaveAlmacen")
    public ApiResponse store(@Valid @RequestBody CrearAlmacenDTO crearAlmacenDTO) {
        return almacenService.saveAlmacen(crearAlmacenDTO);
    }

    @GetMapping("/GetAllAlmacen")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlmacenResponse.class)))
    })
    public ListResponse<AlmacenDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return almacenService.getAllAlmacen(hospitalId, page, rows);
    }

    @GetMapping("/GetAlmacenList")
    public ResponseEntity<List<AlmacenDTO>> getAllList() {
        return ResponseEntity.ok(almacenService.getAlmacenList());
    }

    @GetMapping("/GetAlmacen/{almacenId}")
    public AlmacenDTO getById(@PathVariable UUID almacenId) {
        return almacenService.getAlmacenById(almacenId);
    }

    @PutMapping("/UpdateAlmacen/{almacenId}")
    public ApiResponse update(@PathVariable UUID almacenId, @RequestBody ActualizarAlmacenDTO actualizarAlmacenDTO) {
        return almacenService.updateAlmacen(almacenId, actualizarAlmacenDTO);
    }

    @DeleteMapping("/DeleteAlmacen/{almacenId}")
    public ApiResponse destroy(@PathVariable UUID almacenId) {
        return almacenService.deleteAlmacen(almacenId);
    }
}