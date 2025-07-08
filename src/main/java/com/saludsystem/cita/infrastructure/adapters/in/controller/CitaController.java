package com.saludsystem.cita.infrastructure.adapters.in.controller;

import com.saludsystem.cita.application.dto.res.CitaResponse;
import com.saludsystem.cita.application.dto.req.CitaRequest;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.cita.infrastructure.adapters.in.response.CitaListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "CitasMedicas")
@RestController
@RequestMapping("/api/CitasMedicas")
public class CitaController extends GenericController<CitaRequest, CitaResponse, UUID> {

    protected CitaController(GenericService<CitaRequest, CitaResponse, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CitaListResponse.class)))
    })
    public ListResponse<CitaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}