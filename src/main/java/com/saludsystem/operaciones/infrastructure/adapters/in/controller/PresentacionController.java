package com.saludsystem.operaciones.infrastructure.adapters.in.controller;

import com.saludsystem.operaciones.application.dto.get.PresentacionDTO;
import com.saludsystem.operaciones.application.dto.post.CrearPresentacionDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarPresentacionDTO;
import com.saludsystem.operaciones.infrastructure.adapters.in.response.PresentacionListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Presentaciones")
@RestController
@RequestMapping("/api/Presentaciones")
public class PresentacionController extends GenericController<PresentacionDTO, CrearPresentacionDTO,
        ActualizarPresentacionDTO, UUID> {

    protected PresentacionController(
            GenericService<PresentacionDTO, CrearPresentacionDTO, ActualizarPresentacionDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PresentacionListResponse.class)))
    })
    public ListResponse<PresentacionDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}