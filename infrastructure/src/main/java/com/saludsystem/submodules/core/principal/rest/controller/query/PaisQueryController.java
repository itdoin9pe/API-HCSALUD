package com.saludsystem.submodules.core.principal.rest.controller.query;

import com.saludsystem.submodules.principal.dtos.get.PaisDTO;
import com.saludsystem.submodules.principal.query.getAll.PaisAllHandler;
import com.saludsystem.submodules.principal.query.getById.PaisByIdHandler;
import com.saludsystem.submodules.principal.query.getList.PaisListHandler;
import com.saludsystem.submodules.principal.response.PaisListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Paises")
@RestController
@RequestMapping("/api/Paises")
public class PaisQueryController {

    private final PaisListHandler paisListHandler;
    private final PaisByIdHandler byIdHandler;
    private final PaisAllHandler allHandler;

    public PaisQueryController(PaisListHandler paisListHandler, PaisByIdHandler byIdHandler, PaisAllHandler allHandler) {
        this.paisListHandler = paisListHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetById/{id}")
    public PaisDTO getById(@PathVariable Integer id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAllPais")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaisListResponse.class)))
    })
    public ListResponse<PaisDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

    @GetMapping("/GetPaisList")
    public List<PaisDTO> getAllList() {
        return paisListHandler.execute();
    }

}
