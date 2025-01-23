package com.saludSystem.controllers.Generals;

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
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InformacionClinicaResponse.class)))
    })
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearInformacionClinicaDTO crearInformacionClinicaDTO){
        informacionClinicaService.saveInformacionClinica(crearInformacionClinicaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Informacion Clinica creada con exito"));
    }

    @DeleteMapping("/DeleteInformacionClinica/{id}")
    public ResponseEntity<ApiResponse> destroy(@PathVariable UUID id){
        informacionClinicaService.deleteInformacionClinica(id);
        return ResponseEntity.ok().body(new ApiResponse(true, "Informacion Clinica eliminado con exito"));
    }

    @PutMapping("/UpdateInformacionClinica/{id}")
    public ResponseEntity<InformacionClinicaDTO> update(
            @PathVariable UUID id,
            @RequestBody InformacionClinicaDTO informacionClinicaDTO
    ){
        InformacionClinicaDTO updatedInformacionClinica = informacionClinicaService.updateInformacionClinica(id, informacionClinicaDTO);
        return ResponseEntity.ok(updatedInformacionClinica);
    }

    @GetMapping("/GetInformacionClinica/{id}")
    public ResponseEntity<InformacionClinicaDTO> getById(@PathVariable UUID id){
        return informacionClinicaService.getInformacionClinicaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
