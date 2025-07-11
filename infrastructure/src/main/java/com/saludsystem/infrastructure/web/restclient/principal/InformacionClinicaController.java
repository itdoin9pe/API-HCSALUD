package com.saludsystem.infrastructure.web.restclient.principal;

import com.saludsystem.application.dto.get.InformacionClinicaDTO;
import com.saludsystem.application.dto.post.CrearInformacionClinicaDTO;
import com.saludsystem.application.dto.put.ActualizarInformacionClinicaDTO;
import com.saludsystem.infrastructure.adapters.in.response.InformacionClinicaListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "InformacionClinicas")
@RestController
@RequestMapping("/api/InformacionClinicas")
public class InformacionClinicaController extends GenericController<InformacionClinicaDTO, CrearInformacionClinicaDTO,
        ActualizarInformacionClinicaDTO, UUID> {

    protected InformacionClinicaController(GenericService<
                InformacionClinicaDTO, CrearInformacionClinicaDTO, ActualizarInformacionClinicaDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = InformacionClinicaListResponse.class)))
    })
    public ListResponse<InformacionClinicaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}