package com.saludsystem.submodules.rest.controller.catalogo.query;

import com.saludsystem.submodules.catalogo.dtos.get.MedidaDTO;
import com.saludsystem.submodules.catalogo.query.getAll.MedidaAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.MedidaByIdHandler;
import com.saludsystem.submodules.catalogo.response.MedidaListResponse;
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

@Tag(name = "Medidas")
@RestController
@RequestMapping("/api/Medidas")
public class MedidaQueryController {

    private final MedidaAllHandler allHandler;
    private final MedidaByIdHandler byIdHandler;

    public MedidaQueryController(MedidaAllHandler allHandler, MedidaByIdHandler byIdHandler) {
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
    }

    @GetMapping("/GetById/{id}")
    public MedidaDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MedidaListResponse.class)))
    })
    public List<MedidaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, page, rows);
    }
}
