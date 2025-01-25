package com.saludSystem.controllers.Generals;

import com.saludSystem.dtos.Generals.Pais.CrearPaisDTO;
import com.saludSystem.dtos.Generals.Pais.PaisDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Generals.AseguradoraResponse;
import com.saludSystem.dtos.responses.Generals.PaisResponse;
import com.saludSystem.services.modules.Generals.Pais.PaisService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Paises")
@RestController
@RequestMapping("/api/Paises")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService){
        this.paisService = paisService;
    }

    @PostMapping("/SavePais")
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearPaisDTO crearPaisDTO) {
        paisService.savePais(crearPaisDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Estudio creado correctamente"));
    }

    @GetMapping("/GetAllPais")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PaisResponse.class)))
    })
    public ResponseEntity<Map<String, Object>> getAllPage(
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows
    ) {
        List<PaisDTO> paises = paisService.getAllPais(page, rows);
        long totalData = paisService.getTotalCount();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("data", paises);
        response.put("totalData", totalData);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/GetPaisList")
    public ResponseEntity<List<PaisDTO>> getAllList() {
        return ResponseEntity.ok(paisService.getPaisList());
    }

}
