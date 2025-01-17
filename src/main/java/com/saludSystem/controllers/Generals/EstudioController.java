package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.EstudioDTO;
import com.saludSystem.services.modules.Generals.Estudios.EstudioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Estudios")
@RestController
@RequestMapping("/api/Estudios")
public class EstudioController {

    private final EstudioService estudioService;

    public EstudioController(EstudioService estudioService){
        this.estudioService = estudioService;
    }

    @GetMapping("/GetAllEstudio")
    public ResponseEntity<List<EstudioDTO>> getAllEstudios() {
        List<EstudioDTO> estudios = estudioService.getAllEstudios();
        return new ResponseEntity<>(estudios, HttpStatus.OK);
    }

    @GetMapping("GetEstudio/{id}")
    public ResponseEntity<EstudioDTO> getEstudioById(@PathVariable int id) {
        return estudioService.getEstudioById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/SaveEstudio")
    public ResponseEntity<EstudioDTO> createEstudio(@RequestBody EstudioDTO estudioDTO) {
        EstudioDTO savedEstudio = estudioService.saveEstudio(estudioDTO);
        return ResponseEntity.ok(savedEstudio);
    }

    @PutMapping("/UpdateEstudio/{id}")
    public ResponseEntity<EstudioDTO> updateEstudio(
            @PathVariable int id,
            @RequestBody EstudioDTO estudioDTO) {
        EstudioDTO updatedEstudio = estudioService.updateEstudio(id, estudioDTO);
        return new ResponseEntity<>(updatedEstudio, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteEstudio/{id}")
    public ResponseEntity<Void> deleteEstudio(@PathVariable int id) {
        estudioService.deleteEstudio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
