package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.ApiResponse;
import com.saludSystem.dtos.Generals.InformacionClinicaDTO;
import com.saludSystem.services.modules.Generals.InformacionClinica.InformacionClinicaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "InformacionClinicas")
@RestController
@RequestMapping("/api/InformacionClinicas")
public class InformacionClinicaController {

    private final InformacionClinicaService informacionClinicaService;

    public InformacionClinicaController(InformacionClinicaService informacionClinicaService){
        this.informacionClinicaService = informacionClinicaService;
    }

    @GetMapping("/GetAllInformacionClinica")
    public ResponseEntity<List<InformacionClinicaDTO>> getAllInformacionClinicas(){
        List<InformacionClinicaDTO> informacionClinicas = informacionClinicaService.getAllInformacionClinica();
        return new ResponseEntity<>(informacionClinicas, HttpStatus.OK);
    }

    @GetMapping("/GetInformacionClinica/{id}")
    public ResponseEntity<InformacionClinicaDTO> getInformacionClinicaById(@PathVariable Integer id){
        return informacionClinicaService.getInformacionClinicaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/SaveInformacionClinica")
    public ResponseEntity<InformacionClinicaDTO> createInformacionClinica(@Valid @RequestBody InformacionClinicaDTO informacionClinicaDTO){
        return ResponseEntity.ok(informacionClinicaService.saveInformacionClinica(informacionClinicaDTO));
    }

    @PutMapping("/UpdateInformacionClinica/{id}")
    public ResponseEntity<InformacionClinicaDTO> updateInformacionClinica(
            @PathVariable Integer id,
            @RequestBody InformacionClinicaDTO informacionClinicaDTO
    ){
        InformacionClinicaDTO updatedInformacionClinica = informacionClinicaService.updateInformacionClinica(id, informacionClinicaDTO);
        return ResponseEntity.ok(updatedInformacionClinica);
    }

    @DeleteMapping("/DeleteInformacionClinica/{id}")
    public ResponseEntity<?> deleteInformacionClinica(@PathVariable Integer id){
        informacionClinicaService.deleteInformacionClinica(id);
        return ResponseEntity.ok().body(new ApiResponse(true, "Informacion Clinica eliminado con exito"));
    }
}
