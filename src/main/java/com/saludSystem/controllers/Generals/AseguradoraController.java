package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.AseguradoraDTO;
import com.saludSystem.services.modules.Generals.AseguradoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<AseguradoraDTO>> getAllAseguradoras() {
        return ResponseEntity.ok(aseguradoraService.getAllAseguradoras());
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
        return ResponseEntity.ok(aseguradoraService.updateAseguradora(aseguradoraId, aseguradoraDTO));
    }

    @DeleteMapping("/DeleteAseguradora/{aseguradoraId}")
    public ResponseEntity<Void> deleteAseguradora(@PathVariable int aseguradoraId) {
        aseguradoraService.deleteAseguradora(aseguradoraId);
        return ResponseEntity.noContent().build();
    }
}
