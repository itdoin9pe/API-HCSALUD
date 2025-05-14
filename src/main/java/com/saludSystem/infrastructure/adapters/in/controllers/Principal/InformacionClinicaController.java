package com.saludSystem.infrastructure.adapters.in.controllers.Principal;

import com.saludSystem.application.dtos.Principal.PUT.ActualizarInformacionClinicaDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearInformacionClinicaDTO;
import com.saludSystem.application.dtos.Principal.GET.InformacionClinicaDTO;
import com.saludSystem.application.services.Principal.InformacionClinicaService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
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