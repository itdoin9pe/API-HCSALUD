package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import com.saludsystem.submodules.catalogo.dto.ClienteDTO;
import com.saludsystem.submodules.catalogo.query.getAll.ClienteAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.ClienteByIdHandler;
import com.saludsystem.submodules.catalogo.query.getList.ClienteListHandler;
import com.saludsystem.submodules.catalogo.response.ClienteListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Clientes")
@RestController
@RequestMapping("/api/Clientes")
public class ClienteQueryController {

    private final ClienteByIdHandler byIdHandler;
    private final ClienteAllHandler allHandler;
    private final ClienteListHandler listHandler;

    public ClienteQueryController(ClienteByIdHandler byIdHandler, ClienteAllHandler allHandler, ClienteListHandler listHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetList")
    public List<ClienteDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public ClienteDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClienteListResponse.class)))
    })
    public ListResponse<ClienteDTO> getAllPaginated(
            @RequestParam UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}
