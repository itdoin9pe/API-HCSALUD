package com.saludsystem.paciente.infrastructure.adapters.in.controller.tratamiento;

import com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.ProcedimientoResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.tratamiento.ProcedimientoRequest;
import com.saludsystem.paciente.infrastructure.adapters.in.response.Tratamiento.ProcedimientoListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesProcedimientos")
@RestController
@RequestMapping("/api/Pacientes/Procedimientos")
public class ProcedimientoController extends GenericController<ProcedimientoRequest, ProcedimientoResponse, UUID> {

    protected ProcedimientoController(GenericService<ProcedimientoRequest, ProcedimientoResponse, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProcedimientoListResponse.class)))
    })
    public ListResponse<ProcedimientoResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}