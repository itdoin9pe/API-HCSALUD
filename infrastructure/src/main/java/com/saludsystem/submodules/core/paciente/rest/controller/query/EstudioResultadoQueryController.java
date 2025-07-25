package com.saludsystem.submodules.core.paciente.rest.controller.query;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PacientesEstudiosResultados")
@RestController
@RequestMapping("/api/PacientesEstudiosResultados")
public class EstudioResultadoQueryController {

    /*
    private final EstudioResultadoService estudioResultadoService;

    public EstudioResultadoController(EstudioResultadoService estudioResultadoService) {
        this.estudioResultadoService = estudioResultadoService;
    }

    @PostMapping("/SavePacienteEstudioResultado")
    public ApiResponse stored(@Valid @RequestBody CrearEstudioResultadoDTO crearEstudioResultadoDTO) {
        return estudioResultadoService.saveEstudioResultado(crearEstudioResultadoDTO);
    }

    @GetMapping("/GetAllPacienteEstudioResultado")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstudioResultadoListResponse.class)))
    })
    public ListResponse<EstudioResultadoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return estudioResultadoService.getAllEstudioResultado(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEstudioResultado/{pacienteEstudioResultadoId}")
    public EstudioResultadoDTO getById(@PathVariable Long pacienteEstudioResultadoId) {
        return estudioResultadoService.getEstudioResultadoById(pacienteEstudioResultadoId);
    }

    @PutMapping("/UpdatePacienteEstudioResultado/{pacienteEstudioResultadoId}")
    public ApiResponse update(@PathVariable Long pacienteEstudioResultadoId,
                              @RequestBody ActualizarEstudioResultadoDTO actualizarEstudioResultadoDTO) {
        return estudioResultadoService.updateEstudioResultado(pacienteEstudioResultadoId, actualizarEstudioResultadoDTO);
    }

    @DeleteMapping("/DeletePacienteEstudioResultado/{pacienteEstudioResultadoId}")
    public ApiResponse destroy(@PathVariable Long pacienteEstudioResultadoId) {
        return estudioResultadoService.deleteEstudioResultado(pacienteEstudioResultadoId);
    }

     */

}