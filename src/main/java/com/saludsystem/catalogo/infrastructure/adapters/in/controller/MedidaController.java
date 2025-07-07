package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

import com.saludsystem.catalogo.application.dtos.res.MedidaDTO;
import com.saludsystem.catalogo.application.dtos.req.CrearMedidaDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.in.response.MedidaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Medidas")
@RestController
@RequestMapping("/api/Medidas")
public class MedidaController extends GenericController<CrearMedidaDTO, MedidaDTO, UUID> {

    protected MedidaController(GenericService<CrearMedidaDTO, MedidaDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MedidaResponse.class)))
    })
    public ListResponse<MedidaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}