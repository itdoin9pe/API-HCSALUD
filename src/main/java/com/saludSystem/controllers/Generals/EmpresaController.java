package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.EmpresaDTO;
import com.saludSystem.services.modules.Generals.Empresas.EmpresaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Empresas")
@RestController
@RequestMapping("/api/Empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @GetMapping("/GetAllEmpresa")
    public ResponseEntity<List<EmpresaDTO>> getAllEmpresa(){
        List<EmpresaDTO> empresas = empresaService.getAllEmpresa();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @GetMapping("/GetEmpresa/{id}")
    public ResponseEntity<EmpresaDTO> getEmpresaById(@PathVariable Integer id){
        return empresaService.getEmpresaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/SaveEmpresa")
    public ResponseEntity<EmpresaDTO> createEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO){
        return ResponseEntity.ok(empresaService.saveEmpresa(empresaDTO));
    }

    @PutMapping("/UpdateEmpresa")
    public ResponseEntity<EmpresaDTO> updateEmpresa(
            @PathVariable Integer id,
            @RequestBody EmpresaDTO empresaDTO
    ){
        EmpresaDTO updatedEmpresa = empresaService.updateEmpresa(id, empresaDTO);
        return ResponseEntity.ok(updatedEmpresa);
    }

    @DeleteMapping("/DeleteEmpresa/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Integer id){
        empresaService.deleteEmpresa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
