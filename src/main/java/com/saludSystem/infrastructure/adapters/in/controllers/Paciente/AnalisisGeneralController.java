package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisGeneralDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAnalisisGeneralDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAnalisisGeneralDTO;
import com.saludSystem.application.services.Paciente.AnalisisGeneralService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.AnalisisGeneralResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesAnalisisGeneral")
@RestController
@RequestMapping("/api/PacientesAnalisisGeneral")
public class AnalisisGeneralController {

    private final AnalisisGeneralService analisisGeneralService;

    public AnalisisGeneralController(AnalisisGeneralService analisisGeneralService) {
        this.analisisGeneralService = analisisGeneralService;
    }

    @PostMapping("/SavePacienteAnalisisGeneral")
    public ApiResponse stored(@Valid @RequestBody CrearAnalisisGeneralDTO crearAnalisisGeneralDTO) {
        return analisisGeneralService.saveAnalisisGeneral(crearAnalisisGeneralDTO);
    }

    @GetMapping("/GetAllPacienteAnalisisGeneral")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AnalisisGeneralResponse.class)))
    })
    public ListResponse<AnalisisGeneralDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return analisisGeneralService.getAllAnalisisGeneral(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteAnalisisGeneral/{pacienteAnalisisGeneralId}")
    public AnalisisGeneralDTO getById(@PathVariable UUID pacienteAnalisisGeneralId) {
        return analisisGeneralService.getAnalisisGeneralById(pacienteAnalisisGeneralId);
    }

    @PutMapping("/UpdatePacienteAnalisisGeneral/{pacienteAnalisisGeneralId}")
    public ApiResponse update(@PathVariable UUID pacienteAnalisisGeneralId, @RequestBody ActualizarAnalisisGeneralDTO actualizarAnalisisGeneralDTO) {
        return analisisGeneralService.updateAnalisisGeneral(pacienteAnalisisGeneralId, actualizarAnalisisGeneralDTO);
    }

    @DeleteMapping("/DeletePacienteAnalisisGeneral/{pacienteAnalisisGeneralId}")
    public ApiResponse destroy(@PathVariable UUID pacienteAnalisisGeneralId) {
        return analisisGeneralService.deleteAnalisisGeneral(pacienteAnalisisGeneralId);
    }

}