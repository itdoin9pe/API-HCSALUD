package com.saludSystem.controllers.ModuleConfiguracion;

import com.saludSystem.dtos.configuration.SysSalud.ActualizarHospitalDTO;
import com.saludSystem.dtos.configuration.SysSalud.CrearSysSaludDTO;
import com.saludSystem.dtos.configuration.SysSalud.SysSaludDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Configuration.ClinicaResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.repositories.modules.Catalogo.PlanRepository;
import com.saludSystem.services.modules.configuration.SysSalud.SysSaludService;
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

@Tag(name = "Hospitales")
@RestController
@RequestMapping("/api/Hospitales")
public class ClinicaController {

    private final SysSaludService sysSaludService;
    private final PlanRepository planRepository;

    public ClinicaController(SysSaludService sysSaludService, PlanRepository planRepository){
        this.sysSaludService = sysSaludService;
        this.planRepository = planRepository;
    }

    @PostMapping("/SaveHospital")
    public ResponseEntity<ApiResponse> store(
            @RequestParam("nombre") String nombre, @RequestParam("direccion") String direccion,
            @RequestParam("celular") String celular, @RequestParam("email") String email,
            @RequestParam("ruc") String ruc, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha,
            @RequestParam("foto") MultipartFile foto, @RequestParam("planId") UUID planId,
            @RequestParam("estado") Integer estado) throws IOException {
        CrearSysSaludDTO crearSysSaludDTO = new CrearSysSaludDTO();
        crearSysSaludDTO.setNombre(nombre);
        crearSysSaludDTO.setDireccion(direccion);
        crearSysSaludDTO.setCelular(celular);
        crearSysSaludDTO.setEmail(email);
        crearSysSaludDTO.setRuc(ruc);
        crearSysSaludDTO.setFecha(fecha);
        crearSysSaludDTO.setFoto(Util.compressZLib(foto.getBytes()));
        crearSysSaludDTO.setPlanId(planId);
        crearSysSaludDTO.setEstado(estado);
        sysSaludService.saveClinica(crearSysSaludDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Hospital creado correctamente!!."));
    }

    @PutMapping("/UpdateHospital/{hospitalId}")
    public ResponseEntity<ApiResponse> updated(@PathVariable("hospitalId") UUID hospitalId,
            @Valid @RequestParam(value = "foto", required = false) MultipartFile foto,
            @RequestParam("nombre") String nombre, @RequestParam("direccion") String direccion,
            @RequestParam("celular") String celular, @RequestParam("email") String email,
            @RequestParam("ruc") String ruc, @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha,
            @RequestParam("planId") UUID planId, @RequestParam("estado") Integer estado) throws IOException {
        ActualizarHospitalDTO actualizarHospitalDTO = new ActualizarHospitalDTO();
        actualizarHospitalDTO.setNombre(nombre);
        actualizarHospitalDTO.setDireccion(direccion);
        actualizarHospitalDTO.setCelular(celular);
        actualizarHospitalDTO.setEmail(email);
        actualizarHospitalDTO.setRuc(ruc);
        actualizarHospitalDTO.setFecha(fecha);
        actualizarHospitalDTO.setPlanId(planId);
        actualizarHospitalDTO.setEstado(estado);
        if (foto != null) {
            actualizarHospitalDTO.setFoto(Util.compressZLib(foto.getBytes()));
        }
        sysSaludService.updateHospital(hospitalId, actualizarHospitalDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Hospital actualizado correctamente"));
    }


    @GetMapping("/GetAllHospital")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClinicaResponse.class)))
    })
    public ListResponse<SysSaludDTO> getAllPage(@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return sysSaludService.getAllHospital(hospitalId, page, rows);
    }

    @GetMapping("/GetHospitalList")
    public ResponseEntity<List<SysSaludDTO>> getAllList() {
        return ResponseEntity.ok(sysSaludService.getHospitalList());
    }

    @GetMapping("/GetHospital/{hospitalId}")
    public ResponseEntity<SysSaludDTO> getById(@PathVariable UUID hospitalId) {
        return sysSaludService.getHospitalBysId(hospitalId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/DeleteHospital/{hospitalId}")
    public ApiResponse destroy(@PathVariable UUID hospitalId) {
        return sysSaludService.deleteHospital(hospitalId);
    }

}