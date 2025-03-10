package com.saludSystem.Configuracion.TipoDocumento.infraestructura.controller;

import com.saludSystem.Configuracion.TipoDocumento.aplicacion.dtos.ActualizarTipoDocumentoDTO;
import com.saludSystem.Configuracion.TipoDocumento.aplicacion.dtos.CrearTipoDocumentoDTO;
import com.saludSystem.Configuracion.TipoDocumento.aplicacion.dtos.TipoDocumentoDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Configuracion.TipoDocumento.dominio.TipoDocumentoResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Configuracion.TipoDocumento.aplicacion.services.TipoDocumentoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TipoDocumentos")
@RestController
@RequestMapping("/api/TipoDocumentos")
public class TipoDocumentoController {

    private final TipoDocumentoService tipoDocumentoService;

    public TipoDocumentoController(TipoDocumentoService tipoDocumentoService) {
        this.tipoDocumentoService = tipoDocumentoService;
    }

    @PostMapping("/SaveTipoDocumento")
    public ApiResponse stored(@Valid @RequestBody CrearTipoDocumentoDTO crearTipoDocumentoDTO) {
        return tipoDocumentoService.saveTipoDocumento(crearTipoDocumentoDTO);
    }

    @GetMapping("/GetAllTipoDocumento")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoDocumentoResponse.class)))
    })
    public ListResponse<TipoDocumentoDTO> getAllPage(@RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page, @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return tipoDocumentoService.getAllTipoDocumento(hospitalId, page, rows);
    }

    @GetMapping("/GetTipoDocumentoList")
    public ResponseEntity<List<TipoDocumentoDTO>> getAllList() {
        return ResponseEntity.ok(tipoDocumentoService.getTipoDocumentoList());
    }

    @GetMapping("/GetTipoDocumento/{tDocumentoId}")
    public TipoDocumentoDTO getById(@PathVariable UUID tDocumentoId) {
        return tipoDocumentoService.getTipoDocumentoById(tDocumentoId);
    }

    @PutMapping("/UpdateTipoDocumento/{tDocumentoId}")
    public ApiResponse update(@PathVariable UUID tDocumentoId, @RequestBody ActualizarTipoDocumentoDTO actualizarTipoDocumentoDTO) {
        return tipoDocumentoService.updateTipoDocumento(tDocumentoId, actualizarTipoDocumentoDTO);
    }

    @DeleteMapping("/DeleteTipoDocumento/{tDocumentoId}")
    public ApiResponse destroy(@PathVariable UUID tDocumentoId) {
        return tipoDocumentoService.deleteTipoDocumento(tDocumentoId);
    }

}