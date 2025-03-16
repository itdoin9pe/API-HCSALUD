package com.saludSystem.Generals.adapter.Empresa.infraestructura.controller;

import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.ActualizarEmpresaDTO;
import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.CrearEmpresaDTO;
import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.EmpresaDTO;
import com.saludSystem.Generals.adapter.Empresa.aplicacion.services.EmpresaService;
import com.saludSystem.Generals.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Empresas")
@RestController
@RequestMapping("/api/Empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping("GetEmpresaList")
    public ResponseEntity<List<EmpresaDTO>> getAllList(){
        return ResponseEntity.ok(empresaService.getEmpresaList());
    }

    @GetMapping("/GetEmpresa/{empresaId}")
    public EmpresaDTO getById(@PathVariable UUID empresaId) {
        return empresaService.getEmpresaById(empresaId);
    }

    @PutMapping("/UpdateEmpresa/{empresaId}")
    public ApiResponse updateEmpresa(@PathVariable UUID empresaId, @RequestBody ActualizarEmpresaDTO actualizarEmpresaDTO) {
        return empresaService.updateEmpresa(empresaId, actualizarEmpresaDTO);
    }

    @PostMapping("/SaveEmpresa")
    public ApiResponse store(@Valid @RequestBody CrearEmpresaDTO crearEmpresaDTO){
        return empresaService.saveEmpresa(crearEmpresaDTO);
    }

    @DeleteMapping("/DeleteEmpresa/{empresaId}")
    public ApiResponse deleteEmpresa(@PathVariable UUID empresaId){
        return empresaService.deleteEmpresa(empresaId);
    }

}