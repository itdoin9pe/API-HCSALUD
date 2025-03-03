package com.saludSystem.infrastructure.controllers.Generals;
/*
import com.saludSystem.dtos.Generals.InformacionClinica.ActualizarInformacionClinicaDTO;
import com.saludSystem.dtos.Generals.InformacionClinica.CrearInformacionClinicaDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.Generals.InformacionClinica.InformacionClinicaDTO;
import com.saludSystem.services.modules.Generals.InformacionClinica.InformacionClinicaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "InformacionClinicas")
@RestController
@RequestMapping("/api/InformacionClinicas")
public class InformacionClinicaController {

    private final InformacionClinicaService informacionClinicaService;

    public InformacionClinicaController(InformacionClinicaService informacionClinicaService){
        this.informacionClinicaService = informacionClinicaService;
    }

    @GetMapping("/GetInformacionClinicaList")
    public ResponseEntity<List<InformacionClinicaDTO>> getAllList(){
        return ResponseEntity.ok(informacionClinicaService.getInformacionClinicaList());
    }

    @PostMapping("/SaveInformacionClinica")
    public ApiResponse store(@Valid @RequestBody CrearInformacionClinicaDTO crearInformacionClinicaDTO){
        return informacionClinicaService.saveInformacionClinica(crearInformacionClinicaDTO);
    }

    @DeleteMapping("/DeleteInformacionClinica/{informacionClinicaId}")
    public ApiResponse destroy(@PathVariable UUID informacionClinicaId){
        return informacionClinicaService.deleteInformacionClinica(informacionClinicaId);
    }

    @PutMapping("/UpdateInformacionClinica/{informacionClinicaId}")
    public ApiResponse update(@PathVariable UUID informacionClinicaId, @RequestBody ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO){
        return informacionClinicaService.updateInformacionClinica(informacionClinicaId, actualizarInformacionClinicaDTO);
    }

    @GetMapping("/GetInformacionClinica/{informacionClinicaId}")
    public InformacionClinicaDTO getById(@PathVariable UUID informacionClinicaId){
        return informacionClinicaService.getInformacionClinicaById(informacionClinicaId);
    }

}

 */