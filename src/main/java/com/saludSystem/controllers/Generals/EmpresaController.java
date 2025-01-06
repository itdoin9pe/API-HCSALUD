package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.EmpresaDTO;
import com.saludSystem.services.modules.Generals.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Empresas")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/GetAllEmpresa")
    public ResponseEntity<List<EmpresaDTO>> getAllEmpresa(){
        List<EmpresaDTO> empresas = empresaService.getAllEmpresa();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @GetMapping("/GetEmpresa/{id}")
    public ResponseEntity<EmpresaDTO> getEmpresaById(@PathVariable int id){
        return empresaService.getEmpresaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/SaveEmpresa")
    public ResponseEntity<EmpresaDTO> createEmpresa(@RequestBody EmpresaDTO empresaDTO){
        EmpresaDTO savedEmpresa = empresaService.saveEmpresa(empresaDTO);
        return ResponseEntity.ok(savedEmpresa);
    }

    @PutMapping("/UpdateEmpresa")
    public ResponseEntity<EmpresaDTO> updateEmpresa(
            @PathVariable int id,
            @RequestBody EmpresaDTO empresaDTO
    ){
        EmpresaDTO updatedEmpresa = empresaService.updateEmpresa(id, empresaDTO);
        return new ResponseEntity<>(updatedEmpresa, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteEmpresa/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable int id){
        empresaService.deleteEmpresa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
