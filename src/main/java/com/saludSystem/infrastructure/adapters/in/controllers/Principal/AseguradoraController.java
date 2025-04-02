package com.saludSystem.infrastructure.adapters.in.controllers.Principal;

import com.saludSystem.application.dtos.Principal.PUT.ActualizarAseguradoraDTO;
import com.saludSystem.application.dtos.Principal.GET.AseguradoraDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearAseguradoraDTO;
import com.saludSystem.application.services.Principal.AseguradoraService;
import com.saludSystem.infrastructure.adapters.in.response.Principal.AseguradoraResponse;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "Aseguradoras")
@RestController
@RequestMapping("/api/Aseguradoras")
public class AseguradoraController {

    private final AseguradoraService aseguradoraService;

    public AseguradoraController(AseguradoraService aseguradoraService) {
        this.aseguradoraService = aseguradoraService;
    }

    @PostMapping("/SaveAseguradora")
    public ApiResponse store(@Valid @RequestBody CrearAseguradoraDTO crearAseguradoraDTO) {
        return aseguradoraService.saveAseguradora(crearAseguradoraDTO);
    }

    @GetMapping("/GetAllAseguradora")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AseguradoraResponse.class)))
    })
    public ListResponse<AseguradoraDTO> getAllPage(@RequestParam(name = "hospitalId") UUID hospitalId, @RequestParam(name = "Page", defaultValue = "") int page, @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return aseguradoraService.getAllAseguradoras(hospitalId, page, rows);
    }

    @GetMapping("/GetAseguradoraList")
    public ResponseEntity<List<AseguradoraDTO>> getAllList() {
        return ResponseEntity.ok(aseguradoraService.getAseguradoraList());
    }

    @GetMapping("/GetAseguradora/{aseguradoraId}")
    public AseguradoraDTO getById(@PathVariable UUID aseguradoraId) {
        return aseguradoraService.getAseguradoraById(aseguradoraId);
    }

    @PutMapping("/UpdateAseguradora/{aseguradoraId}")
    public ApiResponse update(@PathVariable UUID aseguradoraId, @RequestBody ActualizarAseguradoraDTO actualizarAseguradoraDTO) {
        return aseguradoraService.updateAseguradora(aseguradoraId, actualizarAseguradoraDTO);
    }

    @DeleteMapping("/DeleteAseguradora/{aseguradoraId}")
    public ApiResponse destroy(@PathVariable UUID aseguradoraId) {
        return aseguradoraService.deleteAseguradora(aseguradoraId);
    }

}