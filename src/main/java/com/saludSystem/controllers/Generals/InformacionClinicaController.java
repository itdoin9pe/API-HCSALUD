package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.InformacionClinicaDTO;
import com.saludSystem.services.modules.Generals.InformacionClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/InformacionClinicas")
public class InformacionClinicaController {

    @Autowired
    private InformacionClinicaService informacionClinicaService;

    @GetMapping("/GetAllInformacionClinica")
    public ResponseEntity<List<InformacionClinicaDTO>> getAllInformacionClinicas(){
        List<InformacionClinicaDTO> informacionClinicas = informacionClinicaService.getAllInformacionClinica();
        return new ResponseEntity<>(informacionClinicas, HttpStatus.OK);
    }

    @GetMapping("/GetInformacionClinica/{id}")
    public ResponseEntity<InformacionClinicaDTO> getInformacionClinicaById(@PathVariable int id){
        return informacionClinicaService.getInformacionClinicaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/SaveInformacionCLinica")
    public ResponseEntity<InformacionClinicaDTO> createInformacionClinica(@RequestBody InformacionClinicaDTO informacionClinicaDTO){
        InformacionClinicaDTO savedInformacionClinica = informacionClinicaService.saveInformacionClinica(informacionClinicaDTO);
        return ResponseEntity.ok(savedInformacionClinica);
    }

    @PutMapping("/UpdateInformacionClinica/{id}")
    public ResponseEntity<InformacionClinicaDTO> updateInformacionClinica(
            @PathVariable int id,
            @RequestBody InformacionClinicaDTO informacionClinicaDTO
    ){
        InformacionClinicaDTO updatedInformacionClinica = informacionClinicaService.updateInformacionClinica(id, informacionClinicaDTO);
        return new ResponseEntity<>(updatedInformacionClinica, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteInformacionClinica/{id}")
    public ResponseEntity<Void> deleteInformacionClinica(@PathVariable int id){
        informacionClinicaService.deleteInformacionClinica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
