package com.saludsystem.submodules.core.principal.rest.controller.query;

import com.saludsystem.submodules.principal.model.dtos.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.query.getAll.InformacionClinicaAllHandler;
import com.saludsystem.submodules.principal.query.getById.InformacionClinicaByIdHandler;
import com.saludsystem.submodules.principal.query.getList.InformacionClinicaListHandler;
import com.saludsystem.submodules.principal.response.InformacionClinicaListResponse;
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

@Tag(name = "InformacionClinicas")
@RestController
@RequestMapping("/api/InformacionClinicas")
public class InformacionClinicaQueryController {

    private final InformacionClinicaByIdHandler byIdHandler;
    private final InformacionClinicaListHandler listHandler;
    private final InformacionClinicaAllHandler allHandler;

    public InformacionClinicaQueryController(InformacionClinicaByIdHandler byIdHandler, InformacionClinicaListHandler listHandler, InformacionClinicaAllHandler allHandler) {
        this.byIdHandler = byIdHandler;
        this.listHandler = listHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<InformacionClinicaDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public InformacionClinicaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = InformacionClinicaListResponse.class)))
    })
    public ListResponse<InformacionClinicaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}
