package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.PaisDTO;
import com.saludSystem.services.modules.Generals.Pais.PaisService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Paises")
@RestController
@RequestMapping("/api/Paises")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService){
        this.paisService = paisService;
    }

    @PostMapping("/SavePais")
    public ResponseEntity<PaisDTO> savePais(@Valid @RequestBody PaisDTO paisDTO) {
        return ResponseEntity.ok(paisService.savePais(paisDTO));
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
