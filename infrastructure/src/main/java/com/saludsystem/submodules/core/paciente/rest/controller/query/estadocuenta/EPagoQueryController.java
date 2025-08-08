package com.saludsystem.submodules.core.paciente.rest.controller.query.estadocuenta;

import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EPagoDTO;
import com.saludsystem.submodules.paciente.query.getAll.estadocuenta.EPagoAllHandler;
import com.saludsystem.submodules.paciente.query.getById.estadocuenta.EPagoByIdHandler;
import com.saludsystem.submodules.paciente.query.getList.estadocuenta.EPagoListHandler;
import com.saludsystem.submodules.paciente.response.estadocuenta.EPagoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Tag(name = "PacientesEstadosCuentasPagos")
@RestController
@RequestMapping("/api/Pacientes/EstadosCuentas/Pagos")
public class EPagoQueryController {

    private final EPagoListHandler listHandler;
    private final EPagoByIdHandler byIdHandler;
    private final EPagoAllHandler allHandler;

    public EPagoQueryController(EPagoListHandler listHandler, EPagoByIdHandler byIdHandler, EPagoAllHandler allHandler) {
        this.listHandler = listHandler;
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetList")
    public List<EPagoDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetById/{id}")
    public EPagoDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EPagoListResponse.class)))
    })
    public ListResponse<EPagoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

}