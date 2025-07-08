package com.saludsystem.paciente.infrastructure.adapters.in.controller.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.CambioCondicionResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.CambioCondicionRequest;
import com.saludsystem.paciente.application.dto.base.evolucion.ActualizarCambioCondicionDTO;
import com.saludsystem.paciente.application.service.historialclinico.evolucion.CambioCondicionService;
import com.saludsystem.paciente.infrastructure.adapters.in.response.Evolucion.CambioCondicionListResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEvolucionesCambiosCondiciones")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones/CambiosCondiciones")
public class CambioCondicionController {

    private final CambioCondicionService cambioCondicionService;

    public CambioCondicionController(CambioCondicionService cambioCondicionService) {
        this.cambioCondicionService = cambioCondicionService;
    }

    @PostMapping("/Save")
    public ApiResponse stored(@Valid @RequestBody CambioCondicionRequest cambioCondicionRequest) {
        return cambioCondicionService.saveCambioCondicion(cambioCondicionRequest);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CambioCondicionListResponse.class)))
    })
    public ListResponse<CambioCondicionResponse> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return cambioCondicionService.getAllCambioCondicion(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{Id}")
    public CambioCondicionResponse getById(@PathVariable Long evolucionCambioCondicionId) {
        return cambioCondicionService.getCambioCondicionById(evolucionCambioCondicionId);
    }

    @PutMapping("/Update/{Id}")
    public ApiResponse update(@PathVariable Long evolucionCambioCondicionId,
                              @RequestBody ActualizarCambioCondicionDTO actualizarCambioCondicionDTO) {
        return cambioCondicionService.updateCambioCondicion(evolucionCambioCondicionId, actualizarCambioCondicionDTO);
    }

    @DeleteMapping("/Delete/{Id}")
    public ApiResponse destroy(@PathVariable Long evolucionCambioCondicionId) {
        return cambioCondicionService.deleteCambioCondicion(evolucionCambioCondicionId);
    }
}