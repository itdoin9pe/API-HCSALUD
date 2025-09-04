package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.query.getAll.MedidaAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.MedidaByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.MedidaListHandler;
import com.saludsystem.submodules.catalogo.response.MedidaListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Medidas")
@RestController
@RequestMapping("/api/Medidas")
public class MedidaQueryController {

    private final MedidaAllHandler allHandler;
    private final MedidaByIdHandler byIdHandler;
    private final MedidaListHandler listHandler;

    public MedidaQueryController(MedidaAllHandler allHandler, MedidaByIdHandler byIdHandler, MedidaListHandler listHandler) {
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<MedidaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{medidaId}")
    public MedidaDTO getById(@PathVariable UUID medidaId) {
        return byIdHandler.execute(medidaId);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MedidaListResponse.class)))
    })
    public ListResponse<MedidaDTO> getAllPaginated(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}
