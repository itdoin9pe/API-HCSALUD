package com.saludsystem.infrastructure.web.restclient.paciente.historialclinico;

import com.saludsystem.application.dto.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.application.dto.post.historialclinico.CrearExploracionFisicaDTO;
import com.saludsystem.application.dto.put.historialclinico.ActualizarExploracionFisicaDTO;
import com.saludsystem.infrastructure.adapters.in.response.historialclinico.ExploracionFisicaListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
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

    @Override
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