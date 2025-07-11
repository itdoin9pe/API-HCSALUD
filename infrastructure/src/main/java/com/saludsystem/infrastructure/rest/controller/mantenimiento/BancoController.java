package com.saludsystem.infrastructure.rest.controller.mantenimiento;

import com.saludsystem.mantenimiento.application.dto.get.BancoDTO;
import com.saludsystem.mantenimiento.application.dto.post.CrearBancoDTO;
import com.saludsystem.mantenimiento.application.dto.put.ActualizarBancoDTO;
import com.saludsystem.mantenimiento.infrastructure.adapters.in.response.BancoListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Bancos")
@RestController
@RequestMapping("/api/Bancos")
public class BancoController extends GenericController<BancoDTO, CrearBancoDTO, ActualizarBancoDTO, UUID> {

    protected BancoController(GenericService<BancoDTO, CrearBancoDTO, ActualizarBancoDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BancoListResponse.class)))
    })
    public ListResponse<BancoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}