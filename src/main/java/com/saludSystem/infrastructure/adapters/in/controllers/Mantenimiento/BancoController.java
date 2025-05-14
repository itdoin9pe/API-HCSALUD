package com.saludSystem.infrastructure.adapters.in.controllers.Mantenimiento;

import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarBancoDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.BancoDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearBancoDTO;
import com.saludSystem.application.services.Mantenimiento.BancoService;
import com.saludSystem.infrastructure.adapters.in.response.Mantenimiento.BancoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Bancos")
@RestController
@RequestMapping("/api/Bancos")
public class BancoController {

    private final BancoService bancoService;

    public BancoController(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    @PostMapping("/SaveBanco")
    public ApiResponse store(@Valid @RequestBody CrearBancoDTO crearBancoDTO) {
        return bancoService.saveBanco(crearBancoDTO);
    }

    @GetMapping("/GetAllBanco")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = BancoResponse.class)))
    })
    public ListResponse<BancoDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return bancoService.getAllBanco(hospitalId, page, rows);
    }

    @GetMapping("/GetBancoList")
    public ResponseEntity<List<BancoDTO>> getAllList() {
        return ResponseEntity.ok(bancoService.getBancoList());
    }

    @GetMapping("/GetBanco/{bancoId}")
    public BancoDTO getById(@PathVariable UUID bancoId) {
        return bancoService.getBancoById(bancoId);
    }

    @PutMapping("/UpdateBanco/{bancoId}")
    public ApiResponse update(@PathVariable UUID bancoId, @RequestBody ActualizarBancoDTO actualizarBancoDTO) {
        return bancoService.updateBanco(bancoId, actualizarBancoDTO);
    }

    @DeleteMapping("/DeleteBanco/{bancoId}")
    public ApiResponse destroy(@PathVariable UUID bancoId) {
        return bancoService.deleteBanco(bancoId);
    }

}