package com.saludsystem.submodules.core.paciente.rest.controller.query.historialclinico;

import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.submodules.paciente.query.getAll.historialclinico.PacienteAlergiaAllHandler;
import com.saludsystem.submodules.paciente.query.getById.historialclinico.PacienteAlergiaByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.historialclinico.PacienteAlergiaListHandler;
import com.saludsystem.submodules.paciente.response.historialclinico.PacienteAlergiaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesAlergias")
@RestController
@RequestMapping("/api/Pacientes/Alergias")
public class PacienteAlergiaQueryController {

    private final PacienteAlergiaListHandler listHandler;
    private final PacienteAlergiaByIdHandler byIdHandler;
    private final PacienteAlergiaAllHandler allHandler;

    public PacienteAlergiaQueryController(PacienteAlergiaListHandler listHandler, PacienteAlergiaByIdHandler byIdHandler, PacienteAlergiaAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<PacienteAlergiaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public PacienteAlergiaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PacienteAlergiaListResponse.class)))
    })
    public ListResponse<PacienteAlergiaDTO> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}