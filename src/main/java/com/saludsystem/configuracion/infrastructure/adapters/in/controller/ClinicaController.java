package com.saludsystem.configuracion.infrastructure.adapters.in.controller;

import com.saludsystem.configuracion.application.dto.res.SysSaludResponse;
import com.saludsystem.configuracion.application.dto.req.SysSaludRequest;
import com.saludsystem.configuracion.application.dto.res.ActualizarHospitalDTO;
import com.saludsystem.configuracion.application.services.SysSaludService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.in.response.ClinicaListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.PlanRepository;
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

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PostMapping(value = "/SaveHospital", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> store(
            String nombre, String direccion, String celular, String email, String ruc,
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha, MultipartFile foto, UUID planId, Integer estado)
            throws IOException {
        SysSaludRequest sysSaludRequest = new SysSaludRequest();
        sysSaludRequest.setNombre(nombre);
        sysSaludRequest.setDireccion(direccion);
        sysSaludRequest.setCelular(celular);
        sysSaludRequest.setEmail(email);
        sysSaludRequest.setRuc(ruc);
        sysSaludRequest.setFecha(fecha);
        //crearSysSaludDTO.setFoto(foto);
        sysSaludRequest.setPlanId(planId);
        sysSaludRequest.setEstado(estado);
        sysSaludService.saveClinica(sysSaludRequest);
        return ResponseEntity.ok(new ApiResponse(true, "Hospital creado correctamente!!."));
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PutMapping(value = "/UpdateHospital/{hospitalId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> updated
            (@PathVariable("hospitalId") UUID hospitalId, MultipartFile foto, String nombre,  String direccion,
             String celular,  String email, String ruc,  @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha,
             UUID planId,  Integer estado) throws IOException {
        ActualizarHospitalDTO actualizarHospitalDTO = new ActualizarHospitalDTO();
        actualizarHospitalDTO.setNombre(nombre);
        actualizarHospitalDTO.setDireccion(direccion);
        actualizarHospitalDTO.setCelular(celular);
        actualizarHospitalDTO.setEmail(email);
        actualizarHospitalDTO.setRuc(ruc);
        actualizarHospitalDTO.setFecha(fecha);
        actualizarHospitalDTO.setPlanId(planId);
        actualizarHospitalDTO.setEstado(estado);
        /*
        if (foto != null) {
            actualizarHospitalDTO.setFoto(Util.compressZLib(foto.getBytes()));
        }*/
        sysSaludService.updateHospital(hospitalId, actualizarHospitalDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Hospital actualizado correctamente"));
    }

    @GetMapping("/GetAllHospital")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClinicaListResponse.class)))
    })
    public ListResponse<SysSaludResponse> getAllPage(@RequestParam(name = "hospitalId", required = true) UUID hospitalId,
                                                     @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return sysSaludService.getAllHospital(hospitalId, page, rows);
    }

    @GetMapping("/GetHospitalList")
    public ResponseEntity<List<SysSaludResponse>> getAllList() {
        return ResponseEntity.ok(sysSaludService.getHospitalList());
    }

    @GetMapping("/GetHospital/{hospitalId}")
    public ResponseEntity<SysSaludResponse> getById(@PathVariable UUID hospitalId) {
        return sysSaludService.getHospitalBysId(hospitalId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/DeleteHospital/{hospitalId}")
    public ApiResponse destroy(@PathVariable UUID hospitalId) {
        return sysSaludService.deleteHospital(hospitalId);
    }
}