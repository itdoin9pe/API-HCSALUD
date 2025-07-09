package com.saludsystem.paciente.infrastructure.adapters.in.controller.historialclinico;

import com.saludsystem.paciente.application.dto.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.CrearExploracionFisicaDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.ActualizarExploracionFisicaDTO;
import com.saludsystem.paciente.infrastructure.adapters.in.response.HistorialClinico.ExploracionFisicaListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesExploraciones")
@RestController
@RequestMapping("/api/Pacientes/Exploraciones")
public class ExploracionFisicaController extends GenericController<ExploracionFisicaDTO, CrearExploracionFisicaDTO,
        ActualizarExploracionFisicaDTO, UUID> {

    protected ExploracionFisicaController(GenericService<
            ExploracionFisicaDTO, CrearExploracionFisicaDTO, ActualizarExploracionFisicaDTO, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ExploracionFisicaListResponse.class)))
    })
    public ListResponse<ExploracionFisicaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}