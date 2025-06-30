package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.ConsultaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearConsultaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarConsultaDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.HistorialClinico.ConsultaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesConsultas")
@RestController
@RequestMapping("/api/Pacientes/Consultas")
public class ConsultaController extends GenericController<ConsultaDTO, UUID, CrearConsultaDTO, ActualizarConsultaDTO> {

    protected ConsultaController(GenericService<ConsultaDTO, UUID, CrearConsultaDTO,
            ActualizarConsultaDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsultaResponse.class)))
    })
    public ListResponse<ConsultaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}