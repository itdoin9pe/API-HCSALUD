package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisFacialDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAnalisisFacialDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAnalisisFacialDTO;
import com.saludSystem.application.services.Paciente.AnalisisFacialService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.AnalisisFacialResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Tag(name = "PacientesAnalisisFaciales")
@RestController
@RequestMapping("/api/PacientesAnalisisFaciales")
public class AnalisisFacialController {

    private final AnalisisFacialService analisisFacialService;

    public AnalisisFacialController(AnalisisFacialService analisisFacialService) {
        this.analisisFacialService = analisisFacialService;
    }

    @PostMapping("/SavePacienteAnalisisFacial")
    public ApiResponse stored(@Valid @RequestBody CrearAnalisisFacialDTO crearAnalisisFacialDTO) {
        return analisisFacialService.saveAnalisisFacil(crearAnalisisFacialDTO);
    }

    @GetMapping("/GetAllPacienteAnalisisFacial")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AnalisisFacialResponse.class)))
    })
    public ListResponse<AnalisisFacialDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return analisisFacialService.getAllAnalisisFacial(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteAnalisisFacial/{pacienteAnalisisFacialId}")
    public AnalisisFacialDTO getById(@PathVariable UUID pacienteAnalisisFacialId) {
        return analisisFacialService.getAnalisisFacialById(pacienteAnalisisFacialId);
    }

    @PutMapping("/UpdatePacienteAnalisisFacial/{pacienteAnalisisFacialId}")
    public ApiResponse update(@PathVariable UUID pacienteAnalisisFacialId, @RequestBody ActualizarAnalisisFacialDTO actualizarAnalisisFacialDTO) {
        return analisisFacialService.updateAnalisisFacial(pacienteAnalisisFacialId, actualizarAnalisisFacialDTO);
    }

    @DeleteMapping("/DeletePacienteAnalisisFacial/{pacienteAnalisisFacialId}")
    public ApiResponse destroy(@PathVariable UUID pacienteAnalisisFacialId) {
        return analisisFacialService.deleteAnalisisFacial(pacienteAnalisisFacialId);
    }

}