package com.saludSystem.infrastructure.adapters.in.controllers.Principal;

import com.saludSystem.application.dtos.Principal.PUT.ActualizarEmpresaDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearEmpresaDTO;
import com.saludSystem.application.dtos.Principal.GET.EmpresaDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Principal.EmpresaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Empresas")
@RestController
@RequestMapping("/api/Empresas")
public class EmpresaController extends GenericController<EmpresaDTO, UUID, CrearEmpresaDTO, ActualizarEmpresaDTO> {

    protected EmpresaController(GenericService<EmpresaDTO, UUID, CrearEmpresaDTO, ActualizarEmpresaDTO> genericService) {
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