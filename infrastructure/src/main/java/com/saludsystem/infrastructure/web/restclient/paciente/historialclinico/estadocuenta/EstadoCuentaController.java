package com.saludsystem.infrastructure.web.restclient.paciente.historialclinico.estadocuenta;

import com.saludsystem.application.dto.get.historialclinico.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.application.dto.post.historialclinico.estadocuenta.CrearEstadoCuentaDTO;
import com.saludsystem.application.dto.put.historialclinico.estadocuenta.ActualizarEstadoCuentaDTO;
import com.saludsystem.infrastructure.adapters.in.response.estadocuenta.EstadoCuentaListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentas")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas")
public class EstadoCuentaController extends GenericController<EstadoCuentaDTO, CrearEstadoCuentaDTO,
        ActualizarEstadoCuentaDTO, UUID> {

    protected EstadoCuentaController(
            GenericService<EstadoCuentaDTO, CrearEstadoCuentaDTO, ActualizarEstadoCuentaDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstadoCuentaListResponse.class)))
    })
    public ListResponse<EstadoCuentaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}