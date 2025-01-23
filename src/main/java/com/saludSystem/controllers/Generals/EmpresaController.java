package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.Empresa.CrearEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.EmpresaDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Generals.EmpresaResponse;
import com.saludSystem.services.modules.Generals.Empresas.EmpresaService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaResponse.class)))
    })
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearEmpresaDTO crearEmpresaDTO){
        empresaService.saveEmpresa(crearEmpresaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Empresa creada correctamente"));
    }

    @DeleteMapping("/DeleteEmpresa/{id}")
    public ResponseEntity<ApiResponse> deleteEmpresa(@PathVariable UUID id){
        empresaService.deleteEmpresa(id);
        return ResponseEntity.ok(new ApiResponse(true, "Empresa eliminado correctamente."));
    }

}
