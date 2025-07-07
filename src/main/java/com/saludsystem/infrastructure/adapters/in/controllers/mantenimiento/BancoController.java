package com.saludsystem.infrastructure.adapters.in.controllers.mantenimiento;

import com.saludsystem.application.dtos.mantenimiento.get.BancoDTO;
import com.saludsystem.application.dtos.mantenimiento.post.CrearBancoDTO;
import com.saludsystem.application.dtos.mantenimiento.put.ActualizarBancoDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.mantenimiento.BancoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Bancos")
@RestController
@RequestMapping("/api/Bancos")
public class BancoController extends GenericController<CrearBancoDTO, BancoDTO, UUID> {

    protected BancoController(GenericService<CrearBancoDTO, BancoDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BancoResponse.class)))
    })
    public ListResponse<BancoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}