package com.saludSystem.Mantenimiento.Cajas.infraestructura.controller;

import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.ActualizarAlergiaDTO;
import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.AlergiaDTO;
import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.CrearAlergiaDTO;
import com.saludSystem.Catalogo.Alergia.dominio.AlergiaResponse;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.dtos.ActualizarCajaDTO;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.dtos.CajaDTO;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.dtos.CrearCajaDTO;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.services.CajaService;
import com.saludSystem.Mantenimiento.Cajas.dominio.CajaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Cajas")
@RestController
@RequestMapping("/api/Cajas")
public class CajaController {

    private final CajaService cajaService;

    public CajaController(CajaService cajaService) {
        this.cajaService = cajaService;
    }

    @PostMapping("/SaveCaja")
    public ApiResponse stored(@Valid @RequestBody CrearCajaDTO crearCajaDTO) {
        return cajaService.saveCaja(crearCajaDTO);
    }

    @GetMapping("/GetAllCaja")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CajaResponse.class)))
    })
    public ListResponse<CajaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return cajaService.getAllCaja(hospitalId, page, rows);
    }

    @GetMapping("/GetCajaList")
    public ResponseEntity<List<CajaDTO>> getAllList() {
        return ResponseEntity.ok(cajaService.getCajaList());
    }

    @GetMapping("/GetCaja/{cajaId}")
    public CajaDTO getById(@PathVariable UUID cajaId) {
        return cajaService.getCajaById(cajaId);
    }

    @PutMapping("/UpdateCaja/{cajaId}")
    public ApiResponse update(@PathVariable UUID cajaId, @RequestBody ActualizarCajaDTO actualizarCajaDTO) {
        return cajaService.updateCaja(cajaId, actualizarCajaDTO);
    }

    @DeleteMapping("/DeleteCaja/{cajaId}")
    public ApiResponse destroy(@PathVariable UUID cajaId) {
        return cajaService.deleteCaja(cajaId);
    }

}
