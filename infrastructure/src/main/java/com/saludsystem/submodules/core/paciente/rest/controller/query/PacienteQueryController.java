package com.saludsystem.submodules.core.paciente.rest.controller.query;

import com.saludsystem.submodules.paciente.model.dtos.get.PacienteDTO;
import com.saludsystem.submodules.paciente.query.getAll.PacienteAllHandler;
import com.saludsystem.submodules.paciente.query.getById.PacienteByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.PacienteListHandler;
import com.saludsystem.submodules.paciente.response.PacienteListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Pacientes")
@RestController
@RequestMapping("/api/Pacientes")
public class PacienteQueryController {

    private final PacienteListHandler listHandler;
    private final PacienteByIdHandler byIdHandler;
    private final PacienteAllHandler allHandler;

    public PacienteQueryController(PacienteListHandler listHandler, PacienteByIdHandler byIdHandler, PacienteAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<PacienteDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetDoctor/{doctorId}")
    public PacienteDTO getById(@PathVariable UUID doctorId) {
        return byIdHandler.execute(doctorId);
    }

    @GetMapping("/GetAllPaciente")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PacienteListResponse.class)))
    })
    public ListResponse<PacienteDTO> getAll(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page,rows));
    }

}