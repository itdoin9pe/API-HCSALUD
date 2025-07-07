package com.saludsystem.paciente.infrastructure.adapters.in.controller.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.PlanTratamientoDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.in.response.Tratamiento.PlanTratamientoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesPlanesTratamientos")
@RestController
@RequestMapping("/api/Pacientes/PlanesTratamientos")
public class PlanTratamientoController extends GenericController<CrearPlanTratamientoDTO, PlanTratamientoDTO, UUID> {

    protected PlanTratamientoController(
            GenericService<CrearPlanTratamientoDTO, PlanTratamientoDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlanTratamientoResponse.class)))
    })
    public ListResponse<PlanTratamientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}