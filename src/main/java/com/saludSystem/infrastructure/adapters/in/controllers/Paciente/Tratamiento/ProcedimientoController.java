package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.ProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearProcedimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarProcedimientoDTO;
import com.saludSystem.application.services.Paciente.Tratamiento.ProcedimientoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.Tratamiento.ProcedimientoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesProcedimientos")
@RestController
@RequestMapping("/api/PacientesProcedimientos")
public class ProcedimientoController {

    private final ProcedimientoService procedimientoService;

    public ProcedimientoController(ProcedimientoService procedimientoService) {
        this.procedimientoService = procedimientoService;
    }

    @PostMapping("/SavePacienteProcedimiento")
    public ApiResponse stored(@Valid @RequestBody CrearProcedimientoDTO crearProcedimientoDTO) {
        return procedimientoService.saveProcedimiento(crearProcedimientoDTO);
    }

    @GetMapping("/GetAllPacienteProcedimiento")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProcedimientoResponse.class)))
    })
    public ListResponse<ProcedimientoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return procedimientoService.getAllProcedimiento(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteProcedimiento/{pacienteProcedimientoId}")
    public ProcedimientoDTO getById(@PathVariable UUID pacienteProcedimientoId) {
        return procedimientoService.getProcedimientoById(pacienteProcedimientoId);
    }

    @PutMapping("/UpdatePacienteProcedimiento/{pacienteProcedimientoId}")
    public ApiResponse update(@PathVariable UUID pacienteProcedimientoId, @RequestBody ActualizarProcedimientoDTO actualizarProcedimientoDTO) {
        return procedimientoService.updateProcedimiento(pacienteProcedimientoId, actualizarProcedimientoDTO);
    }

    @DeleteMapping("/DeletePacienteProcedimiento/{pacienteProcedimientoId}")
    public ApiResponse destroy(@PathVariable UUID pacienteProcedimientoId) {
        return procedimientoService.deleteProcedimiento(pacienteProcedimientoId);
    }

}