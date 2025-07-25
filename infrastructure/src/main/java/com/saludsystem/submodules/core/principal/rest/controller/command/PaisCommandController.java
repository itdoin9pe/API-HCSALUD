package com.saludsystem.submodules.core.principal.rest.controller.command;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Paises")
@RestController
@RequestMapping("/api/Paises")
public class PaisCommandController {

    /*
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

     */

}