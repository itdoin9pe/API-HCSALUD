package com.saludSystem.infrastructure.controllers.Generals;

/*
import com.saludSystem.dtos.Generals.Estudio.ActualizarEstudioDTO;
import com.saludSystem.dtos.Generals.Estudio.CrearEstudioDTO;
import com.saludSystem.dtos.Generals.Estudio.EstudioDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Generals.EstudioResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.services.modules.Generals.Estudios.EstudioService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Tag(name = "Estudios")
@RestController
@RequestMapping("/api/Estudios")
public class EstudioController {

    private final EstudioService estudioService;

    public EstudioController(EstudioService estudioService){
        this.estudioService = estudioService;
    }

    @PostMapping("/SaveEstudio")
    public ResponseEntity<ApiResponse> store(@Valid @RequestBody CrearEstudioDTO crearEstudioDTO)
    {
        estudioService.saveEstudio(crearEstudioDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Estudio creado con exito"));
    }

    @GetMapping("/GetAllEstudio")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstudioResponse.class)))
    })
    public ListResponse<EstudioDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows) {
        return estudioService.getAllEstudios(hospitalId, page, rows);
    }

    @GetMapping("/GetEstudioList")
    public ResponseEntity<List<EstudioDTO>> getAllList(){
        return ResponseEntity.ok(estudioService.getEstudioList());
    }

    @GetMapping("GetEstudio/{estudioId}")
    public EstudioDTO getEstudioById(@PathVariable UUID estudioId) {
        return estudioService.getEstudioById(estudioId);
    }

    @PutMapping("/UpdateEstudio/{estudioId}")
    public ApiResponse updated(@PathVariable UUID estudioId, @RequestBody ActualizarEstudioDTO actualizarEstudioDTO)  {
        return estudioService.updateEstudio(estudioId, actualizarEstudioDTO);
    }

    @DeleteMapping("/DeleteEstudio/{estudioId}")
    public ApiResponse destroy(@PathVariable UUID estudioId) {
        return estudioService.deleteEstudio(estudioId);
    }

}

 */