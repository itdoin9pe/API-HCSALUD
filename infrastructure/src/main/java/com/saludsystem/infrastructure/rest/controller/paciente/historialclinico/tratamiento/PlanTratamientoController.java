package com.saludsystem.infrastructure.rest.controller.paciente.historialclinico.tratamiento;

import com.saludsystem.application.dto.get.historialclinico.tratamiento.PlanTratamientoDTO;
import com.saludsystem.application.dto.post.historialclinico.tratamiento.CrearPlanTratamientoDTO;
import com.saludsystem.application.dto.put.historialclinico.tratamiento.ActualizarPlanTratamientoDTO;
import com.saludsystem.infrastructure.adapters.in.response.tratamiento.PlanTratamientoListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesPlanesTratamientos")
@RestController
@RequestMapping("/api/Pacientes/PlanesTratamientos")
public class PlanTratamientoController extends GenericController<PlanTratamientoDTO, CrearPlanTratamientoDTO,
        ActualizarPlanTratamientoDTO, UUID> {

    protected PlanTratamientoController(GenericService<
                PlanTratamientoDTO, CrearPlanTratamientoDTO, ActualizarPlanTratamientoDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlanTratamientoListResponse.class)))
    })
    public ListResponse<PlanTratamientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}