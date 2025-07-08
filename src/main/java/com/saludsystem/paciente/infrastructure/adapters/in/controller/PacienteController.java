package com.saludsystem.paciente.infrastructure.adapters.in.controller;

import com.saludsystem.paciente.application.dto.res.PacienteResponse;
import com.saludsystem.paciente.application.dto.req.PacienteRequest;
import com.saludsystem.paciente.application.dto.ActualizarPacienteDTO;
import com.saludsystem.paciente.application.service.PacienteService;
import com.saludsystem.paciente.infrastructure.adapters.in.response.PacienteListResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.shared.infrastructure.security.util.FileStorageService;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
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
import java.util.*;

@Tag(name = "Pacientes")
@RestController
@RequestMapping("/api/Pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final FileStorageService fileStorageService;
    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteService pacienteService, FileStorageService fileStorageService, PacienteRepository pacienteRepository) {
        this.pacienteService = pacienteService;
        this.fileStorageService = fileStorageService;
        this.pacienteRepository = pacienteRepository;
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PostMapping(value = "/SavePaciente", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> crearPaciente
            (String tipoDocumentoId, String numeroDocumento, String apellidos, String nombres, @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaNacimiento,
            Integer edad, Integer estado, String ocupacion, String direccion, Integer paisId, String ubigeo,
            Long tipoPacienteId, String estadoCivil, String sexo, String nombreContacto, String tipoHistoria, UUID aseguradoraId,
            UUID empresaId, String email, String titulo, String observacion, MultipartFile fotoPaciente,
            UUID informacionClinicaId, UUID estudioId, UUID sedeId, String celular) throws IOException {
        String photoPaciente = fileStorageService.storeFile(fotoPaciente);
        PacienteRequest pacienteRequest = new PacienteRequest();
        pacienteRequest.setTipoDocumentoId(tipoDocumentoId);
        pacienteRequest.setNumeroDocumento(numeroDocumento);
        pacienteRequest.setApellidos(apellidos);
        pacienteRequest.setNombres(nombres);
        pacienteRequest.setFechaNacimiento(fechaNacimiento);
        pacienteRequest.setEdad(edad);
        pacienteRequest.setEstado(estado);
        pacienteRequest.setOcupacion(ocupacion);
        pacienteRequest.setDireccion(direccion);
        pacienteRequest.setPaisId(paisId);
        pacienteRequest.setUbigeo(ubigeo);
        pacienteRequest.setTipoPacienteId(tipoPacienteId);
        pacienteRequest.setEstadoCivil(estadoCivil);
        pacienteRequest.setSexo(sexo);
        pacienteRequest.setNombreContacto(nombreContacto);
        pacienteRequest.setTipoHistoria(tipoHistoria);
        pacienteRequest.setAseguradoraId(aseguradoraId);
        pacienteRequest.setEmpresaId(empresaId);
        pacienteRequest.setEmail(email);
        pacienteRequest.setFotoPaciente(photoPaciente);
        pacienteRequest.setTitulo(titulo);
        pacienteRequest.setObservacion(observacion);
        pacienteRequest.setInformacionClinicaId(informacionClinicaId);
        pacienteRequest.setEstudioId(estudioId);
        pacienteRequest.setSedeId(sedeId);
        pacienteRequest.setCelular(celular);
        pacienteService.savePaciente(pacienteRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Paciente creado correctamente"));
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PutMapping(value = "/UpdatePaciente/{pacienteId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> actualizarPaciente
            (@PathVariable("pacienteId") UUID pacienteId, String tipoDocumentoId, String numeroDocumento, String apellidos,
             String nombres, @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaNacimiento, Integer edad, Integer estado, String ocupacion, String direccion,
             Integer paisId, String ubigeo, Long tipoPacienteId, String estadoCivil, String sexo, String nombreContacto,
             String tipoHistoria, UUID aseguradoraId,  UUID empresaId, String email, String titulo, String observacion,
             UUID informacionClinicaId, UUID estudioId,  UUID sedeId, MultipartFile fotoPaciente, String celular) throws IOException {
        ActualizarPacienteDTO actualizarPacienteDTO = new ActualizarPacienteDTO();
        actualizarPacienteDTO.setTipoDocumentoId(tipoDocumentoId);
        actualizarPacienteDTO.setNumeroDocumento(numeroDocumento);
        actualizarPacienteDTO.setApellidos(apellidos);
        actualizarPacienteDTO.setNombres(nombres);
        actualizarPacienteDTO.setFechaNacimiento(fechaNacimiento);
        actualizarPacienteDTO.setEdad(edad);
        actualizarPacienteDTO.setEstado(estado);
        actualizarPacienteDTO.setOcupacion(ocupacion);
        actualizarPacienteDTO.setDireccion(direccion);
        actualizarPacienteDTO.setPaisId(paisId);
        actualizarPacienteDTO.setUbigeo(ubigeo);
        actualizarPacienteDTO.setTipoPacienteId(tipoPacienteId);
        actualizarPacienteDTO.setEstadoCivil(estadoCivil);
        actualizarPacienteDTO.setSexo(sexo);
        actualizarPacienteDTO.setNombreContacto(nombreContacto);
        actualizarPacienteDTO.setTipoHistoria(tipoHistoria);
        actualizarPacienteDTO.setAseguradoraId(aseguradoraId);
        actualizarPacienteDTO.setEmpresaId(empresaId);
        actualizarPacienteDTO.setEmail(email);
        if (fotoPaciente != null && !fotoPaciente.isEmpty()) {
            PacienteEntity pacienteExistente = pacienteRepository.findById(pacienteId).orElseThrow();
            if (pacienteExistente.getFotoPaciente() != null) {
                fileStorageService.deleteFile(pacienteExistente.getFotoPaciente());
            }
            String nuevaFotoPaciente = fileStorageService.storeFile(fotoPaciente);
            actualizarPacienteDTO.setFotoPaciente(nuevaFotoPaciente);
        }
        actualizarPacienteDTO.setTitulo(titulo);
        actualizarPacienteDTO.setObservacion(observacion);
        actualizarPacienteDTO.setInformacionClinicaId(informacionClinicaId);
        actualizarPacienteDTO.setEstudioId(estudioId);
        actualizarPacienteDTO.setSedeId(sedeId);
        actualizarPacienteDTO.setCelular(celular);
        pacienteService.updatePaciente(pacienteId, actualizarPacienteDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Paciente actualizado correctamente"));
    }

    @GetMapping("/GetAllPaciente")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PacienteListResponse.class)))
    })
    public ListResponse<PacienteResponse> obtenerPacientesPaginados(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return pacienteService.getAllPaciente(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteList")
    public ResponseEntity<List<PacienteResponse>> obtenerPacientes() {
        return ResponseEntity.ok(pacienteService.getPacienteList());
    }

    @GetMapping("/GetPaciente/{pacienteId}")
    public ResponseEntity<PacienteResponse> obtenerPacientesPorId(@PathVariable UUID pacienteId) {
        return pacienteService.getPacienteById(pacienteId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/DeletePaciente/{pacienteId}")
    public ApiResponse eliminarPaciente(@PathVariable UUID pacienteId) {
        return pacienteService.deletePaciente(pacienteId);
    }
}