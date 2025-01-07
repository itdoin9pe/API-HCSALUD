package com.saludSystem.controllers.ModuleConfiguracion;

import com.saludSystem.dtos.configuration.SedeDTO;
import com.saludSystem.services.modules.configuration.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Sedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping("/GetAllSede")
    public ResponseEntity<List<SedeDTO>> getAllSedes(){
        List<SedeDTO> sedes = sedeService.getAllSedes();
        return new ResponseEntity<>(sedes, HttpStatus.OK);
    }

    @GetMapping("/GetSede/{id}")
    public ResponseEntity<SedeDTO> getSedeById(@PathVariable Long id){
        return sedeService.getSedeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/SaveSede")
    public ResponseEntity<SedeDTO> createSede(@RequestBody SedeDTO sedeDTO){
        SedeDTO savedSede = sedeService.saveSede(sedeDTO);
        return ResponseEntity.ok(savedSede);
    }

    @PutMapping("/UpdateSede/{id}")
    public ResponseEntity<SedeDTO> updateSede(
            @PathVariable Long id,
            @RequestBody SedeDTO sedeDTO
    ){
        SedeDTO updatedSede = sedeService.updateSede(id, sedeDTO);
        return new ResponseEntity<>(updatedSede, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteSede/{id}")
    public ResponseEntity<Void> deleteSede(@PathVariable Long id){
        sedeService.deleteSede(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
