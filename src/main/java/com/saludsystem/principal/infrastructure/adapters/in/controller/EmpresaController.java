package com.saludsystem.principal.infrastructure.adapters.in.controller;

import com.saludsystem.principal.application.dto.res.EmpresaResponse;
import com.saludsystem.principal.application.dto.req.EmpresaRequest;
import com.saludsystem.principal.infrastructure.adapters.in.response.EmpresaListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Empresas")
@RestController
@RequestMapping("/api/Empresas")
public class EmpresaController extends GenericController<EmpresaRequest, EmpresaResponse, UUID> {

    protected EmpresaController(GenericService<EmpresaRequest, EmpresaResponse, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaListResponse.class)))
    })
    public ListResponse<EmpresaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}