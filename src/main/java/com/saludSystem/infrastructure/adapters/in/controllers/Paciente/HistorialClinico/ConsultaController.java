package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.ConsultaDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearConsultaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarConsultaDTO;
import com.saludSystem.application.services.Paciente.ConsultaService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.HistorialClinico.ConsultaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesConsultas")
@RestController
@RequestMapping("/api/PacientesConsultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/SavePacienteConsulta")
    public ApiResponse stored(@Valid @RequestBody CrearConsultaDTO crearConsultaDTO) {
        return consultaService.saveConsulta(crearConsultaDTO);
    }

    @GetMapping("/GetAllConsulta")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsultaResponse.class)))
    })
    public ListResponse<ConsultaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return consultaService.getAllConsulta(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteConsulta/{pacienteConsultaId}")
    public ConsultaDTO getById(@PathVariable UUID pacienteConsultaId) {
        return consultaService.getConsultaById(pacienteConsultaId);
    }

    @PutMapping("/UpdatePacienteConsulta/{pacienteConsultaId}")
    public ApiResponse update(@PathVariable UUID pacienteConsultaId, @RequestBody ActualizarConsultaDTO actualizarConsultaDTO) {
        return consultaService.updateConsulta(pacienteConsultaId, actualizarConsultaDTO);
    }

    @DeleteMapping("/DeletePacienteConsulta/{pacienteConsultaId}")
    public ApiResponse destroy(@PathVariable UUID pacienteConsultaId) {
        return consultaService.deleteConsulta(pacienteConsultaId);
    }

}