package com.saludsystem.principal.infrastructure.adapters.in.controller;

import com.saludsystem.principal.application.dto.res.EmpresaDTO;
import com.saludsystem.principal.application.dto.req.CrearEmpresaDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.principal.infrastructure.adapters.in.response.EmpresaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Empresas")
@RestController
@RequestMapping("/api/Empresas")
public class EmpresaController extends GenericController<CrearEmpresaDTO, EmpresaDTO, UUID> {

    protected EmpresaController(GenericService<CrearEmpresaDTO, EmpresaDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaResponse.class)))
    })
    public ListResponse<EmpresaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}