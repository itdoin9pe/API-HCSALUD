package com.saludsystem.catalogo.infrastructure.adapters.in.controller;

import com.saludsystem.catalogo.application.dtos.get.ClienteDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearClienteDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarClienteDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.in.response.ClienteListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Clientes")
@RestController
@RequestMapping("/api/Clientes")
public class ClienteController extends GenericController<ClienteDTO, CrearClienteDTO, ActualizarClienteDTO, UUID> {

    protected ClienteController(
            GenericService<ClienteDTO, CrearClienteDTO, ActualizarClienteDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClienteListResponse.class)))
    })
    public ListResponse<ClienteDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}