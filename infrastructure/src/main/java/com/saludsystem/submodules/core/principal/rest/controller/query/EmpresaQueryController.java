package com.saludsystem.submodules.core.principal.rest.controller.query;

import com.saludsystem.submodules.principal.dtos.get.EmpresaDTO;
import com.saludsystem.submodules.principal.query.getAll.EmpresaAllHandler;
import com.saludsystem.submodules.principal.query.getById.EmpresaByIdHandler;
import com.saludsystem.submodules.principal.query.getList.EmpresaListHandler;
import com.saludsystem.submodules.principal.response.EmpresaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Tag(name = "Empresas")
@RestController
@RequestMapping("/api/Empresas")
public class EmpresaQueryController {

    private final EmpresaListHandler listHandler;
    private final EmpresaByIdHandler byIdHandler;
    private final EmpresaAllHandler allHandler;

    public EmpresaQueryController(EmpresaListHandler listHandler, EmpresaByIdHandler byIdHandler, EmpresaAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<EmpresaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public EmpresaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaListResponse.class)))
    })
    public ListResponse<EmpresaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}
