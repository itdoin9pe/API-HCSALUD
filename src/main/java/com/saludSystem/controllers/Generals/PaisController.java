package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.PaisDTO;
import com.saludSystem.services.modules.Generals.PaisService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Paises")
@RestController
@RequestMapping("/api/Paises")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @PostMapping("/SavePais")
    public ResponseEntity<PaisDTO> savePais(@RequestBody PaisDTO paisDTO) {
        PaisDTO savedPais = paisService.savePais(paisDTO);
        return ResponseEntity.ok(savedPais);
    }

    @GetMapping("/GetAllPais")
    public ResponseEntity<List<PaisDTO>> getAllPais() {
        List<PaisDTO> paisList = paisService.getAllPais();
        return ResponseEntity.ok(paisList);
    }

    @GetMapping("/GetPaisList")
    public ResponseEntity<List<String>> getPaisList() {
        List<String> paisNames = paisService.getPaisList();
        return ResponseEntity.ok(paisNames);
    }
}
