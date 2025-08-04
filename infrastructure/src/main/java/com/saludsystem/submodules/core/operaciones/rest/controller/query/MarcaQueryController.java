package com.saludsystem.submodules.core.operaciones.rest.controller.query;

import com.saludsystem.submodules.operaciones.model.dtos.MarcaDTO;
import com.saludsystem.submodules.operaciones.query.getAll.MarcaAllHandler;
import com.saludsystem.submodules.operaciones.query.getById.MarcaByIdHandler;
import com.saludsystem.submodules.operaciones.query.getList.MarcaListHandler;
import com.saludsystem.submodules.operaciones.response.MarcaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "MarcasMateriales")
@RestController
@RequestMapping("/api/MarcasMateriales")
public class MarcaQueryController {

    private final MarcaAllHandler allHandler;
    private final MarcaByIdHandler byIdHandler;
    private final MarcaListHandler listHandler;

    public MarcaQueryController(MarcaAllHandler allHandler, MarcaByIdHandler byIdHandler, MarcaListHandler listHandler) {
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<MarcaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public MarcaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MarcaListResponse.class)))
    })
    public ListResponse<MarcaDTO> getAllPaginated(@RequestParam UUID hospitalId,
                                                  @RequestParam(name = "Page") int page,
                                                  @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}
