package com.saludSystem.controllers.ModulePaciente;

import com.saludSystem.dtos.Paciente.ActualizarPacienteDTO;
import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.dtos.Paciente.PacienteDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.dtos.responses.Paciente.PacienteResponse;
import com.saludSystem.services.modules.Paciente.PacienteService;
import com.saludSystem.util.Util;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;


@Tag(name = "Pacientes")
@RestController
@RequestMapping("/api/Pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/SavePaciente")
    public ResponseEntity<ApiResponse> savePaciente(@Valid
            @RequestParam("fotoPaciente") MultipartFile fotoPaciente,
            @RequestParam("tipoDocumentoId") String tipoDocumentoId,
            @RequestParam("numeroDocumento") String numeroDocumento,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("nombres") String nombres,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaNacimiento,
            @RequestParam("edad") int edad,
            @RequestParam("estado") Integer estado,
            @RequestParam("ocupacion") String ocupacion,
            @RequestParam("direccion") String direccion,
            @RequestParam("paisId") Integer paisId,
            @RequestParam("ubigeo") String ubigeo,
            @RequestParam("tipoPacienteId") Integer tipoPacienteId,
            @RequestParam("estadoCivil") String estadoCivil,
            @RequestParam("sexo") String sexo,
            @RequestParam("nombreContacto") String nombreContacto,
            @RequestParam("tipoHistoria") String tipoHistoria,
            @RequestParam("aseguradoraId") UUID aseguradoraId,
            @RequestParam("empresaId") UUID empresaId,
            @RequestParam("email") String email,
            @RequestParam("titulo") String titulo,
            @RequestParam("observacion") String observacion,
            @RequestParam("informacionClinicaId") UUID informacionClinicaId,
            @RequestParam("estudioId") UUID estudioId,
            @RequestParam("sedeId") UUID sedeId,
            @RequestParam("celular") String celular) throws IOException {

        CrearPacienteDTO crearPacienteDTO = new CrearPacienteDTO();
        crearPacienteDTO.setTipoDocumentoId(tipoDocumentoId);
        crearPacienteDTO.setNumeroDocumento(numeroDocumento);
        crearPacienteDTO.setApellidos(apellidos);
        crearPacienteDTO.setNombres(nombres);
        crearPacienteDTO.setFechaNacimiento(fechaNacimiento);
        crearPacienteDTO.setEdad(edad);
        crearPacienteDTO.setEstado(estado);
        crearPacienteDTO.setOcupacion(ocupacion);
        crearPacienteDTO.setDireccion(direccion);
        crearPacienteDTO.setPaisId(paisId);
        crearPacienteDTO.setUbigeo(ubigeo);
        crearPacienteDTO.setTipoPacienteId(tipoPacienteId);
        crearPacienteDTO.setEstadoCivil(estadoCivil);
        crearPacienteDTO.setSexo(sexo);
        crearPacienteDTO.setNombreContacto(nombreContacto);
        crearPacienteDTO.setTipoHistoria(tipoHistoria);
        crearPacienteDTO.setAseguradoraId(aseguradoraId);
        crearPacienteDTO.setEmpresaId(empresaId);
        crearPacienteDTO.setEmail(email);
        crearPacienteDTO.setFotoPaciente(Util.compressZLib(fotoPaciente.getBytes()));
        crearPacienteDTO.setTitulo(titulo);
        crearPacienteDTO.setObservacion(observacion);
        crearPacienteDTO.setInformacionClinicaId(informacionClinicaId);
        crearPacienteDTO.setEstudioId(estudioId);
        crearPacienteDTO.setSedeId(sedeId);
        crearPacienteDTO.setCelular(celular);
        pacienteService.savePaciente(crearPacienteDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Paciente creado correctamente"));
    }

    @PutMapping("/UpdatePaciente/{pacienteId}")
    public ResponseEntity<ApiResponse> updatePaciente(
            @PathVariable("pacienteId") UUID pacienteId,
            @Valid @RequestParam(value = "fotoPaciente", required = false) MultipartFile fotoPaciente,
            @RequestParam("tipoDocumentoId") String tipoDocumentoId,
            @RequestParam("numeroDocumento") String numeroDocumento,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("nombres") String nombres,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaNacimiento,
            @RequestParam("edad") int edad,
            @RequestParam("estado") Integer estado,
            @RequestParam("ocupacion") String ocupacion,
            @RequestParam("direccion") String direccion,
            @RequestParam("paisId") Integer paisId,
            @RequestParam("ubigeo") String ubigeo,
            @RequestParam("tipoPacienteId") Integer tipoPacienteId,
            @RequestParam("estadoCivil") String estadoCivil,
            @RequestParam("sexo") String sexo,
            @RequestParam("nombreContacto") String nombreContacto,
            @RequestParam("tipoHistoria") String tipoHistoria,
            @RequestParam("aseguradoraId") UUID aseguradoraId,
            @RequestParam("empresaId") UUID empresaId,
            @RequestParam("email") String email,
            @RequestParam("titulo") String titulo,
            @RequestParam("observacion") String observacion,
            @RequestParam("informacionClinicaId") UUID informacionClinicaId,
            @RequestParam("estudioId") UUID estudioId,
            @RequestParam("sedeId") UUID sedeId,
            @RequestParam("celular") String celular) throws IOException {

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
        if (fotoPaciente != null) {
            actualizarPacienteDTO.setFotoPaciente(Util.compressZLib(fotoPaciente.getBytes()));
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
                            schema = @Schema(implementation = PacienteResponse.class)))
    })
    public ListResponse<PacienteDTO> getAllAseguradora(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows
    ) {
        return pacienteService.getAllPaciente(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteList")
    public ResponseEntity<List<PacienteDTO>> getAllList(){
        return ResponseEntity.ok(pacienteService.getPacienteList());
    }

    @GetMapping("/GetPaciente/{pacienteId}")
    public ResponseEntity<PacienteDTO> getById(@PathVariable UUID pacienteId){
        return pacienteService.getPacienteById(pacienteId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/DeletePaciente/{pacienteId}")
    public ResponseEntity<ApiResponse> destroy(@PathVariable UUID pacienteId){
        pacienteService.deletePaciente(pacienteId);
        return ResponseEntity.ok(new ApiResponse(true, "Paciente eliminado correctamente,"));
    }


}