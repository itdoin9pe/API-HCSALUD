package com.saludsystem.infrastructure.web.restclient.principal;

import com.saludsystem.application.dto.get.EmpresaDTO;
import com.saludsystem.application.dto.post.CrearEmpresaDTO;
import com.saludsystem.application.dto.put.ActualizarEmpresaDTO;
import com.saludsystem.infrastructure.adapters.in.response.EmpresaListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Empresas")
@RestController
@RequestMapping("/api/Empresas")
public class EmpresaController extends GenericController<EmpresaDTO, CrearEmpresaDTO, ActualizarEmpresaDTO, UUID> {

    protected EmpresaController(
            GenericService<EmpresaDTO, CrearEmpresaDTO, ActualizarEmpresaDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmpresaListResponse.class)))
    })
    public ListResponse<EmpresaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}