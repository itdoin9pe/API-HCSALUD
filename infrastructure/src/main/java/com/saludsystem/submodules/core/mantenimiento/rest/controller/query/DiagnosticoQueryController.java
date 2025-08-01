package com.saludsystem.submodules.core.mantenimiento.rest.controller.query;

import com.saludsystem.submodules.mantenimiento.model.dtos.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.query.getAll.EnfermedadAllHandler;
import com.saludsystem.submodules.mantenimiento.query.getById.EnfermedadByIdHandler;
import com.saludsystem.submodules.mantenimiento.query.getList.EnfermedadListHandler;
import com.saludsystem.submodules.mantenimiento.response.EnfermedadListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Enfermedades")
@RestController
@RequestMapping("/api/Enfermedades")
public class DiagnosticoQueryController {

    private final EnfermedadByIdHandler byIdHandler;
    private final EnfermedadListHandler listHandler;
    private final EnfermedadAllHandler allHandler;

    public DiagnosticoQueryController(EnfermedadByIdHandler byIdHandler, EnfermedadListHandler listHandler, EnfermedadAllHandler allHandler) {
        this.byIdHandler = byIdHandler;
        this.listHandler = listHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EnfermedadListResponse.class)))
    })
    public ListResponse<EnfermedadDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

    @GetMapping("/GetList")
    public List<EnfermedadDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetEnfermedad/{enfermedadId}")
    public EnfermedadDTO getById(@PathVariable String enfermedadId) {
        return byIdHandler.execute(enfermedadId);
    }

}
