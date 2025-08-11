package com.saludsystem.submodules.core.paciente.rest.controller.query.historialclinico;

import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.AntecedenteDTO;
import com.saludsystem.submodules.paciente.query.getAll.historialclinico.AntecedenteAllHandler;
import com.saludsystem.submodules.paciente.query.getById.historialclinico.AntecedenteByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.historialclinico.AntecedenteListHandler;
import com.saludsystem.submodules.paciente.response.historialclinico.AntecedenteListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesEnfermedadesActuales")
@RestController
@RequestMapping("/api/Pacientes/EnfermedadesActuales")
public class AntecedentesQueryController {

    private final AntecedenteListHandler listHandler;
    private final AntecedenteByIdHandler byIdHandler;
    private final AntecedenteAllHandler allHandler;

    public AntecedentesQueryController(AntecedenteListHandler listHandler, AntecedenteByIdHandler byIdHandler, AntecedenteAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<AntecedenteDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public AntecedenteDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AntecedenteListResponse.class)))
    })
    public ListResponse<AntecedenteDTO> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}