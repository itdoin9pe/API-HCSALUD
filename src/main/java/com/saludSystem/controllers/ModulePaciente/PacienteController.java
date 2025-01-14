package com.saludSystem.controllers.ModulePaciente;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saludSystem.dtos.ApiResponse;
import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.services.modules.Paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/Pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/SavePaciente")
    public ResponseEntity<?> savePaciente(
            @RequestParam("data") String pacienteData,
            @RequestParam(value = "fotoPaciente", required = false) MultipartFile fotoPaciente
    ) throws IOException {
        // Convertir el JSON del parámetro 'data' a CrearPacienteDTO
        ObjectMapper objectMapper = new ObjectMapper();
        CrearPacienteDTO crearPacienteDTO = objectMapper.readValue(pacienteData, CrearPacienteDTO.class);

        String fotoPacienteBase64 = null;

        // Solo convertir a Base64 si fotoPaciente no es nulo
        if (fotoPaciente != null && !fotoPaciente.isEmpty()) {
            fotoPacienteBase64 = convertirArchivoAStringBase64(fotoPaciente);
        }

        // Llamar al servicio para guardar el paciente
        pacienteService.savePaciente(crearPacienteDTO, fotoPacienteBase64);

        return ResponseEntity.ok().body(
                new ApiResponse(true, "Paciente registrado correctamente")
        );
    }

    @GetMapping("/GetListPaciente")
    public ResponseEntity<List<CrearPacienteDTO>> getListPaciente() {
        return ResponseEntity.ok(pacienteService.getAllPacientes());
    }

    private String convertirArchivoAStringBase64(MultipartFile fotoPaciente) throws IOException {
        if (fotoPaciente == null || fotoPaciente.isEmpty()) {
            throw new IllegalArgumentException("El archivo no puede estar vacío.");
        }

        try {
            byte[] bytes = fotoPaciente.getBytes();
            return Base64.getEncoder().encodeToString(bytes);
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir el archivo a Base64", e);
        }
    }
}
