package com.saludsystem.infrastructure.web.restclient.principal;

import com.saludsystem.application.dto.get.PaisDTO;
import com.saludsystem.application.dto.post.CrearPaisDTO;
import com.saludsystem.application.service.PaisService;
import com.saludsystem.infrastructure.adapters.in.response.PaisListResponse;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;
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
    public ApiResponse store(@Valid @RequestBody CrearPaisDTO crearPaisDTO) {
        return paisService.savePais(crearPaisDTO);
    }

    @GetMapping("/GetAllPais")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaisListResponse.class)))
    })
    public ListResponse<PaisDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return paisService.getAllPais(hospitalId, page, rows);
    }

    @GetMapping("/GetPaisList")
    public ResponseEntity<List<PaisDTO>> getAllList() {
        return ResponseEntity.ok(paisService.getPaisList());
    }

}