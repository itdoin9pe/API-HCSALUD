package com.saludsystem.submodules.rest.controller.paciente;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pacientes")
@RestController
@RequestMapping("/api/Pacientes")
public class PacienteController {

    /*
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
        crearPacienteDTO.setFotoPaciente(photoPaciente);
        crearPacienteDTO.setTitulo(titulo);
        crearPacienteDTO.setObservacion(observacion);
        crearPacienteDTO.setInformacionClinicaId(informacionClinicaId);
        crearPacienteDTO.setEstudioId(estudioId);
        crearPacienteDTO.setSedeId(sedeId);
        crearPacienteDTO.setCelular(celular);
        pacienteService.savePaciente(crearPacienteDTO);
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
    public ListResponse<PacienteDTO> obtenerPacientesPaginados(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return pacienteService.getAllPaciente(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteList")
    public ResponseEntity<List<PacienteDTO>> obtenerPacientes() {
        return ResponseEntity.ok(pacienteService.getPacienteList());
    }

    @GetMapping("/GetPaciente/{pacienteId}")
    public ResponseEntity<PacienteDTO> obtenerPacientesPorId(@PathVariable UUID pacienteId) {
        return pacienteService.getPacienteById(pacienteId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/DeletePaciente/{pacienteId}")
    public ApiResponse eliminarPaciente(@PathVariable UUID pacienteId) {
        return pacienteService.deletePaciente(pacienteId);
    }

     */
}