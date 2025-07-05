package com.saludsystem.infrastructure.adapters.in.controllers.paciente.Evolucion;

import com.saludsystem.application.dtos.paciente.get.historialclinico.evolucion.CambioCondicionDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.evolucion.CrearCambioCondicionDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.evolucion.ActualizarCambioCondicionDTO;
import com.saludsystem.application.services.paciente.historialclinico.evolucion.CambioCondicionService;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.paciente.Evolucion.CambioCondicionResponse;
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
    public ApiResponse stored(@Valid @RequestBody CrearCambioCondicionDTO crearCambioCondicionDTO) {
        return cambioCondicionService.saveCambioCondicion(crearCambioCondicionDTO);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CambioCondicionResponse.class)))
    })
    public ListResponse<CambioCondicionDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return cambioCondicionService.getAllCambioCondicion(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{Id}")
    public CambioCondicionDTO getById(@PathVariable Long evolucionCambioCondicionId) {
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