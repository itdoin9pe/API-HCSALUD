package com.saludsystem.submodules.sections.paciente.rest.controller.command.historialclinico.evolucion;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "PacientesEvolucionesAltasMedicas")
@RestController 
@RequestMapping("/api/Pacientes/Evoluciones/AltasMedicas")
public class AltaMedicaController {

    /*
    private final AltaMedicaService altaMedicaService;

    public AltaMedicaController(AltaMedicaService altaMedicaService) {
        this.altaMedicaService = altaMedicaService;
    }

    @PostMapping("/Save")
    public ApiResponse stored(@Valid @RequestBody CrearAltaMedicaDTO crearAltaMedicaDTO) {
        return altaMedicaService.saveAltaMedica(crearAltaMedicaDTO);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AltaMedicaListResponse.class)))
    })
    public ListResponse<AltaMedicaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return altaMedicaService.getAllAltaMedica(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{altaMedicaId}")
    public AltaMedicaDTO getById(@PathVariable("altaMedicaId") Long evolucionAltaMedicaId) {
        return altaMedicaService.getAltaMedicaById(evolucionAltaMedicaId);
    }

    @PutMapping("/Update/{altaMedicaId}")
    public ApiResponse update(@PathVariable("altaMedicaId") Long evolucionAltaMedicaId,
                              @RequestBody ActualizarAltaMedicaDTO actualizarAltaMedicaDTO) {
        return altaMedicaService.updateAltaMedica(evolucionAltaMedicaId, actualizarAltaMedicaDTO);
    }

    @DeleteMapping("/Delete/{altaMedicaId}")
    public ApiResponse destroy(@PathVariable("altaMedicaId") Long evolucionAltaMedicaId) {
        return altaMedicaService.deleteAltaMedica(evolucionAltaMedicaId);
    }

     */
}