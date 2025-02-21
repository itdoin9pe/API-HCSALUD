package com.saludSystem.controllers.ModuleConfiguracion;

import com.saludSystem.dtos.configuration.TipoDocumento.ActualizarTipoDocumentoDTO;
import com.saludSystem.dtos.configuration.TipoDocumento.CrearTipoDocumentoDTO;
import com.saludSystem.dtos.configuration.TipoDocumento.TipoDocumentoDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Configuration.TipoDocumentoResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.services.modules.configuration.TipoDocumento.TipoDocumentoService;
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
    public ListResponse<TipoDocumentoDTO> getAllPage(@RequestParam(name = "hospitalId") UUID hospitalId, @RequestParam(name = "Page", defaultValue = "") int page, @RequestParam(name = "Rows", defaultValue = "") int rows) {
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