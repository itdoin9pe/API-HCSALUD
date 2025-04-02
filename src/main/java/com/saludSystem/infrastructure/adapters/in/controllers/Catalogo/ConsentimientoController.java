package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ConsentimientoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearConsentimientoDTO;
import com.saludSystem.infrastructure.adapters.in.response.Catalogo.ConsentimientoResponse;
import com.saludSystem.application.services.Catalogo.ConsentimientoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Consentimientos")
@RestController
@RequestMapping("/api/Consentimientos")
public class ConsentimientoController {

    private final ConsentimientoService consentimientoService;

    public ConsentimientoController(ConsentimientoService consentimientoService) {
        this.consentimientoService = consentimientoService;
    }

    @PostMapping("/SaveConsentimiento")
    public ApiResponse store(@Valid @RequestBody CrearConsentimientoDTO crearConsentimientoDTO){
        return consentimientoService.saveConsentimiento(crearConsentimientoDTO);
    }

    @GetMapping("/GetAllConsentimiento")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsentimientoResponse.class)))
    })
    public ListResponse<ConsentimientoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return consentimientoService.getAllConsentimiento(hospitalId, page, rows);
    }

    @GetMapping("/GetConsentimiento/{consentimientoId}")
    public ConsentimientoDTO getById(@PathVariable UUID consentimientoId) {
        return consentimientoService.getConsentimientoById(consentimientoId);
    }

    @PutMapping("/UpdateConsentimiento/{consentimientoId}")
    public ApiResponse update(@PathVariable UUID consentimientoId, @RequestBody ActualizarConsentimientoDTO actualizarConsentimientoDTO) {
        return consentimientoService.updateConsentimiento(consentimientoId, actualizarConsentimientoDTO);
    }

    @DeleteMapping("/DeleteConsentimiento/{consentimientoId}")
    public ApiResponse destroy(@PathVariable UUID consentimientoId) {
        return consentimientoService.deleteConsentimiento(consentimientoId);
    }

}