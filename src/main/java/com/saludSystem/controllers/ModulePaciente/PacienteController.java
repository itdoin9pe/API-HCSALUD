package com.saludSystem.controllers.ModulePaciente;

import com.saludSystem.entities.Paciente;
import com.saludSystem.entities.User;
import com.saludSystem.services.UserService;
import com.saludSystem.services.modules.Paciente.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class PacienteController {

    private final PacienteService pacienteService;
    private final UserService userService;


    public PacienteController(PacienteService pacienteService, UserService userService) {
        this.pacienteService = pacienteService;
        this.userService = userService;
    }

    @PostMapping("/Paciente/CrearPaciente")
    public ResponseEntity<Map<String, Object>> createPaciente(
            @Valid @RequestBody Paciente paciente,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Check the fields!!"));
        }

        try {
            // Obtener el usuario autenticado
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User createdBy = userService.findEntityByUsername(username);

            // Asignar el usuario creador al paciente
            paciente.setCreatedBy(createdBy);

            // Guardar el paciente
            Paciente nuevoPaciente = pacienteService.createPaciente(paciente);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Paciente creado con éxito");
            response.put("paciente", nuevoPaciente);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", e.getMessage()));
        }
    }
}
