package com.saludsystem.submodules.core.paciente.rest.controller.query.historialclinico;

import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.submodules.paciente.query.getAll.historialclinico.ExploracionFisicaAllHandler;
import com.saludsystem.submodules.paciente.query.getById.historialclinico.ExploracionFisicaByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.historialclinico.ExploracionFisicaListHandler;
import com.saludsystem.submodules.paciente.response.historialclinico.ExploracionFisicaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesExploraciones")
@RestController
@RequestMapping("/api/Pacientes/Exploraciones")
public class ExploracionFisicaQueryController {

    private final ExploracionFisicaListHandler listHandler;
    private final ExploracionFisicaByIdHandler byIdHandler;
    private final ExploracionFisicaAllHandler allHandler;

    public ExploracionFisicaQueryController(ExploracionFisicaListHandler listHandler, ExploracionFisicaByIdHandler byIdHandler, ExploracionFisicaAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<ExploracionFisicaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public ExploracionFisicaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExploracionFisicaListResponse.class)))
    })
    public ListResponse<ExploracionFisicaDTO> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}