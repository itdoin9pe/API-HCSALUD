package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.Tratamiento.PlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.Tratamiento.CrearPlanTratamientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Tratamiento.ActualizarPlanTratamientoDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.Tratamiento.PlanTratamientoResponse;
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

    protected PlanTratamientoController(GenericService<PlanTratamientoDTO, UUID, CrearPlanTratamientoDTO, ActualizarPlanTratamientoDTO> genericService) {
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