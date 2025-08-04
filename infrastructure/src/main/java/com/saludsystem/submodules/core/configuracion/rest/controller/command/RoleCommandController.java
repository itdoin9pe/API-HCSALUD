package com.saludsystem.submodules.core.configuracion.rest.controller.command;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Roles")
@RestController
@RequestMapping("/api/Roles")
public class RoleCommandController {

    /*
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
                            schema = @Schema(implementation = RolListResponse.class)))
    })

    public ListResponse<RolDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
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
    }*/
}