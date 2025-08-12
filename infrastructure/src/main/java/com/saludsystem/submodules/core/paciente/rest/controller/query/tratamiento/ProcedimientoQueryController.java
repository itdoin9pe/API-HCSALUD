package com.saludsystem.submodules.core.paciente.rest.controller.query.tratamiento;

import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.ProcedimientoDTO;
import com.saludsystem.submodules.paciente.query.getAll.tratamiento.ProcedimientoAllHandler;
import com.saludsystem.submodules.paciente.query.getById.tratamiento.ProcedimientoByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.tratamiento.ProcedimientoListHandler;
import com.saludsystem.submodules.paciente.response.tratamiento.ProcedimientoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesProcedimientos")
@RestController
@RequestMapping("/api/Pacientes/Procedimientos")
public class ProcedimientoQueryController {

    private final ProcedimientoListHandler listHandler;
    private final ProcedimientoByIdHandler byIdHandler;
    private final ProcedimientoAllHandler allHandler;

    public ProcedimientoQueryController(ProcedimientoListHandler listHandler, ProcedimientoByIdHandler byIdHandler, ProcedimientoAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<ProcedimientoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public ProcedimientoDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProcedimientoListResponse.class)))
    })
    public ListResponse<ProcedimientoDTO> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}