package com.saludsystem.submodules.core.paciente.rest.controller.command.historialclinico.evolucion;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PacientesEvolucionesCambiosCondiciones")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones/CambiosCondiciones")
public class CambioCondicionController {

    /*
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
                            schema = @Schema(implementation = CambioCondicionListResponse.class)))
    })
    public ListResponse<CambioCondicionDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return cambioCondicionService.getAllCambioCondicion(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{cambioCondicionId}")
    public CambioCondicionDTO getById(@PathVariable("cambioCondicionId") Long evolucionCambioCondicionId) {
        return cambioCondicionService.getCambioCondicionById(evolucionCambioCondicionId);
    }

    @PutMapping("/Update/{cambioCondicionId}")
    public ApiResponse update(@PathVariable("cambioCondicionId") Long evolucionCambioCondicionId,
                              @RequestBody ActualizarCambioCondicionDTO actualizarCambioCondicionDTO) {
        return cambioCondicionService.updateCambioCondicion(evolucionCambioCondicionId, actualizarCambioCondicionDTO);
    }

    @DeleteMapping("/Delete/{cambioCondicionId}")
    public ApiResponse destroy(@PathVariable("cambioCondicionId") Long evolucionCambioCondicionId) {
        return cambioCondicionService.deleteCambioCondicion(evolucionCambioCondicionId);
    }

     */
}