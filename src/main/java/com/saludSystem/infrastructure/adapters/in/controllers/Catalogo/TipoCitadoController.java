package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarTipoCitadoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearTipoCitadoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.TipoCitadoDTO;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.Catalogo.TipoCitadoResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.services.Catalogo.TipoCitadoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "TiposCitado")
@RestController
@RequestMapping("/api/TiposCitado")
public class TipoCitadoController {

    private final TipoCitadoService tipoCitadoService;

    public TipoCitadoController(TipoCitadoService tipoCitadoService) {
        this.tipoCitadoService = tipoCitadoService;
    }

    @PostMapping("/SaveTipoCitado")
    public ApiResponse store(@Valid @RequestBody CrearTipoCitadoDTO crearTipoCitadoDTO){
        return tipoCitadoService.saveTipoCitado(crearTipoCitadoDTO);
    }

    @GetMapping("/GetAllTipoCitado")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TipoCitadoResponse.class)))
    })
    public ListResponse<TipoCitadoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId, @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return tipoCitadoService.getAllTipoCitado(hospitalId, page, rows);
    }

    @GetMapping("/GetTipoCitadoList")
    public ResponseEntity<List<TipoCitadoDTO>> getAllList() {
        return ResponseEntity.ok(tipoCitadoService.getTipoCitadoList());
    }

    @GetMapping("/GetTipoCitado/{tipoCitadoId}")
    public TipoCitadoDTO getById(@PathVariable UUID tipoCitadoId) {
        return tipoCitadoService.getTipoCitadoById(tipoCitadoId);
    }

    @PutMapping("/UpdateTipoCitado/{tipoCitadoId}")
    public ApiResponse update(@PathVariable UUID tipoCitadoId, @RequestBody ActualizarTipoCitadoDTO actualizarTipoCitadoDTO) {
        return tipoCitadoService.updateTipoCitado(tipoCitadoId, actualizarTipoCitadoDTO);
    }

    @DeleteMapping("/DeleteTipoCitado/{tipoCitadoId}")
    public ApiResponse destroy(@PathVariable UUID tipoCitadoId) {
        return tipoCitadoService.deleteTipoCitado(tipoCitadoId);
    }

}
