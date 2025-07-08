package com.saludsystem.principal.infrastructure.adapters.in.controller;

import com.saludsystem.principal.application.dto.req.InformacionClinicaRequest;
import com.saludsystem.principal.application.dto.res.InformacionClinicaResponse;
import com.saludsystem.principal.infrastructure.adapters.in.response.InformacionClinicaListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "InformacionClinicas")
@RestController
@RequestMapping("/api/InformacionClinicas")
public class InformacionClinicaController extends GenericController<InformacionClinicaRequest,
        InformacionClinicaResponse, UUID> {

    protected InformacionClinicaController(GenericService<InformacionClinicaRequest, InformacionClinicaResponse, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = InformacionClinicaListResponse.class)))
    })
    public ListResponse<InformacionClinicaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}