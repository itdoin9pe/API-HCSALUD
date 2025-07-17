package com.saludsystem.submodules.sections.configuracion.rest.controller.query;

import com.saludsystem.submodules.configuracion.model.dto.UserDto;
import com.saludsystem.submodules.configuracion.query.getAll.UsuarioByIdHandler;
import com.saludsystem.submodules.configuracion.query.getById.UsuarioAllHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Usuarios")
@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioQueryController {
    private final UsuarioByIdHandler byIdHandler;
    private final UsuarioAllHandler allHandler;

    public UsuarioQueryController(UsuarioByIdHandler byIdHandler, UsuarioAllHandler allHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(byIdHandler.execute(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAll(@RequestParam("hospitalId") UUID hospitalId) {
        // Suponiendo que `execute()` acepta hospitalId (ajusta si es necesario)
        return ResponseEntity.ok(allHandler.execute(hospitalId));
    }
}
