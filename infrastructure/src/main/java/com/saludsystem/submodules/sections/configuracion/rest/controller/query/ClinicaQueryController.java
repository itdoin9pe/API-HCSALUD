package com.saludsystem.submodules.sections.configuracion.rest.controller.query;

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