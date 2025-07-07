package com.saludsystem.infrastructure.adapters.in.controllers.paciente.tratamiento;

import com.saludsystem.application.dtos.paciente.get.historialclinico.tratamiento.ProcedimientoDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.tratamiento.CrearProcedimientoDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.paciente.Tratamiento.ProcedimientoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesProcedimientos")
@RestController
@RequestMapping("/api/Pacientes/Procedimientos")
public class ProcedimientoController extends GenericController<CrearProcedimientoDTO, ProcedimientoDTO, UUID> {

    protected ProcedimientoController(GenericService<CrearProcedimientoDTO, ProcedimientoDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProcedimientoResponse.class)))
    })
    public ListResponse<ProcedimientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}