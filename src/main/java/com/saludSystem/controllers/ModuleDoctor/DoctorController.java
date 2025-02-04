package com.saludSystem.controllers.ModuleDoctor;

import com.saludSystem.dtos.Doctor.ActualizarDoctorDTO;
import com.saludSystem.dtos.Doctor.CrearDoctorDTO;
import com.saludSystem.dtos.Doctor.DoctorDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Doctor.DoctorResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.services.modules.Doctor.DoctorService;
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
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Tag(name = "Medicos")
@RestController
@RequestMapping("/api/Medicos")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/SaveDoctor")
    public ResponseEntity<ApiResponse> saveDoctor(
            @Valid @RequestParam("fotoDoctor") MultipartFile fotoDoctor,
            @RequestParam("fotoFirma") MultipartFile fotoFirma,
            @RequestParam("tipoDocumento") String tipoDocumento,
            @RequestParam("numeroDocumento") String numeroDocumento,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("nombres") String nombres,
            @RequestParam("direccion") String direccion,
            @RequestParam("correo") String correo,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("rne") String rne,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaNacimiento,
            @RequestParam("celular") String celular,
            @RequestParam("telefono") String telefono,
            @RequestParam("sexo") String sexo,
            @RequestParam("especialidadId") UUID especialidadId,
            @RequestParam("colegiatura") String colegiatura,
            @RequestParam("color") String color,
            @RequestParam("estado") Integer estado) throws IOException {

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
        crearDoctorDTO.setFotoDoctor(Util.compressZLib(fotoDoctor.getBytes()));
        crearDoctorDTO.setFotoFirma(Util.compressZLib(fotoFirma.getBytes()));

        doctorService.saveDoctor(crearDoctorDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Doctor creado correctamente"));
    }

    @PutMapping("/UpdateDoctor/{doctorId}")
    public ResponseEntity<ApiResponse> updateDoctor(
            @PathVariable("doctorId") UUID doctorId,
            @Valid @RequestParam(value = "fotoDoctor", required = false) MultipartFile fotoDoctor,
            @RequestParam(value = "fotoFirma", required = false) MultipartFile fotoFirma,
            @RequestParam("tipoDocumento") String tipoDocumento,
            @RequestParam("numeroDocumento") String numeroDocumento,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("nombres") String nombres,
            @RequestParam("direccion") String direccion,
            @RequestParam("correo") String correo,
            @RequestParam("abreviatura") String abreviatura,
            @RequestParam("rne") String rne,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaNacimiento,
            @RequestParam("celular") String celular,
            @RequestParam("telefono") String telefono,
            @RequestParam("sexo") String sexo,
            @RequestParam("especialidadId") UUID especialidadId,
            @RequestParam("colegiatura") String colegiatura,
            @RequestParam("color") String color,
            @RequestParam("estado") Integer estado) throws IOException {

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

        if (fotoDoctor != null) {
            actualizarDoctorDTO.setFotoDoctor(Util.compressZLib(fotoDoctor.getBytes()));
        }
        if (fotoFirma != null) {
            actualizarDoctorDTO.setFotoFirma(Util.compressZLib(fotoFirma.getBytes()));
        }

        doctorService.updateDoctor(doctorId, actualizarDoctorDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Doctor actualizado correctamente"));
    }

    @GetMapping("/GetAllDoctor")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DoctorResponse.class)))
    })
    public ResponseEntity<ListResponse<DoctorDTO>> getAllDoctor(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page,
            @RequestParam(name = "Rows") int rows
    ) {
        List<DoctorDTO> doctores = doctorService.getPagedResults(hospitalId, page, rows);
        long totalData = doctorService.getTotalCount();
        ListResponse<DoctorDTO> response = new ListResponse<>();
        response.setData(doctores);
        response.setTotalData(totalData);

        return ResponseEntity.ok(response);
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
