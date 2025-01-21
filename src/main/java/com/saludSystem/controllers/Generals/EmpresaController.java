package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.EmpresaDTO;
import com.saludSystem.services.modules.Generals.Empresas.EmpresaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    @GetMapping("/GetEmpresa/{id}")
    public ResponseEntity<EmpresaDTO> getEmpresaById(@PathVariable UUID id){
        return empresaService.getEmpresaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/UpdateEmpresa")
    public ResponseEntity<EmpresaDTO> updateEmpresa(
            @PathVariable UUID id,
            @RequestBody EmpresaDTO empresaDTO
    ){
        EmpresaDTO updatedEmpresa = empresaService.updateEmpresa(id, empresaDTO);
        return ResponseEntity.ok(updatedEmpresa);
    }

    @PostMapping("/SaveEmpresa")
    public ResponseEntity<EmpresaDTO> createEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.ok(empresaService.saveEmpresa(empresaDTO));
    }

    @DeleteMapping("/DeleteEmpresa/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable UUID id){
        empresaService.deleteEmpresa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
