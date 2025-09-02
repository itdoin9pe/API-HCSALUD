package com.saludsystem.submodules.core.principal.rest.controller.query;

import com.saludsystem.submodules.principal.model.dtos.AseguradoraDTO;
import com.saludsystem.submodules.principal.query.getAll.AseguradoraAllHandler;
import com.saludsystem.submodules.principal.query.getById.AseguradoraByIdHandler;
import com.saludsystem.submodules.principal.query.getList.AseguradoraListHandler;
import com.saludsystem.submodules.principal.response.AseguradoraListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Tag(name = "Aseguradoras")
@RestController
@RequestMapping("/api/Aseguradoras")
public class AseguradoraQueryController {

    private final AseguradoraAllHandler allHandler;
    private final AseguradoraListHandler listHandler;
    private final AseguradoraByIdHandler byIdHandler;

    public AseguradoraQueryController(AseguradoraAllHandler allHandler, AseguradoraListHandler listHandler, AseguradoraByIdHandler byIdHandler) {
        this.allHandler = allHandler;
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
    }

    @GetMapping("/GetList")
    public List<AseguradoraDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public AseguradoraDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = AseguradoraListResponse.class)))
    })
    public ListResponse<AseguradoraDTO> getAllPaginated(@RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}
