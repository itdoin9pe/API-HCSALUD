package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearMarcaDTO;
import com.saludSystem.application.dtos.Operaciones.GET.MarcaDTO;
import com.saludSystem.application.services.Operaciones.MarcaService;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.MarcaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "MarcasMateriales")
@RestController
@RequestMapping("/api/MarcasMateriales")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @PostMapping("/SaveMarcaMaterial")
    public ApiResponse store(@Valid @RequestBody CrearMarcaDTO crearMarcaDTO) {
        return marcaService.saveMarca(crearMarcaDTO);
    }

    @GetMapping("/GetAllMarcaMaterial")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MarcaResponse.class)))
    })
    public ListResponse<MarcaDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return marcaService.getAllMarca(hospitalId, page, rows);
    }

    @GetMapping("/GetMarcaMaterialList")
    public ResponseEntity<List<MarcaDTO>> getAllList() {
        return ResponseEntity.ok(marcaService.getMarcaList());
    }

    @GetMapping("/GetMarcaMaterial/{marcaMaterialId}")
    public MarcaDTO getById(@PathVariable UUID marcaMaterialId) {
        return marcaService.getMarcaById(marcaMaterialId);
    }

    @PutMapping("/UpdateMarcaMaterial/{marcaMaterialId}")
    public ApiResponse update(@PathVariable UUID marcaMaterialId, @RequestBody ActualizarMarcaDTO actualizarMarcaDTO) {
        return marcaService.updateMarca(marcaMaterialId, actualizarMarcaDTO);
    }

    @DeleteMapping("/DeleteMarcaMaterial/{marcaMaterialId}")
    public ApiResponse destroy(@PathVariable UUID marcaMaterialId) {
        return marcaService.deleteMarca(marcaMaterialId);
    }

}