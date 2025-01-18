package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.Generals.AseguradoraDTO;
import com.saludSystem.dtos.responses.Generals.AseguradoraResponse;
import com.saludSystem.services.modules.Generals.Aseguradoras.AseguradoraService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Tag(name = "Aseguradoras")
@RestController
@RequestMapping("/api/Aseguradoras")
public class AseguradoraController {

    private final AseguradoraService aseguradoraService;

    public AseguradoraController(AseguradoraService aseguradoraService) {
        this.aseguradoraService = aseguradoraService;
    }

    @PostMapping("/SaveAseguradora")
    public ResponseEntity<ApiResponse> saveAseguradora(@Valid @RequestBody AseguradoraDTO aseguradoraDTO) {
        aseguradoraService.saveAseguradora(aseguradoraDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Aseguradora creada con éxito"));
    }

    @GetMapping("/GetAllAseguradora")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AseguradoraResponse.class)))
    })
    public ResponseEntity<Map<String, Object>> getAllAseguradora(
            @RequestParam(name = "Page", defaultValue = "1") int page,
            @RequestParam(name = "Rows", defaultValue = "10") int rows
    ) {
        List<AseguradoraDTO> aseguradoras = aseguradoraService.getAllAseguradoras(page, rows);
        long totalData = aseguradoraService.getTotalCount();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("data", aseguradoras);
        response.put("totalData", totalData);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/GetAseguradoraList")
    public ResponseEntity<List<AseguradoraDTO>> getAseguradoraList() {
        return ResponseEntity.ok(aseguradoraService.getAseguradoraList());
    }

    @GetMapping("/GetAseguradora/{aseguradoraId}")
    public ResponseEntity<AseguradoraDTO> getAseguradoraById(@PathVariable UUID aseguradoraId) {
        return aseguradoraService.getAseguradoraById(aseguradoraId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/UpdateAseguradora/{aseguradoraId}")
    public ResponseEntity<AseguradoraDTO> updateAseguradora(
            @PathVariable UUID aseguradoraId,
            @RequestBody AseguradoraDTO aseguradoraDTO) {
        AseguradoraDTO updatedAseguradora = aseguradoraService.updateAseguradora(aseguradoraId, aseguradoraDTO);
        return ResponseEntity.ok(updatedAseguradora);
    }

    @DeleteMapping("/DeleteAseguradora/{aseguradoraId}")
    public ResponseEntity<?> deleteAseguradora(@PathVariable UUID aseguradoraId) {
        aseguradoraService.deleteAseguradora(aseguradoraId);
        return ResponseEntity.ok().body(new
                ApiResponse(true, "Aseguradora eliminado con exito"));
    }
}
