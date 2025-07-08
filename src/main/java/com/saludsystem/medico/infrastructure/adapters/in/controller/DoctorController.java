package com.saludsystem.medico.infrastructure.adapters.in.controller;

import com.saludsystem.medico.application.dto.ActualizarDoctorDTO;
import com.saludsystem.medico.application.dto.CrearDoctorDTO;
import com.saludsystem.medico.application.dto.DoctorDTO;
import com.saludsystem.medico.application.service.DoctorService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.medico.domain.model.DoctorEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.medico.infrastructure.adapters.in.response.DoctorListResponse;
import com.saludsystem.medico.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.shared.infrastructure.security.util.FileStorageService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Tag(name = "Medicos")
@RestController
@RequestMapping("/api/Medicos")
public class DoctorController {

    private final DoctorService doctorService;
    private final FileStorageService fileStorageService;
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorService doctorService, FileStorageService fileStorageService, DoctorRepository doctorRepository) {
        this.doctorService = doctorService;
        this.fileStorageService = fileStorageService;
        this.doctorRepository = doctorRepository;
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PostMapping(value = "/SaveDoctor", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> saveDoctor(String tipoDocumento, String numeroDocumento, String apellidos,
             String nombres, String direccion, String correo, String abreviatura, String rne, @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaNacimiento,
             String celular, String telefono, String sexo, UUID especialidadId, String colegiatura, String color,
             Integer estado, MultipartFile fotoDoctor, MultipartFile fotoFirma) throws IOException {
        String photoDoctor = fileStorageService.storeFile(fotoDoctor);
        String photoFirma = fileStorageService.storeFile(fotoFirma);
        CrearDoctorDTO crearDoctorDTO = new CrearDoctorDTO();
        crearDoctorDTO.setTipoDocumento(tipoDocumento);
        crearDoctorDTO.setNumeroDocumento(numeroDocumento);
        crearDoctorDTO.setApellidos(apellidos);
        crearDoctorDTO.setNombres(nombres);
        crearDoctorDTO.setDireccion(direccion);
        crearDoctorDTO.setCorreo(correo);
        crearDoctorDTO.setAbreviatura(abreviatura);
        crearDoctorDTO.setRne(rne);
        crearDoctorDTO.setFechaNacimiento(fechaNacimiento);
        crearDoctorDTO.setCelular(celular);
        crearDoctorDTO.setTelefono(telefono);
        crearDoctorDTO.setSexo(sexo);
        crearDoctorDTO.setEspecialidadId(especialidadId);
        crearDoctorDTO.setColegiatura(colegiatura);
        crearDoctorDTO.setColor(color);
        crearDoctorDTO.setEstado(estado);
        crearDoctorDTO.setFotoDoctor(photoDoctor);
        crearDoctorDTO.setFotoFirma(photoFirma);
        doctorService.saveDoctor(crearDoctorDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Doctor creado correctamente"));
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PutMapping(value = "/UpdateDoctor/{doctorId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> updateDoctor(
            @PathVariable("doctorId") UUID doctorId, String tipoDocumento, String numeroDocumento, String apellidos,
            String nombres, String direccion, String correo, String abreviatura, String rne,
            @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaNacimiento, String celular, String telefono,
            String sexo, UUID especialidadId, String colegiatura, String color, Integer estado,
            MultipartFile fotoDoctor, MultipartFile fotoFirma) throws IOException {
        ActualizarDoctorDTO actualizarDoctorDTO = new ActualizarDoctorDTO();
        actualizarDoctorDTO.setTipoDocumento(tipoDocumento);
        actualizarDoctorDTO.setNumeroDocumento(numeroDocumento);
        actualizarDoctorDTO.setApellidos(apellidos);
        actualizarDoctorDTO.setNombres(nombres);
        actualizarDoctorDTO.setDireccion(direccion);
        actualizarDoctorDTO.setCorreo(correo);
        actualizarDoctorDTO.setAbreviatura(abreviatura);
        actualizarDoctorDTO.setRne(rne);
        actualizarDoctorDTO.setFechaNacimiento(fechaNacimiento);
        actualizarDoctorDTO.setCelular(celular);
        actualizarDoctorDTO.setTelefono(telefono);
        actualizarDoctorDTO.setSexo(sexo);
        actualizarDoctorDTO.setEspecialidadId(especialidadId);
        actualizarDoctorDTO.setColegiatura(colegiatura);
        actualizarDoctorDTO.setColor(color);
        actualizarDoctorDTO.setEstado(estado);
        if (fotoDoctor != null && !fotoDoctor.isEmpty()) {
            DoctorEntity doctorExistente = doctorRepository.findById(doctorId).orElseThrow();
            if (doctorExistente.getFotoDoctor() != null) {
                fileStorageService.deleteFile(doctorExistente.getFotoDoctor());
            }
            String nuevaFotoDoctor = fileStorageService.storeFile(fotoDoctor);
            actualizarDoctorDTO.setFotoDoctor(nuevaFotoDoctor);
        }
        if (fotoFirma != null && !fotoFirma.isEmpty()) {
            DoctorEntity doctorExistente = doctorRepository.findById(doctorId).orElseThrow();
            if (doctorExistente.getFotoFirma() != null) {
                fileStorageService.deleteFile(doctorExistente.getFotoFirma());
            }
            String nuevaFotoFirma = fileStorageService.storeFile(fotoFirma);
            actualizarDoctorDTO.setFotoFirma(nuevaFotoFirma);
        }
        doctorService.updateDoctor(doctorId, actualizarDoctorDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Doctor actualizado correctamente"));
    }

    @GetMapping("/GetAllDoctor")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DoctorListResponse.class)))
    })
    public ListResponse<DoctorDTO> getAllDoctor(@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
                                                @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return doctorService.getAllDoctor(hospitalId, page, rows);
    }

    @GetMapping("/GetDoctorList")
    public ResponseEntity<List<DoctorDTO>> getAllList() {
        return ResponseEntity.ok(doctorService.getDoctorList());
    }

    @GetMapping("/GetDoctor/{doctorId}")
    public ResponseEntity<DoctorDTO> getById(@PathVariable UUID doctorId) {
        return doctorService.getDoctorById(doctorId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/DeleteDoctor/{doctorId}")
    public ResponseEntity<ApiResponse> destroy(@PathVariable UUID doctorId) {
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.ok(new ApiResponse(true, "Doctor eliminado correctamente."));
    }
}