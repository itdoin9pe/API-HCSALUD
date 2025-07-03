package com.saludsystem.infrastructure.adapters.in.controllers.paciente.Tratamiento;

import com.saludsystem.application.dtos.paciente.get.tratamiento.PlanTratamientoDTO;
import com.saludsystem.application.dtos.paciente.post.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.application.dtos.paciente.put.tratamiento.ActualizarPlanTratamientoDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.paciente.Tratamiento.PlanTratamientoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesPlanesTratamientos")
@RestController
@RequestMapping("/api/Pacientes/PlanesTratamientos")
public class PlanTratamientoController extends GenericController<PlanTratamientoDTO, UUID,
        CrearPlanTratamientoDTO, ActualizarPlanTratamientoDTO> {

    protected PlanTratamientoController(GenericService<PlanTratamientoDTO, UUID,
            CrearPlanTratamientoDTO, ActualizarPlanTratamientoDTO> genericService) {
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