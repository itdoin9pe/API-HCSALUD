package com.saludSystem.infrastructure.controllers.ModuleCatalogo;
/*
import com.saludSystem.dtos.catalago.Medida.ActualizarMedidaDTO;
import com.saludSystem.dtos.catalago.Medida.CrearMedidaDTO;
import com.saludSystem.dtos.catalago.Medida.MedidaDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.services.modules.Catalogo.Medida.MedidaService;
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
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearMedidaDTO crearMedidaDTO) {
        medidaService.saveMedida(crearMedidaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Medida creada correctamente"));
    }

    @GetMapping("/GetAllMedida")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedidaDTO.class)))
    })
    public ResponseEntity<ListResponse<MedidaDTO>> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        List<MedidaDTO> medidas = medidaService.getPagedResults(hospitalId, page, rows);
        long totalData = medidaService.getTotalCount();
        ListResponse<MedidaDTO> response = new ListResponse<>();
        response.setData(medidas);
        response.setTotalData(totalData);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/GetMedidaList")
    public ResponseEntity<List<MedidaDTO>> getAllList() {
        return ResponseEntity.ok(medidaService.getMedidaList());
    }

    @GetMapping("/GetMedida/{medidaId}")
    public ResponseEntity<MedidaDTO> getById(@PathVariable UUID medidaId) {
        return medidaService.getMedidaById(medidaId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/UpdateMedida/{medidaId}")
    public ResponseEntity<ApiResponse> update(@PathVariable UUID medidaId, @RequestBody ActualizarMedidaDTO actualizarMedidaDTO) {
        medidaService.updateMedida(medidaId, actualizarMedidaDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Medida actualizada correctamente"));
    }

    @DeleteMapping("/DeleteMedida/{medidaId}")
    public ResponseEntity<ApiResponse> destroy(@PathVariable UUID medidaId) {
        medidaService.deleteMedida(medidaId);
        return ResponseEntity.ok(new ApiResponse(true, "Medida eliminada con éxito"));
    }

}


 */