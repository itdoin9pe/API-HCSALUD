package com.saludSystem.Catalogo.TipoConcepto.infraestructura.controller;

import com.saludSystem.Catalogo.TipoConcepto.aplicacion.dtos.ActualizarTipoConceptoDTO;
import com.saludSystem.Catalogo.TipoConcepto.aplicacion.dtos.CrearTipoConceptoDTO;
import com.saludSystem.Catalogo.TipoConcepto.aplicacion.dtos.TipoConceptoDTO;
import com.saludSystem.Catalogo.TipoConcepto.aplicacion.services.TipoConceptoService;
import com.saludSystem.Catalogo.TipoConcepto.dominio.TipoConceptoResponse;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TiposConceptos")
@RestController
@RequestMapping("/api/TiposConceptos")
public class TipoConceptoController {

    private final TipoConceptoService tipoConceptoService;

    public TipoConceptoController(TipoConceptoService tipoConceptoService) {
        this.tipoConceptoService = tipoConceptoService;
    }

    @PostMapping("/SaveTipoConcepto")
    public ApiResponse store(@Valid @RequestBody CrearTipoConceptoDTO crearTipoConceptoDTO){
        return tipoConceptoService.saveTipoConcepto(crearTipoConceptoDTO);
    }

    @GetMapping("/GetAllTipoConcepto")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoConceptoResponse.class)))
    })
    public ListResponse<TipoConceptoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return tipoConceptoService.getAllTipoConcepto(hospitalId, page, rows);
    }

    @GetMapping("/GetTipoConceptoList")
    public ResponseEntity<List<TipoConceptoDTO>> getAllList() {
        return ResponseEntity.ok(tipoConceptoService.getTipoConceptoList());
    }

    @GetMapping("/GetTipoConcepto/{tipoConceptoId}")
    public TipoConceptoDTO getById(@PathVariable UUID tipoConceptoId) {
        return tipoConceptoService.getTipoConceptoById(tipoConceptoId);
    }

    @PutMapping("/UpdateTipoConcepto/{tipoConceptoId}")
    public ApiResponse update(@PathVariable UUID tipoConceptoId, @RequestBody ActualizarTipoConceptoDTO actualizarTipoConceptoDTO) {
        return tipoConceptoService.updateTipoConcepto(tipoConceptoId, actualizarTipoConceptoDTO);
    }

    @DeleteMapping("/DeleteTipoConcepto/{tipoConceptoId}")
    public ApiResponse destroy(@PathVariable UUID tipoConceptoId) {
        return tipoConceptoService.deleteTipoConcepto(tipoConceptoId);
    }

}