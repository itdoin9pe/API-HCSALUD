package com.saludsystem.infrastructure.web.restclient.configuracion;

import com.configuracion.application.dto.get.SedeDTO;
import com.configuracion.application.dto.post.CrearSedeDTO;
import com.configuracion.application.dto.put.ActualizarSedeDTO;
import com.configuracion.infrastructure.adapters.in.response.SedeListResponse;
import com.configuracion.application.services.GenericService;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Sedes")
@RestController
@RequestMapping("/api/Sedes")
public class SedeController extends GenericController<SedeDTO, CrearSedeDTO, ActualizarSedeDTO, UUID> {

    protected SedeController(GenericService<SedeDTO, CrearSedeDTO, ActualizarSedeDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SedeListResponse.class)))
    })
    public ListResponse<SedeDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}