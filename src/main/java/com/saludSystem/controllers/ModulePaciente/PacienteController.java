package com.saludSystem.controllers.ModulePaciente;

import com.saludSystem.entities.Paciente;
import com.saludSystem.repositories.modules.Paciente.PacienteRepository;
import com.saludSystem.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class PacienteController {
    private final AuthService authService;

    @Autowired
    private PacienteRepository pacienteRepository;


    @Autowired
    public PacienteController(AuthService authService) {
        this.authService = authService;
    }

    public ResponseEntity<Paciente> create(@Valid @RequestBody Paciente paciente){
        return new ResponseEntity<>(pacienteRepository.save(paciente), HttpStatus.CREATED);
    }
}
