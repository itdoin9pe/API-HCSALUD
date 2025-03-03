package com.saludSystem.infraestructura.controllers.ModuleConfiguracion;

import com.saludSystem.aplicacion.dtos.Configuracion.Rol.ActualizarRolDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Rol.CrearRolDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.Rol.RolDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.Configuracion.RolResponse;
import com.saludSystem.aplicacion.responses.ListResponse;
import com.saludSystem.aplicacion.services.modules.Configuracion.Rol.RolService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Roles")
@RestController
@RequestMapping("/api/Roles")
public class RoleController {

    private final RolService rolService;

    public RoleController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping("/SaveRol")
    public ApiResponse stored(@Valid @RequestBody CrearRolDTO crearRolDTO) {
        return rolService.saveRole(crearRolDTO);
    }

    @GetMapping("/GetAllRol")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RolResponse.class)))
    })
    public ListResponse<RolDTO> getAllPage(@RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return rolService.getAllRole(hospitalId, page, rows);
    }

    @GetMapping("/GetRol/{roleId}")
    public RolDTO getById(@PathVariable UUID roleId) {
        return rolService.getRoleById(roleId);
    }

    @PutMapping("/UpdateRol/{roleId}")
    public ApiResponse update(@PathVariable UUID roleId, @RequestBody ActualizarRolDTO actualizarRolDTO) {
        return rolService.updateRole(roleId, actualizarRolDTO);
    }

    @DeleteMapping("/DeleteRol/{roleId}")
    public ApiResponse destroy(@PathVariable UUID roleId) {
        return rolService.deleteRole(roleId);
    }

    @GetMapping("/GetRoleList")
    public ResponseEntity<List<RolDTO>> getAllList() {
        return ResponseEntity.ok(rolService.getRoleList());
    }

}