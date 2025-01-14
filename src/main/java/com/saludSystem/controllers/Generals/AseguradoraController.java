package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.ApiResponse;
import com.saludSystem.dtos.Generals.AseguradoraDTO;
import com.saludSystem.services.modules.Generals.AseguradoraService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Aseguradoras")
@RestController
@RequestMapping("/api/Aseguradoras")
public class AseguradoraController {

    @Autowired
    AseguradoraService aseguradoraService;

    @PostMapping("/SaveAseguradora")
    public ResponseEntity<AseguradoraDTO> saveAseguradora(@RequestBody AseguradoraDTO aseguradoraDTO) {
        return ResponseEntity.ok(aseguradoraService.saveAseguradora(aseguradoraDTO));
    }

    @GetMapping("/GetAllAseguradora")
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
    public ResponseEntity<AseguradoraDTO> getAseguradoraById(@PathVariable int aseguradoraId) {
        return aseguradoraService.getAseguradoraById(aseguradoraId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/UpdateAseguradora/{aseguradoraId}")
    public ResponseEntity<AseguradoraDTO> updateAseguradora(
            @PathVariable int aseguradoraId,
            @RequestBody AseguradoraDTO aseguradoraDTO) {
        AseguradoraDTO updatedAseguradora = aseguradoraService.updateAseguradora(aseguradoraId, aseguradoraDTO);
        return ResponseEntity.ok(updatedAseguradora);
    }

    @DeleteMapping("/DeleteAseguradora/{aseguradoraId}")
    public ResponseEntity<?> deleteAseguradora(@PathVariable int aseguradoraId) {
        aseguradoraService.deleteAseguradora(aseguradoraId);
        return ResponseEntity.ok().body(new
                ApiResponse(true, "Aseguradora eliminado con exito"));
    }
}
