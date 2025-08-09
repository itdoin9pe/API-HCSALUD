package com.saludsystem.submodules.core.paciente.rest.controller.query.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.EvolucionDTO;
import com.saludsystem.submodules.paciente.query.getAll.evolucion.EvolucionAllHandler;
import com.saludsystem.submodules.paciente.query.getById.evolucion.EvolucionByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.evolucion.EvolucionListHandler;
import com.saludsystem.submodules.paciente.response.evolucion.EvolucionListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesEvoluciones")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones")
public class EvolucionQueryController {

    private final EvolucionListHandler listHandler;
    private final EvolucionByIdHandler byIdHandler;
    private final EvolucionAllHandler allHandler;

    public EvolucionQueryController(EvolucionListHandler listHandler, EvolucionByIdHandler byIdHandler, EvolucionAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<EvolucionDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public EvolucionDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EvolucionListResponse.class)))
    })
    public ListResponse<EvolucionDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}