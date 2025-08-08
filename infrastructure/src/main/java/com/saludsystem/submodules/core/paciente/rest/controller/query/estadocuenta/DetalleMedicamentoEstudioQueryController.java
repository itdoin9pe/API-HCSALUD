package com.saludsystem.submodules.core.paciente.rest.controller.query.estadocuenta;

import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.DetalleMedicamentoEstudioDTO;
import com.saludsystem.submodules.paciente.query.getAll.estadocuenta.DetalleMedicamentoEstudioAllHandler;
import com.saludsystem.submodules.paciente.query.getById.estadocuenta.DetalleMedicamentoEstudioByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.estadocuenta.DetalleMedicamentoEstudioListHandler;
import com.saludsystem.submodules.paciente.response.estadocuenta.DetalleMedicamentoEstudioListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasEstudiosDetallesMedicamentos")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/EstudiosDetallesMedicamentos")
public class DetalleMedicamentoEstudioQueryController {

    private final DetalleMedicamentoEstudioListHandler listHandler;
    private final DetalleMedicamentoEstudioByIdHandler byIdHandler;
    private final DetalleMedicamentoEstudioAllHandler allHandler;

    public DetalleMedicamentoEstudioQueryController(DetalleMedicamentoEstudioListHandler listHandler, DetalleMedicamentoEstudioByIdHandler byIdHandler, DetalleMedicamentoEstudioAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<DetalleMedicamentoEstudioDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public DetalleMedicamentoEstudioDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DetalleMedicamentoEstudioListResponse.class)))
    })
    public ListResponse<DetalleMedicamentoEstudioDTO> getAllPaginated(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }


}