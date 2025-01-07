package com.saludSystem.controllers.ModulePaciente;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.Paciente;
import com.saludSystem.services.modules.Paciente.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/Pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/SavePaciente")
    public ResponseEntity<Paciente> savePaciente(
            @RequestPart("data") @Valid CrearPacienteDTO crearPacienteDTO,
            @RequestPart("fotoPaciente") MultipartFile fotoPaciente
    ) {
        Paciente paciente = pacienteService.savePaciente(crearPacienteDTO, fotoPaciente);
        return ResponseEntity.ok(paciente);
    }
}
