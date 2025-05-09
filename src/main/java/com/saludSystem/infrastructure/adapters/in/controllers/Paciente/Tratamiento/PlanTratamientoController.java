package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.PlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPlanTratamientoDTO;
import com.saludSystem.application.services.Paciente.PlanTratamientoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.Tratamiento.PlanTratamientoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Tag(name = "PacientesPlanesTratamientos")
@RestController
@RequestMapping("/api/PacientesPlanesTratamientos")
public class PlanTratamientoController {

    private final PlanTratamientoService planTratamientoService;

    public PlanTratamientoController(PlanTratamientoService planTratamientoService) {
        this.planTratamientoService = planTratamientoService;
    }

    @PostMapping("/SavePacientePlanTratamiento")
    public ApiResponse stored(@Valid @RequestBody CrearPlanTratamientoDTO crearPlanTratamientoDTO) {
        return planTratamientoService.savePlanTratamiento(crearPlanTratamientoDTO);
    }

    @GetMapping("/GetAllPacientePlanTratamiento")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlanTratamientoResponse.class)))
    })
    public ListResponse<PlanTratamientoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return planTratamientoService.getAllPlanTratamiento(hospitalId, page, rows);
    }

    @GetMapping("/GetPacientePlanTratamiento/{pacientePlanTratamientoId}")
    public PlanTratamientoDTO getById(@PathVariable UUID pacientePlanTratamientoId) {
        return planTratamientoService.getPlanTratamientoById(pacientePlanTratamientoId);
    }

    @PutMapping("/UpdatePacientePlanTratamiento/{pacientePlanTratamientoId}")
    public ApiResponse update(@PathVariable UUID pacientePlanTratamientoId, @RequestBody ActualizarPlanTratamientoDTO actualizarPlanTratamientoDTO) {
        return planTratamientoService.updatePlanTratamiento(pacientePlanTratamientoId, actualizarPlanTratamientoDTO);
    }

    @DeleteMapping("/DeletePacientePlanTratamiento/{pacientePlanTratamientoId}")
    public ApiResponse destroy(@PathVariable UUID pacientePlanTratamientoId) {
        return planTratamientoService.deletePlanTratamiento(pacientePlanTratamientoId);
    }

}