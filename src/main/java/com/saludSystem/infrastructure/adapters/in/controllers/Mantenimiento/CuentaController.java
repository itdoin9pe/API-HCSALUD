package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearCuentaDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.CuentaDTO;
import com.saludSystem.application.services.Mantenimiento.CuentaService;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.CuentaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "CuentasPagar")
@RestController
@RequestMapping("/api/CuentasPagar")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping("/SaveCuentaPagar")
    public ApiResponse stored(@Valid @RequestBody CrearCuentaDTO crearCuentaDTO) {
        return cuentaService.saveCuenta(crearCuentaDTO);
    }

    @GetMapping("/GetAllCuentaPagar")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CuentaResponse.class)))
    })
    public ListResponse<CuentaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return cuentaService.getAllCuenta(hospitalId, page, rows);
    }

    @GetMapping("/GetCuentaPagarList")
    public ResponseEntity<List<CuentaDTO>> getAllList() {
        return ResponseEntity.ok(cuentaService.getCuentaList());
    }

    @GetMapping("/GetCuentaPagar/{cuentaPagarId}")
    public CuentaDTO getById(@PathVariable UUID cuentaPagarId) {
        return cuentaService.getCuentaById(cuentaPagarId);
    }

    @PutMapping("/UpdateCuentaPagar/{cuentaPagarId}")
    public ApiResponse update(@PathVariable UUID cuentaPagarId, @RequestBody ActualizarCuentaDTO actualizarCuentaDTO) {
        return cuentaService.updateCuenta(cuentaPagarId, actualizarCuentaDTO);
    }

    @DeleteMapping("/DeleteCuentaPagar/{cuentaPagarId}")
    public ApiResponse destroy(@PathVariable UUID cuentaPagarId) {
        return cuentaService.deleteCuenta(cuentaPagarId);
    }

}