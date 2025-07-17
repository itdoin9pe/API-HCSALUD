package com.saludsystem.submodules.rest.controller.catalogo.query;

import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.query.getAll.PlanAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.PlanByIdHandler;
import com.saludsystem.submodules.catalogo.response.PlanListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Tag(name = "Planes")
@RestController
@RequestMapping("/api/Planes")
public class PlanQueryController {

    private final PlanByIdHandler byIdHandler;
    private final PlanAllHandler allHandler;

    public PlanQueryController(PlanByIdHandler byIdHandler, PlanAllHandler allHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PlanListResponse.class)))
    })
    public List<PlanDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, page, rows);
    }
}
