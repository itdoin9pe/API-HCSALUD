package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.AntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearAntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarAntecedenteDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.HistorialClinico.AntecedenteResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Tag(name = "PacientesEnfermedadesActuales")
@RestController
@RequestMapping("/api/Pacientes/EnfermedadesActuales")
public class AntecedentesController extends GenericController<AntecedenteDTO, UUID,
        CrearAntecedenteDTO, ActualizarAntecedenteDTO> {

    protected AntecedentesController(GenericService<AntecedenteDTO, UUID, CrearAntecedenteDTO, ActualizarAntecedenteDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AntecedenteResponse.class)))
    })
    public ListResponse<AntecedenteDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}