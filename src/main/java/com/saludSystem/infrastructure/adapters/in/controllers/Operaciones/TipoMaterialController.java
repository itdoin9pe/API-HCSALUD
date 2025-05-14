package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.application.dtos.Operaciones.GET.TipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearTipoMaterialDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarTipoMaterialDTO;
import com.saludSystem.application.services.Operaciones.TipoMaterialService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.TipoMaterialResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TiposMateriales")
@RestController
@RequestMapping("/api/TiposMateriales")
public class TipoMaterialController {

    private final TipoMaterialService tipoMaterialService;

    public TipoMaterialController(TipoMaterialService tipoMaterialService) {
        this.tipoMaterialService = tipoMaterialService;
    }

    @PostMapping("/SaveTipoMaterial")
    public ApiResponse store(@Valid @RequestBody CrearTipoMaterialDTO crearTipoMaterialDTO) {
        return tipoMaterialService.saveTipoMaterial(crearTipoMaterialDTO);
    }

    @GetMapping("/GetAllTipoMaterial")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoMaterialResponse.class)))
    })
    public ListResponse<TipoMaterialDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return tipoMaterialService.getAllTipoMaterial(hospitalId, page, rows);
    }

    @GetMapping("/GetTipoMaterialList")
    public ResponseEntity<List<TipoMaterialDTO>> getAllList() {
        return ResponseEntity.ok(tipoMaterialService.getTipoMaterialList());
    }

    @GetMapping("/GetTipoMaterial/{tipoMaterialId}")
    public TipoMaterialDTO getById(@PathVariable UUID tipoMaterialId) {
        return tipoMaterialService.getTipoMaterialById(tipoMaterialId);
    }

    @PutMapping("/UpdateTipoMaterial/{tipoMaterialId}")
    public ApiResponse update(@PathVariable UUID tipoMaterialId, @RequestBody ActualizarTipoMaterialDTO actualizarTipoMaterialDTO) {
        return tipoMaterialService.updateTipoMaterial(tipoMaterialId, actualizarTipoMaterialDTO);
    }

    @DeleteMapping("/DeleteTipoMaterial/{tipoMaterialId}")
    public ApiResponse destroy(@PathVariable UUID tipoMaterialId) {
        return tipoMaterialService.deleteTipoMaterial(tipoMaterialId);
    }

}