package com.saludSystem.infraestructura.controllers.Generals;
/*
import com.saludSystem.dtos.Generals.Pais.CrearPaisDTO;
import com.saludSystem.dtos.Generals.Pais.PaisDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Generals.PaisResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.services.modules.Generals.Pais.PaisService;
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
                            schema = @Schema(implementation = PaisResponse.class)))
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

 */