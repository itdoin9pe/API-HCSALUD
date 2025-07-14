package com.saludsystem.infrastructure.rest.controller.configuracion.query;

import com.saludsystem.application.configuracion.command.create.ClinicaCreateHandler;
import com.saludsystem.application.configuracion.command.delete.ClinicaDeleteHandler;
import com.saludsystem.application.configuracion.command.edit.ClinicaEditHandler;
import com.saludsystem.domain.response.ApiResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class ClinicaQueryController {

    /*
    private final ClinicaCreateHandler createHandler;
    private final ClinicaEditHandler editHandler;
    private final ClinicaDeleteHandler deleteHandler;

    public ClinicaQueryController(ClinicaCreateHandler createHandler, ClinicaEditHandler editHandler, ClinicaDeleteHandler deleteHandler) {
        this.createHandler = createHandler;
        this.editHandler = editHandler;
        this.deleteHandler = deleteHandler;
    }

    @PostMapping(value = "/SaveHospital", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> store(
            String nombre, String direccion, String celular, String email, String ruc,
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha, MultipartFile foto, UUID planId, Integer estado)
        throws IOException {
        createHandler.execute(nombre, direccion, celular, email, ruc, fecha, foto, planId, estado);
        return ResponseEntity.ok(new ApiResponse(true, "Hospital creado correctamente"));
    }

    @PutMapping(value = "/UpdateHospital/{hospitalId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> update(@PathVariable UUID hospitalId,
                                          MultipartFile foto,
                                          String nombre, String direccion, String celular,
                                          String email, String ruc,
                                          @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha,
                                          UUID planId, Integer estado) throws IOException {
        editHandler.execute(hospitalId, nombre, direccion, celular, email, ruc, fecha, foto, planId, estado);
        return ResponseEntity.ok(new ApiResponse(true, "Hospital actualizado correctamente"));
    }

     */
}