package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.Empresa.ActualizarEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.CrearEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.EmpresaDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.services.modules.Generals.Empresas.EmpresaService;
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
    public ResponseEntity<EmpresaDTO> getById(@PathVariable UUID empresaId){
        return empresaService.getEmpresaById(empresaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/UpdateEmpresa/{empresaId}")
    public ResponseEntity<ApiResponse> updateEmpresa(
            @PathVariable UUID empresaId,
            @RequestBody ActualizarEmpresaDTO actualizarEmpresaDTO
            ){
        empresaService.updateEmpresa(empresaId, actualizarEmpresaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Empresa actualizado correctamente"));
    }

    @PostMapping("/SaveEmpresa")
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearEmpresaDTO crearEmpresaDTO){
        empresaService.saveEmpresa(crearEmpresaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Empresa creada correctamente"));
    }

    @DeleteMapping("/DeleteEmpresa/{empresaId}")
    public ResponseEntity<ApiResponse> deleteEmpresa(@PathVariable UUID empresaId){
        empresaService.deleteEmpresa(empresaId);
        return ResponseEntity.ok(new ApiResponse(true, "Empresa eliminada correctamente."));

    }

}