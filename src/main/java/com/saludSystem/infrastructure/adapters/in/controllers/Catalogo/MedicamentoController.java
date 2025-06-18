package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.GET.MedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedicamentoDTO;
import com.saludSystem.application.services.Catalogo.MedicamentoService;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
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
public class MedicamentoController extends GenericController<
        MedicamentoDTO,
        UUID,
        CrearMedicamentoDTO,
        ActualizarMedicamentoDTO> {

    private final MedicamentoService medicamentoService;

    protected MedicamentoController(GenericService<MedicamentoDTO, UUID, CrearMedicamentoDTO, ActualizarMedicamentoDTO> genericService, MedicamentoService medicamentoService) {
        super(genericService);
        this.medicamentoService = medicamentoService;
    }

    @Override
    @PostMapping("/SaveMedicamento")
    public ApiResponse create(@Valid @RequestBody CrearMedicamentoDTO crearMedicamentoDTO) {
        return super.create(crearMedicamentoDTO);
    }

    @Override
    @GetMapping("/GetAllMedicamento")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedicamentoResponse.class)))
    })
    public ListResponse<MedicamentoDTO> getAllPaginated(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "1") int page,
            @RequestParam(name = "Rows", defaultValue = "10") int rows) {
        return medicamentoService.getAllPaginated(hospitalId, page, rows);
    }

    @Override
    @GetMapping("/GetMedicamento/{medicamentoId}")
    public MedicamentoDTO getById(@PathVariable UUID medicamentoId) {
        return medicamentoService.getById(medicamentoId);
    }

    @Override
    @GetMapping("/GetMedicamentoList")
    public ResponseEntity<List<MedicamentoDTO>> getList() {
        return super.getList();
    }

    @Override
    @PutMapping("/UpdateMedicamento/{medicamentoId}")
    public ApiResponse update(@PathVariable UUID medicamentoId, @RequestBody ActualizarMedicamentoDTO actualizarMedicamentoDTO) {
        return medicamentoService.update(medicamentoId, actualizarMedicamentoDTO);
    }

    @Override
    @DeleteMapping("/DeleteMedicamento/{medicamentoId}")
    public ApiResponse delete(@PathVariable UUID medicamentoId) {
        return super.delete(medicamentoId);
    }
}