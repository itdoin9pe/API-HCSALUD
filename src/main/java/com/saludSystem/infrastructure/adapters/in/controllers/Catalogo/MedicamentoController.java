package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.MedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedicamentoDTO;
import com.saludSystem.application.services.Catalogo.MedicamentoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.Catalogo.MedicamentoResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Medicamentos")
@RestController
@RequestMapping("/api/Medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping("/SaveMedicamento")
    public ApiResponse stored(@Valid @RequestBody CrearMedicamentoDTO crearMedicamentoDTO) {
        return medicamentoService.saveMedicamento(crearMedicamentoDTO);
    }

    @GetMapping("/GetAllMedicamento")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedicamentoResponse.class)))
    })
    public ListResponse<MedicamentoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return medicamentoService.getAllMedicamento(hospitalId, page, rows);
    }

    @GetMapping("/GetMedicamento/{medicamentoId}")
    public MedicamentoDTO getById(@PathVariable UUID medicamentoId) {
        return medicamentoService.getMedicamentoById(medicamentoId);
    }

    @GetMapping("/GetMedicamentoList")
    public ResponseEntity<List<MedicamentoDTO>> getMedicamentoList() {
        return ResponseEntity.ok(medicamentoService.getMedicamentoList());
    }

    @PutMapping("/UpdateMedicamento/{medicamentoId}")
    public ApiResponse update(@PathVariable UUID medicamentoId, @RequestBody ActualizarMedicamentoDTO actualizarMedicamentoDTO) {
        return medicamentoService.updateMedicamento(medicamentoId, actualizarMedicamentoDTO);
    }

    @DeleteMapping("/DeleteMedicamento/{medicamentoId}")
    public ApiResponse destroy(@PathVariable UUID medicamentoId) {
        return medicamentoService.deleteMedicamento(medicamentoId);
    }

}