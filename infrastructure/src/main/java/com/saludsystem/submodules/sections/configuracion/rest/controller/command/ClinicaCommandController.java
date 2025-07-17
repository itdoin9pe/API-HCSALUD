package com.saludsystem.submodules.sections.configuracion.rest.controller.command;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Hospitales")
@RestController
@RequestMapping("/api/Hospitales")
public class ClinicaCommandController {

    /*
    private final SysSaludService sysSaludService;
    private final SysSaludRepository sysSaludRepository;
    private final FileStorageService fileStorageService;

    public ClinicaCommandController(SysSaludService sysSaludService, SysSaludRepository sysSaludRepository, FileStorageService fileStorageService){
        this.sysSaludService = sysSaludService;
        this.sysSaludRepository = sysSaludRepository;
        this.fileStorageService = fileStorageService;
    }

    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success",
            content = @Content(schema = @Schema(implementation = ApiResponse.class)))
    @PostMapping(value = "/SaveHospital", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse> store(
            String nombre, String direccion, String celular, String email, String ruc,
            @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha, MultipartFile foto, UUID planId, Integer estado)
    throws IOException {
        String photoPath = fileStorageService.storeFile(foto);
        CrearSysSaludDTO crearSysSaludDTO = new CrearSysSaludDTO();
        crearSysSaludDTO.setNombre(nombre);
        crearSysSaludDTO.setDireccion(direccion);
        crearSysSaludDTO.setCelular(celular);
        crearSysSaludDTO.setEmail(email);
        crearSysSaludDTO.setRuc(ruc);
        crearSysSaludDTO.setFecha(fecha);
        crearSysSaludDTO.setFoto(photoPath);
        crearSysSaludDTO.setPlanId(planId);
        crearSysSaludDTO.setEstado(estado);
        sysSaludService.saveClinica(crearSysSaludDTO);
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
        if (foto != null && !foto.isEmpty()) {
            SysSaludEntity existingClinica = sysSaludRepository.findById(hospitalId).orElseThrow();
            if (existingClinica.getFoto() != null) {
                fileStorageService.deleteFile(existingClinica.getFoto());
            }
            String photoPath = fileStorageService.storeFile(foto);
            actualizarHospitalDTO.setFoto(photoPath);
        }
        sysSaludService.updateHospital(hospitalId, actualizarHospitalDTO);
        return ResponseEntity.ok(new ApiResponse(true, "Hospital actualizado correctamente"));
    }

    @GetMapping("/GetAllHospital")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClinicaListResponse.class)))
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
    }*/
}