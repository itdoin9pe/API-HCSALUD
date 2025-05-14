package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.CambioCondicionDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearCambioCondicionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarCambioCondicionDTO;
import com.saludSystem.application.services.Paciente.Evolucion.CambioCondicionService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.Evolucion.CambioCondicionResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEvolucionesCambiosCondiciones")
@RestController
@RequestMapping("/api/PacientesEvolucionesCambiosCondiciones")
public class CambioCondicionController {

    private final CambioCondicionService cambioCondicionService;

    public CambioCondicionController(CambioCondicionService cambioCondicionService) {
        this.cambioCondicionService = cambioCondicionService;
    }

    @PostMapping("/SavePacienteEvolucionCambioCondicion")
    public ApiResponse stored(@Valid @RequestBody CrearCambioCondicionDTO crearCambioCondicionDTO) {
        return cambioCondicionService.saveCambioCondicion(crearCambioCondicionDTO);
    }

    @GetMapping("/GetAllPacienteEvolucionCambioCondicion")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CambioCondicionResponse.class)))
    })
    public ListResponse<CambioCondicionDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return cambioCondicionService.getAllCambioCondicion(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEvolucionCambioCondicion/{pacienteEvolucionCambioCondicionId}")
    public CambioCondicionDTO getById(@PathVariable Long evolucionCambioCondicionId) {
        return cambioCondicionService.getCambioCondicionById(evolucionCambioCondicionId);
    }

    @PutMapping("/UpdatePacienteEvolucionCambioCondicion/{pacienteEvolucionCambioCondicionId}")
    public ApiResponse update(@PathVariable Long evolucionCambioCondicionId, @RequestBody ActualizarCambioCondicionDTO actualizarCambioCondicionDTO) {
        return cambioCondicionService.updateCambioCondicion(evolucionCambioCondicionId, actualizarCambioCondicionDTO);
    }

    @DeleteMapping("/DeletePacienteEvolucionCambioCondicion/{pacienteEvolucionCambioCondicionId}")
    public ApiResponse destroy(@PathVariable Long evolucionCambioCondicionId) {
        return cambioCondicionService.deleteCambioCondicion(evolucionCambioCondicionId);
    }

}