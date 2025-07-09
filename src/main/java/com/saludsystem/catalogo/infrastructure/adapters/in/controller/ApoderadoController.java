package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

import com.saludsystem.catalogo.application.dtos.get.ApoderadoDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearApoderadoDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarApoderadoDTO;
import com.saludsystem.catalogo.infrastructure.adapters.in.response.ApoderadoListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Apoderados")
@RestController
@RequestMapping("/api/Apoderados")
public class ApoderadoController extends GenericController<ApoderadoDTO, CrearApoderadoDTO, ActualizarApoderadoDTO, UUID> {

    protected ApoderadoController(GenericService<ApoderadoDTO, CrearApoderadoDTO, ActualizarApoderadoDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApoderadoListResponse.class)))
    })
    public ListResponse<ApoderadoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}