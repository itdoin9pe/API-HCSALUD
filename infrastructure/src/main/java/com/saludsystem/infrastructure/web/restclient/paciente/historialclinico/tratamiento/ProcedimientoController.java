package com.saludsystem.infrastructure.web.restclient.paciente.historialclinico.tratamiento;

import com.saludsystem.application.dto.get.historialclinico.tratamiento.ProcedimientoDTO;
import com.saludsystem.application.dto.post.historialclinico.tratamiento.CrearProcedimientoDTO;
import com.saludsystem.application.dto.put.historialclinico.tratamiento.ActualizarProcedimientoDTO;
import com.saludsystem.infrastructure.adapters.in.response.tratamiento.ProcedimientoListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesProcedimientos")
@RestController
@RequestMapping("/api/Pacientes/Procedimientos")
public class ProcedimientoController extends GenericController<ProcedimientoDTO, CrearProcedimientoDTO,
        ActualizarProcedimientoDTO, UUID> {

    protected ProcedimientoController(GenericService<
                ProcedimientoDTO, CrearProcedimientoDTO, ActualizarProcedimientoDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProcedimientoListResponse.class)))
    })
    public ListResponse<ProcedimientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}