package com.saludsystem.submodules.core.paciente.rest.controller.query.evolucion;

import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.CambioCondicionDTO;
import com.saludsystem.submodules.paciente.query.getAll.evolucion.CambioCondicionAllHandler;
import com.saludsystem.submodules.paciente.query.getById.evolucion.CambioCondicionByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.evolucion.CambioCondicionListHandler;
import com.saludsystem.submodules.paciente.response.evolucion.CambioCondicionListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesEvolucionesCambiosCondiciones")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones/CambiosCondiciones")
public class CambioCondicionQueryController {

    private final CambioCondicionListHandler listHandler;
    private final CambioCondicionByIdHandler byIdHandler;
    private final CambioCondicionAllHandler allHandler;

    public CambioCondicionQueryController(CambioCondicionListHandler listHandler, CambioCondicionByIdHandler byIdHandler, CambioCondicionAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<CambioCondicionDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public CambioCondicionDTO getById(@PathVariable Long id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CambioCondicionListResponse.class)))
    })
    public ListResponse<CambioCondicionDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}