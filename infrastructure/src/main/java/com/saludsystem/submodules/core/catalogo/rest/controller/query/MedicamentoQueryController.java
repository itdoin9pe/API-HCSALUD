package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import com.saludsystem.submodules.catalogo.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.query.getAll.MedicamentoAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.MedicamentoByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.MedicamentoListHandler;
import com.saludsystem.submodules.catalogo.response.MedicamentoListResponse;
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

@Tag(name = "Medicamentos")
@RestController
@RequestMapping("/api/Medicamentos")
public class MedicamentoQueryController {

    private final MedicamentoAllHandler allHandler;
    private final MedicamentoByIdHandler byIdHandler;
    private final MedicamentoListHandler listHandler;

    public MedicamentoQueryController(MedicamentoAllHandler allHandler, MedicamentoByIdHandler byIdHandler, MedicamentoListHandler listHandler) {
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<MedicamentoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public MedicamentoDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MedicamentoListResponse.class)))
    })
    public ListResponse<MedicamentoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}