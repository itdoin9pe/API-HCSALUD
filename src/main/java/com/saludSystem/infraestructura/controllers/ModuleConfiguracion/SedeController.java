package com.saludSystem.infraestructura.controllers.ModuleConfiguracion;

import com.saludSystem.aplicacion.dtos.Configuracion.Sede.ActualizarSedeDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Sede.CrearSedeDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Sede.SedeDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.Configuracion.SedeResponse;
import com.saludSystem.aplicacion.responses.ListResponse;
import com.saludSystem.aplicacion.services.modules.Configuracion.Sede.SedeService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Sedes")
@RestController
@RequestMapping("/api/Sedes")
public class SedeController {

    private final SedeService sedeService;

    public SedeController(SedeService sedeService){
        this.sedeService = sedeService;
    }

    @PostMapping("/SaveSede")
    public ApiResponse stored(@Valid @RequestBody CrearSedeDTO crearSedeDTO){
        return sedeService.saveSede(crearSedeDTO);
    }

    @GetMapping("/GetAllSede")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SedeResponse.class)))
    })
    public ListResponse<SedeDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return sedeService.getAllEmpresa(hospitalId, page, rows);
    }

    @PutMapping("/UpdateSede/{sedeId}")
    public ApiResponse update(@PathVariable UUID sedeId, @RequestBody ActualizarSedeDTO actualizarSedeDTO) {
        return sedeService.updateSede(sedeId, actualizarSedeDTO);
    }

    @DeleteMapping("/DeleteSede/{sedeId}")
    public ApiResponse destroy(@PathVariable UUID sedeId){
        return sedeService.deleteSede(sedeId);
    }

    @GetMapping("/GetSede/{sedeId}")
    public SedeDTO getById(@PathVariable UUID sedeId){
        return sedeService.getSedeById(sedeId);
    }

    @GetMapping("/GetSedeList")
    public ResponseEntity<List<SedeDTO>> getAllList() {
        return ResponseEntity.ok(sedeService.getSedeList());
    }

}