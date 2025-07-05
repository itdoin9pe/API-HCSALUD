package com.saludsystem.infrastructure.adapters.in.controllers.paciente.EstadoCuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.PagoDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearPagoDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.estadocuenta.ActualizarPagoDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.paciente.EstadoCuenta.PagoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasPagos")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/Pagos")
public class PagoController extends GenericController<PagoDTO, UUID, CrearPagoDTO, ActualizarPagoDTO> {

    protected PagoController(GenericService<PagoDTO, UUID, CrearPagoDTO, ActualizarPagoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PagoResponse.class)))
    })
    public ListResponse<PagoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}