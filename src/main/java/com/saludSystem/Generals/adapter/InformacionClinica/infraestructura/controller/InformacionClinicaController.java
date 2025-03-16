package com.saludSystem.Generals.adapter.InformacionClinica.infraestructura.controller;

import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.dtos.ActualizarInformacionClinicaDTO;
import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.dtos.CrearInformacionClinicaDTO;
import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.dtos.InformacionClinicaDTO;
import com.saludSystem.Generals.adapter.InformacionClinica.aplicacion.services.InformacionClinicaService;
import com.saludSystem.Generals.response.ApiResponse;
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