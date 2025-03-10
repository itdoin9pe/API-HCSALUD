package com.saludSystem.Catalogo.Medida.infraestructura.controller;

import com.saludSystem.Catalogo.Medida.aplicacion.dtos.ActualizarMedidaDTO;
import com.saludSystem.Catalogo.Medida.aplicacion.dtos.CrearMedidaDTO;
import com.saludSystem.Catalogo.Medida.aplicacion.dtos.MedidaDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Catalogo.Medida.dominio.MedidaResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Catalogo.Medida.aplicacion.services.MedidaService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Medidas")
@RestController
@RequestMapping("/api/Medidas")
public class MedidaController {

    private final MedidaService medidaService;

    public MedidaController(MedidaService medidaService) {
        this.medidaService = medidaService;
    }

    @PostMapping("/SaveMedida")
    public ApiResponse store(@Valid @RequestBody CrearMedidaDTO crearMedidaDTO) {
        return medidaService.saveMedida(crearMedidaDTO);
    }

    @GetMapping("/GetAllMedida")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedidaResponse.class)))
    })
    public ListResponse<MedidaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return medidaService.getAllMedida(hospitalId, page, rows);
    }

    @GetMapping("/GetMedidaList")
    public ResponseEntity<List<MedidaDTO>> getAllList() {
        return ResponseEntity.ok(medidaService.getMedidaList());
    }

    @GetMapping("/GetMedida/{medidaId}")
    public MedidaDTO getById(@PathVariable UUID medidaId) {
        return medidaService.getMedidaById(medidaId);
    }

    @PutMapping("/UpdateMedida/{medidaId}")
    public ApiResponse update(@PathVariable UUID medidaId, @RequestBody ActualizarMedidaDTO actualizarMedidaDTO) {
        return medidaService.updateMedida(medidaId, actualizarMedidaDTO);
    }

    @DeleteMapping("/DeleteMedida/{medidaId}")
    public ApiResponse destroy(@PathVariable UUID medidaId) {
        return medidaService.deleteMedida(medidaId);
    }

}