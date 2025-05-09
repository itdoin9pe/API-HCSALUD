package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.ExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearExploracionFisicaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarExploracionFisicaDTO;
import com.saludSystem.application.services.Paciente.HistorialClinico.ExploracionFisicaService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesExploraciones")
@RestController
@RequestMapping("/api/PacientesExploraciones")
public class ExploracionFisicaController {

    private final ExploracionFisicaService exploracionFisicaService;

    public ExploracionFisicaController(ExploracionFisicaService exploracionFisicaService) {
        this.exploracionFisicaService = exploracionFisicaService;
    }

    @PostMapping("/SavePacienteExploracion")
    public ApiResponse stored(@Valid @RequestBody CrearExploracionFisicaDTO crearExploracionFisicaDTO) {
        return exploracionFisicaService.saveExploracionFisica(crearExploracionFisicaDTO);
    }

    @GetMapping("/GetAllPacienteExploracion")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExploracionFisicaDTO.class)))
    })
    public ListResponse<ExploracionFisicaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return exploracionFisicaService.getAllExploracionFisica(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteExploracion/{pacienteExploracionId}")
    public ExploracionFisicaDTO getById(@PathVariable UUID pacienteExploracionId) {
        return exploracionFisicaService.getExploracionFisicaById(pacienteExploracionId);
    }

    @PutMapping("/UpdatePacienteExploracion/{pacienteExploracionId}")
    public ApiResponse update(@PathVariable UUID pacienteExploracionId, @RequestBody ActualizarExploracionFisicaDTO actualizarExploracionFisicaDTO) {
        return exploracionFisicaService.updateExploracionFisica(pacienteExploracionId, actualizarExploracionFisicaDTO);
    }

    @DeleteMapping("/DeletePacienteExploracion/{pacienteExploracionId}")
    public ApiResponse destroy(@PathVariable UUID pacienteExploracionId) {
        return exploracionFisicaService.deleteExploracionFisica(pacienteExploracionId);
    }

}