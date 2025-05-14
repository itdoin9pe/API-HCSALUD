package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTipoPagoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TipoPagoDTO;
import com.saludSystem.application.services.Mantenimiento.TipoPagoService;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.TipoPagoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TiposPagos")
@RestController
@RequestMapping("/api/TiposPagos")
public class TipoPagoController {

    private final TipoPagoService tipoPagoService;

    public TipoPagoController(TipoPagoService tipoPagoService) {
        this.tipoPagoService = tipoPagoService;
    }

    @PostMapping("/SaveTipoPago")
    public ApiResponse store(@Valid @RequestBody CrearTipoPagoDTO crearTipoPagoDTO) {
        return tipoPagoService.saveTipoPago(crearTipoPagoDTO);
    }

    @GetMapping("/GetAllTipoPago")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoPagoResponse.class)))
    })
    public ListResponse<TipoPagoDTO> getAllPage
            (@RequestParam(name = "hospitalId") UUID hospitalId,
             @RequestParam(name = "Page", defaultValue = "") int page, @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return tipoPagoService.getAllTipoPago(hospitalId, page, rows);
    }

    @GetMapping("/GetTipoPagoList")
    public ResponseEntity<List<TipoPagoDTO>> getAllList() {
        return ResponseEntity.ok(tipoPagoService.getListTipoPago());
    }

    @GetMapping("/GetTipoPago/{tipoPagoId}")
    public TipoPagoDTO getById(@PathVariable UUID tipoPagoId) {
        return tipoPagoService.getTipoPagoById(tipoPagoId);
    }

    @PutMapping("/UpdateTipoPago/{tipoPagoId}")
    public ApiResponse update(@PathVariable UUID tipoPagoId, @RequestBody ActualizarTipoPagoDTO actualizarTipoPagoDTO) {
        return tipoPagoService.updateTipoPago(tipoPagoId, actualizarTipoPagoDTO);
    }

    @DeleteMapping("/DeleteTipoPago/{tipoPagoId}")
    public ApiResponse destroy(@PathVariable UUID tipoPagoId) {
        return tipoPagoService.deleteTipoPago(tipoPagoId);
    }

}