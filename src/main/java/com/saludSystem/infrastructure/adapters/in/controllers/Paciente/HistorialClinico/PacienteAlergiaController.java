package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.PacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearPacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarPacienteAlergiaDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.HistorialClinico.PacienteAlergiaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesAlergias")
@RestController
@RequestMapping("/api/Pacientes/Alergias")
public class PacienteAlergiaController extends GenericController<PacienteAlergiaDTO, UUID,
        CrearPacienteAlergiaDTO, ActualizarPacienteAlergiaDTO> {

    protected PacienteAlergiaController(GenericService<PacienteAlergiaDTO, UUID, CrearPacienteAlergiaDTO, ActualizarPacienteAlergiaDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PacienteAlergiaResponse.class)))
    })
    public ListResponse<PacienteAlergiaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}