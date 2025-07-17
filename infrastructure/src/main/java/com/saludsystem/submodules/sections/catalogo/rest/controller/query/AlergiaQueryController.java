package com.saludsystem.submodules.sections.catalogo.rest.controller.query;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.query.getAll.AlergiaAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.AlergiaByIdHandler;
import com.saludsystem.submodules.catalogo.response.AlergiaListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Alergias")
@RestController
@RequestMapping("/api/Alergias")
public class AlergiaQueryController {

    private final AlergiaAllHandler allHandler;
    private final AlergiaByIdHandler byIdHandler;

    public AlergiaQueryController(AlergiaAllHandler allHandler, AlergiaByIdHandler byIdHandler) {
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
    }

    @GetMapping("/GetById/{id}")
    public AlergiaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AlergiaListResponse.class)))
    })
    public List<AlergiaDTO> getAll(@RequestParam UUID hospitalId,
                                   @RequestParam(name = "Page") int page,
                                   @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, page, rows);
    }

}