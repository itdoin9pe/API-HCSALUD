package com.saludsystem.infrastructure.rest.controller.paciente.historialclinico;

import com.saludsystem.application.dto.get.historialclinico.ConsultaDTO;
import com.saludsystem.application.dto.post.historialclinico.CrearConsultaDTO;
import com.saludsystem.application.dto.put.historialclinico.ActualizarConsultaDTO;
import com.saludsystem.infrastructure.adapters.in.response.historialclinico.ConsultaListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesConsultas")
@RestController
@RequestMapping("/api/Pacientes/Consultas")
public class ConsultaController extends GenericController<ConsultaDTO, CrearConsultaDTO, ActualizarConsultaDTO, UUID> {

    protected ConsultaController(
            GenericService<ConsultaDTO, CrearConsultaDTO, ActualizarConsultaDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ConsultaListResponse.class)))
    })
    public ListResponse<ConsultaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}