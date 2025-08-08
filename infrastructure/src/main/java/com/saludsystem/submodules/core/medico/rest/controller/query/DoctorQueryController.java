package com.saludsystem.submodules.core.medico.rest.controller.query;

import com.saludsystem.submodules.medico.model.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.query.DoctorAllHandler;
import com.saludsystem.submodules.medico.query.DoctorByIdHandler;
import com.saludsystem.submodules.medico.query.DoctorListHandler;
import com.saludsystem.submodules.medico.response.DoctorListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Medicos")
@RestController
@RequestMapping("/api/Medicos")
public class DoctorQueryController {

    private final DoctorAllHandler allHandler;
    private final DoctorByIdHandler byIdHandler;
    private final DoctorListHandler listHandler;

    public DoctorQueryController(DoctorAllHandler allHandler, DoctorByIdHandler byIdHandler, DoctorListHandler listHandler) {
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
        this.listHandler = listHandler;
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DoctorListResponse.class)))
    })
    public ListResponse<DoctorDTO> getAllDoctor(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }

    @GetMapping("/GetList")
    public List<DoctorDTO> getList() {
        return listHandler.execute();
    }

    @GetMapping("/GetDoctor/{doctorId}")
    public DoctorDTO getById(@PathVariable UUID doctorId) {
        return byIdHandler.execute(doctorId);
    }

}
