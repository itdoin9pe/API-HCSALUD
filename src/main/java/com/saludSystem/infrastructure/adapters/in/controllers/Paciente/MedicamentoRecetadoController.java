package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.MedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearMedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarMedicamentoRecetadoDTO;
import com.saludSystem.application.services.Paciente.MedicamentoRecetadoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.MedicamentoRecetadoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Tag(name = "PacientesMedicamentosRecetados")
@RestController
@RequestMapping("/api/PacientesMedicamentosRecetados")
public class MedicamentoRecetadoController {

    private final MedicamentoRecetadoService medicamentoRecetadoService;

    public MedicamentoRecetadoController(MedicamentoRecetadoService medicamentoRecetadoService) {
        this.medicamentoRecetadoService = medicamentoRecetadoService;
    }

    @PostMapping("/SaveMedicamentoRecetado")
    public ApiResponse stored(@Valid @RequestBody CrearMedicamentoRecetadoDTO crearMedicamentoRecetadoDTO) {
        return medicamentoRecetadoService.saveMedicamentoRecetado(crearMedicamentoRecetadoDTO);
    }

    @GetMapping("/GetAllMedicamentoRecetado")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedicamentoRecetadoResponse.class)))
    })
    public ListResponse<MedicamentoRecetadoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return medicamentoRecetadoService.getAllMedicamentoRecetado(hospitalId, page, rows);
    }

    @GetMapping("/GetMedicametoRecetado/{pacienteMedicamentoRecetadoId}")
    public MedicamentoRecetadoDTO getById(@PathVariable UUID medicamentoRecetadoId) {
        return medicamentoRecetadoService.getMedicamentoRecetadoById(medicamentoRecetadoId);
    }

    @PutMapping("/UpdatePacienteReceta/{pacienteMedicamentoRecetadoId}")
    public ApiResponse update(@PathVariable UUID medicamentoRecetadoId, @RequestBody ActualizarMedicamentoRecetadoDTO actualizarMedicamentoRecetadoDTO) {
        return medicamentoRecetadoService.updateMedicamentoRecetado(medicamentoRecetadoId, actualizarMedicamentoRecetadoDTO);
    }

    @DeleteMapping("/DeletePacienteMedicamentoRecetado/{pacienteMedicamentoRecetadoId}")
    public ApiResponse destroy(@PathVariable UUID medicamentoRecetadoId) {
        return medicamentoRecetadoService.deleteMedicamentoRecetado(medicamentoRecetadoId);
    }

}