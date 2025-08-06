package com.saludsystem.submodules.core.paciente.rest.controller.query.evolucion;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PacientesEvoluciones")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones")
public class EvolucionQueryController {

    /*
    private final EvolucionService evolucionService;

    public EvolucionController(EvolucionService evolucionService) {
        this.evolucionService = evolucionService;
    }

    @PostMapping("/Save")
    public ApiResponse stored(@Valid @RequestBody CrearEvolucionDTO crearEvolucionDTO) {
        return evolucionService.saveEvolucion(crearEvolucionDTO);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EvolucionListResponse.class)))
    })
    public ListResponse<EvolucionDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return evolucionService.getAllEvolucion(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{notaEvolucionId}")
    public EvolucionDTO getById(@PathVariable("notaEvolucionId") UUID pacienteEvolucionId) {
        return evolucionService.getEvolucionById(pacienteEvolucionId);
    }

    @PutMapping("/Update/{notaEvolucionId}")
    public ApiResponse update(@PathVariable("notaEvolucionId") UUID pacienteEvolucionId,
                              @RequestBody ActualizarEvolucionDTO actualizarEvolucionDTO) {
        return evolucionService.updateEvolucion(pacienteEvolucionId, actualizarEvolucionDTO);
    }

    @DeleteMapping("/Delete/{notaEvolucionId}")
    public ApiResponse destroy(@PathVariable("notaEvolucionId") UUID pacienteEvolucionId) {
        return evolucionService.deleteEvolucion(pacienteEvolucionId);
    }

     */
}