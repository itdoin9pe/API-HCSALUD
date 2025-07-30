package com.saludsystem.submodules.core.principal.rest.controller.query;

import com.saludsystem.submodules.principal.dtos.get.EstudioDTO;
import com.saludsystem.submodules.principal.query.getAll.EstudioAllHandler;
import com.saludsystem.submodules.principal.query.getById.EstudioByIdHandler;
import com.saludsystem.submodules.principal.query.getList.EstudioListHandler;
import com.saludsystem.submodules.principal.response.EstudioListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Estudios")
@RestController
@RequestMapping("/api/Estudios")
public class EstudioQueryController {

    private final EstudioListHandler listHandler;
    private final EstudioByIdHandler byIdHandler;
    private final EstudioAllHandler allHandler;

    public EstudioQueryController(EstudioListHandler listHandler, EstudioByIdHandler byIdHandler, EstudioAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<EstudioDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public EstudioDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EstudioListResponse.class)))
    })
    public ListResponse<EstudioDTO> getAllPaginated(@RequestParam UUID hospitalId,
                                                    @RequestParam(name = "Page") int page,
                                                    @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}
