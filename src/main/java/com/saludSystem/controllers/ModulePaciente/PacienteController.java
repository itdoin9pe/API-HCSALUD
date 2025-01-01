package com.saludSystem.controllers.ModulePaciente;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.Paciente;
import com.saludSystem.services.modules.Paciente.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth/Pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/SavePaciente")
    public ResponseEntity<Paciente> savePaciente(@RequestBody @Valid CrearPacienteDTO crearPacienteDTO) {
        Paciente paciente = pacienteService.savePaciente(crearPacienteDTO);
        return ResponseEntity.ok(paciente);
    }
}
