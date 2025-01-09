package com.saludSystem.controllers.ModulePaciente;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.services.modules.Paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/Pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/SavePaciente")
    public ResponseEntity<Map<String, Object>> savePaciente(
            @RequestParam("TipoDocumentoId") String tipoDocumentoId,
            @RequestParam("NumeroDocumento") String numeroDocumento,
            @RequestParam("Apellidos") String apellidos,
            @RequestParam("Nombres") String nombres,
            @RequestParam("FechaNacimiento") String fechaNacimiento,
            @RequestParam("Edad") Integer edad,
            @RequestParam("Estado") Integer estado,
            @RequestParam("Ocupacion") String ocupacion,
            @RequestParam("Direccion") String direccion,
            @RequestParam("PaisId") Integer paisId,
            @RequestParam("Ubigeo") String ubigeo,
            @RequestParam("TipoPacienteId") Integer tipoPacienteId,
            @RequestParam("EstadoCivil") String estadoCivil,
            @RequestParam("Sexo") String sexo,
            @RequestParam("NombreContacto") String nombreContacto,
            @RequestParam("TipoHistoria") String tipoHistoria,
            @RequestParam("AseguradoraId") String aseguradoraId,
            @RequestParam("EmpresaId") String empresaId,
            @RequestParam("Email") String email,
            @RequestParam("FotoPaciente") MultipartFile fotoPaciente,
            @RequestParam("Titulo") String titulo,
            @RequestParam("Observacion") String observacion,
            @RequestParam("InformacionClinicaId") String informacionClinicaId,
            @RequestParam("EstudioId") String estudioId,
            @RequestParam("SedeId") String sedeId,
            @RequestParam("Celular") String celular
    ) {
        try {
            // Guardar la imagen en el servidor
            String uploadDir = "uploads/";
            Path path = Paths.get(uploadDir);

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            String fileName = fotoPaciente.getOriginalFilename();
            File dest = new File(uploadDir + fileName);
            fotoPaciente.transferTo(dest);

            // Simular guardado en la base de datos
            Map<String, Object> response = new HashMap<>();
            response.put("isSuccess", true);
            response.put("message", "Paciente creado con éxito");

            return ResponseEntity.ok(response);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                    "isSuccess", false,
                    "message", "Error al guardar la imagen: " + e.getMessage()
            ));
        }
    }


    // Método para convertir MultipartFile a String (Base64)
    private String convertirArchivoAStringBase64(MultipartFile archivo) throws IOException {
        byte[] bytes = archivo.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    @GetMapping("/images/{filename}")
    public ResponseEntity<FileSystemResource> getImage(@PathVariable String filename) {
        File imageFile = new File("uploads/" + filename);
        if (imageFile.exists()) {
            return ResponseEntity.ok(new FileSystemResource(imageFile));
        }
        return ResponseEntity.notFound().build();
    }
}
