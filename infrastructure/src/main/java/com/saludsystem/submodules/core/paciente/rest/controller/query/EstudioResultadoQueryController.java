package com.saludsystem.submodules.core.paciente.rest.controller.query;

import com.saludsystem.submodules.paciente.model.dtos.get.EstudioResultadoDTO;
import com.saludsystem.submodules.paciente.query.getAll.EstudioResultadoAllHandler;
import com.saludsystem.submodules.paciente.query.getById.EstudioResultadoByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.EstudioResultadoListHandler;
import com.saludsystem.submodules.paciente.response.EstudioResultadoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesEstudiosResultados")
@RestController
@RequestMapping("/api/PacientesEstudiosResultados")
public class EstudioResultadoQueryController {

    private final EstudioResultadoListHandler listHandler;
    private final EstudioResultadoByIdHandler byIdHandler;
    private final EstudioResultadoAllHandler allHandler;

    public EstudioResultadoQueryController(EstudioResultadoListHandler listHandler, EstudioResultadoByIdHandler byIdHandler, EstudioResultadoAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<EstudioResultadoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public EstudioResultadoDTO getById(@PathVariable Long id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAllPacienteEstudioResultado")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstudioResultadoListResponse.class)))
    })
    public ListResponse<EstudioResultadoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}