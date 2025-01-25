package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.InformacionClinica.ActualizarInformacionClinicaDTO;
import com.saludSystem.dtos.Generals.InformacionClinica.CrearInformacionClinicaDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.Generals.InformacionClinica.InformacionClinicaDTO;
import com.saludSystem.dtos.responses.Generals.AseguradoraResponse;
import com.saludSystem.dtos.responses.Generals.InformacionClinicaResponse;
import com.saludSystem.services.modules.Generals.InformacionClinica.InformacionClinicaService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearInformacionClinicaDTO crearInformacionClinicaDTO){
        informacionClinicaService.saveInformacionClinica(crearInformacionClinicaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Informacion Clinica creada con exito"));
    }

    @DeleteMapping("/DeleteInformacionClinica/{informacionClinicaId}")
    public ResponseEntity<ApiResponse> destroy(@PathVariable UUID informacionClinicaId){
        informacionClinicaService.deleteInformacionClinica(informacionClinicaId);
        return ResponseEntity.ok().body(new ApiResponse(true, "Informacion Clinica eliminado con exito"));
    }

    @PutMapping("/UpdateInformacionClinica/{informacionClinicaId}")
    public ResponseEntity<ApiResponse> update(
            @PathVariable UUID informacionClinicaId,
            @RequestBody ActualizarInformacionClinicaDTO actualizarInformacionClinicaDTO
    ){
        informacionClinicaService.updateInformacionClinica(informacionClinicaId, actualizarInformacionClinicaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Informacion Clinica actualizado correctamente"));
    }

    @GetMapping("/GetInformacionClinica/{informacionClinicaId}")
    public ResponseEntity<InformacionClinicaDTO> getById(@PathVariable UUID informacionClinicaId){
        return informacionClinicaService.getInformacionClinicaById(informacionClinicaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
