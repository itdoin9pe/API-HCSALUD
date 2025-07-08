package com.saludsystem.principal.infrastructure.adapters.in.controller;

import com.saludsystem.principal.application.dto.res.PaisResponse;
import com.saludsystem.principal.application.dto.req.PaisRequest;
import com.saludsystem.principal.application.service.PaisService;
import com.saludsystem.principal.infrastructure.adapters.in.response.PaisListResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "Paises")
@RestController
@RequestMapping("/api/Paises")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService){
        this.paisService = paisService;
    }

    @PostMapping("/SavePais")
    public ApiResponse store(@Valid @RequestBody PaisRequest paisRequest) {
        return paisService.savePais(paisRequest);
    }

    @GetMapping("/GetAllPais")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaisListResponse.class)))
    })
    public ListResponse<PaisResponse> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return paisService.getAllPais(hospitalId, page, rows);
    }

    @GetMapping("/GetPaisList")
    public ResponseEntity<List<PaisResponse>> getAllList() {
        return ResponseEntity.ok(paisService.getPaisList());
    }

}