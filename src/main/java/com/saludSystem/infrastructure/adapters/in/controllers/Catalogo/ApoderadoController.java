package com.saludSystem.infrastructure.adapters.in.controllers.Catalogo;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ApoderadoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearApoderadoDTO;
import com.saludSystem.application.services.GenericService;
import com.saludSystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Apoderados")
@RestController
@RequestMapping("/api/Apoderados")
public class ApoderadoController extends GenericController<
        ApoderadoDTO,
        UUID,
        CrearApoderadoDTO,
        ActualizarApoderadoDTO> {

    protected ApoderadoController(GenericService<ApoderadoDTO, UUID,
            CrearApoderadoDTO, ActualizarApoderadoDTO> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApoderadoDTO.class)))
    })
    public ListResponse<ApoderadoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

}