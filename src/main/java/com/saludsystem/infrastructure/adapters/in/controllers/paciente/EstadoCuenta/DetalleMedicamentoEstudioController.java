package com.saludsystem.infrastructure.adapters.in.controllers.paciente.EstadoCuenta;

import com.saludsystem.application.dtos.paciente.get.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dtos.paciente.post.estadocuenta.CrearDetalleMedicamentoEstudioDTO;
import com.saludsystem.application.dtos.paciente.put.estadocuenta.ActualizarDetalleMedicamentoEstudioDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.paciente.EstadoCuenta.DetalleMedicamentoEstudioResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasEstudiosDetallesMedicamentos")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/EstudiosDetallesMedicamentos")
public class DetalleMedicamentoEstudioController extends GenericController<DetalleMedicamentoEstudioDTO,
        UUID, CrearDetalleMedicamentoEstudioDTO, ActualizarDetalleMedicamentoEstudioDTO> {

    protected DetalleMedicamentoEstudioController(GenericService<DetalleMedicamentoEstudioDTO, UUID,
            CrearDetalleMedicamentoEstudioDTO, ActualizarDetalleMedicamentoEstudioDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DetalleMedicamentoEstudioResponse.class)))
    })
    public ListResponse<DetalleMedicamentoEstudioDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}