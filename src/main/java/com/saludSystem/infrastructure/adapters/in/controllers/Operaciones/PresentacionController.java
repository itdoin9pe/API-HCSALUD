package com.saludSystem.infrastructure.adapters.in.controllers.Operaciones;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearPresentacionDTO;
import com.saludSystem.application.dtos.Operaciones.GET.PresentacionDTO;
import com.saludSystem.application.services.Operaciones.PresentacionService;
import com.saludSystem.infrastructure.adapters.in.response.Operaciones.PresentacionResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Presentaciones")
@RestController
@RequestMapping("/api/Presentaciones")
public class PresentacionController {

    private final PresentacionService presentacionService;

    public PresentacionController(PresentacionService presentacionService) {
        this.presentacionService = presentacionService;
    }

    @PostMapping("/SavePresentacion")
    public ApiResponse store(@Valid @RequestBody CrearPresentacionDTO crearPresentacionDTO) {
        return presentacionService.savePresentacion(crearPresentacionDTO);
    }

    @GetMapping("/GetAllPresentacion")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PresentacionResponse.class)))
    })
    public ListResponse<PresentacionDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return presentacionService.getAllPresentacion(hospitalId, page, rows);
    }

    @GetMapping("/GetPresentacionList")
    public ResponseEntity<List<PresentacionDTO>> getAllList() {
        return ResponseEntity.ok(presentacionService.getPresentacionList());
    }

    @GetMapping("/GetPresentacion/{presentacionId}")
    public PresentacionDTO getById(@PathVariable UUID presentacionId) {
        return presentacionService.getPresentacionById(presentacionId);
    }

    @PutMapping("/UpdatePresentacion/{presentacionId}")
    public ApiResponse update(@PathVariable UUID presentacionId, @RequestBody ActualizarPresentacionDTO actualizarPresentacionDTO) {
        return presentacionService.updatePresentacion(presentacionId, actualizarPresentacionDTO);
    }

    @DeleteMapping("/DeletePresentacion/{presentacionId}")
    public ApiResponse destroy(@PathVariable UUID presentacionId) {
        return presentacionService.deletePresentacion(presentacionId);
    }

}
