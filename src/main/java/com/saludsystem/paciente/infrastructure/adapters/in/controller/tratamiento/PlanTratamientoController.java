package com.saludsystem.paciente.infrastructure.adapters.in.controller.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.PlanTratamientoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.PlanTratamientoRequest;
import com.saludsystem.paciente.infrastructure.adapters.in.response.Tratamiento.PlanTratamientoListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesPlanesTratamientos")
@RestController
@RequestMapping("/api/Pacientes/PlanesTratamientos")
public class PlanTratamientoController extends GenericController<PlanTratamientoRequest, PlanTratamientoResponse, UUID> {

    protected PlanTratamientoController(
            GenericService<PlanTratamientoRequest, PlanTratamientoResponse, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlanTratamientoListResponse.class)))
    })
    public ListResponse<PlanTratamientoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}