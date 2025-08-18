package com.saludsystem.submodules.core.paciente.rest.controller.query.interconsulta;

import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InformeInterconsultaDTO;
import com.saludsystem.submodules.paciente.query.getAll.interconsulta.InformeInterconsultaAllHandler;
import com.saludsystem.submodules.paciente.query.getById.interconsulta.InformeInterconsultaByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.interconsulta.InformeInterconsultaListHandler;
import com.saludsystem.submodules.paciente.response.interconsulta.InformeInterconsultaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesInformesInterconsultas")
@RestController
@RequestMapping("/api/PacientesInformesInterconsultas")
public class InformeInterconsultaQueryController {

    private final InformeInterconsultaListHandler listHandler;
    private final InformeInterconsultaByIdHandler byIdHandler;
    private final InformeInterconsultaAllHandler allHandler;

    public InformeInterconsultaQueryController(InformeInterconsultaListHandler listHandler, InformeInterconsultaByIdHandler byIdHandler, InformeInterconsultaAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<InformeInterconsultaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public InformeInterconsultaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = InformeInterconsultaListResponse.class)))
    })
    public ListResponse<InformeInterconsultaDTO> getAll(@RequestParam UUID hospitalId,
                                           @RequestParam(name = "Page") int page,
                                           @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}
