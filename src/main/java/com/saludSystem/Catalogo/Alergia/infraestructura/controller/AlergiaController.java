package com.saludSystem.Catalogo.Alergia.infraestructura.controller;

import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.ActualizarAlergiaDTO;
import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.AlergiaDTO;
import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.CrearAlergiaDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Catalogo.Alergia.dominio.AlergiaResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Catalogo.Alergia.aplicacion.services.AlergiaService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Alergias")
@RestController
@RequestMapping("/api/Alergias")
public class AlergiaController {

    private final AlergiaService alergiaService;

    public AlergiaController(AlergiaService alergiaService) {
        this.alergiaService = alergiaService;
    }

    @PostMapping("/SaveAlergia")
    public ApiResponse stored(@Valid @RequestBody CrearAlergiaDTO crearAlergiaDTO) {
        return alergiaService.saveAlergia(crearAlergiaDTO);
    }

    @GetMapping("/GetAllAlergia")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AlergiaResponse.class)))
    })
    public ListResponse<AlergiaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return alergiaService.getAllAlergia(hospitalId, page, rows);
    }

    @GetMapping("/GetAlergiaList")
    public ResponseEntity<List<AlergiaDTO>> getAllList() {
        return ResponseEntity.ok(alergiaService.getAlergiaList());
    }

    @GetMapping("/GetAlergia/{alergiaId}")
    public AlergiaDTO getById(@PathVariable UUID alergiaId) {
        return alergiaService.getAlergiaById(alergiaId);
    }

    @PutMapping("/UpdateAlergia/{alergiaId}")
    public ApiResponse update(@PathVariable UUID alergiaId, @RequestBody ActualizarAlergiaDTO actualizarAlergiaDTO) {
        return alergiaService.updateAlergia(alergiaId, actualizarAlergiaDTO);
    }

    @DeleteMapping("/DeleteAlergia/{alergiaId}")
    public ApiResponse destroy(@PathVariable UUID alergiaId) {
        return alergiaService.deleteAlergia(alergiaId);
    }

}