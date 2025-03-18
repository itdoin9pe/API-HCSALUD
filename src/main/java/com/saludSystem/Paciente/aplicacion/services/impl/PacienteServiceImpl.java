package com.saludSystem.Paciente.aplicacion.services.impl;

import com.saludSystem.Configuracion.Sede.dominio.SedeModel;
import com.saludSystem.Configuracion.Sede.infraestructura.repositories.SedeRepository;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.adapter.Aseguradora.aplicacion.dtos.AseguradoraDTO;
import com.saludSystem.Generals.adapter.Aseguradora.dominio.AseguradoraModel;
import com.saludSystem.Generals.adapter.Aseguradora.infraestructura.repositories.AseguradoraRepository;
import com.saludSystem.Generals.adapter.Empresa.dominio.EmpresaModel;
import com.saludSystem.Generals.adapter.Empresa.infraestructura.repositories.EmpresaRepository;
import com.saludSystem.Generals.adapter.Estudio.domain.EstudioModel;
import com.saludSystem.Generals.adapter.Estudio.infraestructura.repositories.EstudioRepository;
import com.saludSystem.Generals.adapter.InformacionClinica.domain.InformacionClinicaModel;
import com.saludSystem.Generals.adapter.InformacionClinica.infraestructura.repositories.InformacionClinicaRepository;
import com.saludSystem.Generals.adapter.Pais.domain.PaisModel;
import com.saludSystem.Generals.adapter.Pais.infraestructura.repositories.PaisRepository;
import com.saludSystem.Generals.adapter.TipoPaciente.domain.TipoPacienteModel;
import com.saludSystem.Generals.adapter.TipoPaciente.infraestructura.repositories.TipoPacienteRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Paciente.aplicacion.dtos.ActualizarPacienteDTO;
import com.saludSystem.Paciente.aplicacion.dtos.CrearPacienteDTO;
import com.saludSystem.Paciente.aplicacion.dtos.PacienteDTO;
import com.saludSystem.Paciente.aplicacion.services.PacienteService;
import com.saludSystem.Paciente.dominio.PacienteModel;
import com.saludSystem.Paciente.infraestructura.repositories.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PaisRepository paisRepository;
    private final SedeRepository sedeRepository;
    private final EmpresaRepository empresaRepository;
    private final AseguradoraRepository aseguradoraRepository;
    private final EstudioRepository estudioRepository;
    private final TipoPacienteRepository tipoPacienteRepository;
    private final InformacionClinicaRepository informacionClinicaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, PaisRepository paisRepository, SedeRepository sedeRepository, EmpresaRepository empresaRepository, AseguradoraRepository aseguradoraRepository, EstudioRepository estudioRepository, TipoPacienteRepository tipoPacienteRepository, InformacionClinicaRepository informacionClinicaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.paisRepository = paisRepository;
        this.sedeRepository = sedeRepository;
        this.empresaRepository = empresaRepository;
        this.aseguradoraRepository = aseguradoraRepository;
        this.estudioRepository = estudioRepository;
        this.tipoPacienteRepository = tipoPacienteRepository;
        this.informacionClinicaRepository = informacionClinicaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PacienteModel savePaciente(CrearPacienteDTO crearPacienteDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        PacienteModel paciente = new PacienteModel();
        paciente.setTipoDocumentoId(crearPacienteDTO.getTipoDocumentoId());
        paciente.setNumeroDocumento(crearPacienteDTO.getNumeroDocumento());
        paciente.setApellidos(crearPacienteDTO.getApellidos());
        paciente.setNombres(crearPacienteDTO.getNombres());
        paciente.setFechaNacimiento(crearPacienteDTO.getFechaNacimiento());
        paciente.setEdad(crearPacienteDTO.getEdad());
        paciente.setEstado(crearPacienteDTO.getEstado());
        paciente.setOcupacion(crearPacienteDTO.getOcupacion());
        paciente.setDireccion(crearPacienteDTO.getDireccion());
        Optional<PaisModel> pais = paisRepository.findById(crearPacienteDTO.getPaisId());
        pais.ifPresent(paciente::setPaisId);
        paciente.setUbigeo(crearPacienteDTO.getUbigeo());
        Optional<TipoPacienteModel> tipoPaciente = tipoPacienteRepository.findById(crearPacienteDTO.getTipoPacienteId());
        tipoPaciente.ifPresent(paciente::setTipoPacienteId);
        paciente.setEstadoCivil(crearPacienteDTO.getEstadoCivil());
        paciente.setSexo(crearPacienteDTO.getSexo());
        paciente.setNombreContacto(crearPacienteDTO.getNombreContacto());
        paciente.setTipoHistoria(crearPacienteDTO.getTipoHistoria());
        Optional<AseguradoraModel> aseguradora = aseguradoraRepository.findById(crearPacienteDTO.getAseguradoraId());
        aseguradora.ifPresent(paciente::setAseguradoraId);
        Optional<EmpresaModel> empresa = empresaRepository.findById(crearPacienteDTO.getEmpresaId());
        empresa.ifPresent(paciente::setEmpresaId);
        paciente.setEmail(crearPacienteDTO.getEmail());
        paciente.setFotoPaciente(crearPacienteDTO.getFotoPaciente());
        paciente.setTitulo(crearPacienteDTO.getTitulo());
        paciente.setObservacion(crearPacienteDTO.getObservacion());
        Optional<InformacionClinicaModel> informacionClinica = informacionClinicaRepository.findById(crearPacienteDTO.getInformacionClinicaId());
        informacionClinica.ifPresent(paciente::setInformacionClinicaId);
        Optional<EstudioModel> estudio = estudioRepository.findById(crearPacienteDTO.getEstudioId());
        estudio.ifPresent(paciente::setEstudioId);
        Optional<SedeModel> sede = sedeRepository.findById(crearPacienteDTO.getSedeId());
        sede.ifPresent(paciente::setSedeId);
        paciente.setCelular(crearPacienteDTO.getCelular());
        paciente.setHospital(hospital);
        paciente.setUser(user);
        return pacienteRepository.save(paciente);
    }

    @Override
    public ActualizarPacienteDTO updatePaciente(UUID pacienteId, ActualizarPacienteDTO actualizarPacienteDTO) {
        PacienteModel paciente = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new ResourceNotFoundException("Paciente no encontrado con ID"));
        Optional.ofNullable(actualizarPacienteDTO.getTipoDocumentoId()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setTipoDocumentoId);
        Optional.ofNullable(actualizarPacienteDTO.getNumeroDocumento()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setNumeroDocumento);
        Optional.ofNullable(actualizarPacienteDTO.getApellidos()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setApellidos);
        Optional.ofNullable(actualizarPacienteDTO.getNombres()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setNombres);
        Optional.ofNullable(actualizarPacienteDTO.getFechaNacimiento()).ifPresent(paciente::setFechaNacimiento);
        Optional.ofNullable(actualizarPacienteDTO.getEdad()).ifPresent(paciente::setEdad);
        Optional.ofNullable(actualizarPacienteDTO.getEstado()).ifPresent(paciente::setEstado);
        Optional.ofNullable(actualizarPacienteDTO.getOcupacion()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setOcupacion);
        Optional.ofNullable(actualizarPacienteDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setDireccion);
        Optional.ofNullable(actualizarPacienteDTO.getUbigeo()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setUbigeo);
        Optional.ofNullable(actualizarPacienteDTO.getEstadoCivil()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setEstadoCivil);
        Optional.ofNullable(actualizarPacienteDTO.getSexo()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setSexo);
        Optional.ofNullable(actualizarPacienteDTO.getNombreContacto()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setNombreContacto);
        Optional.ofNullable(actualizarPacienteDTO.getTipoHistoria()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setTipoHistoria);
        Optional.ofNullable(actualizarPacienteDTO.getEmail()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setEmail);
        Optional.ofNullable(actualizarPacienteDTO.getTitulo()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setTitulo);
        Optional.ofNullable(actualizarPacienteDTO.getObservacion()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setObservacion);
        Optional.ofNullable(actualizarPacienteDTO.getCelular()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setCelular);
        Optional.ofNullable(actualizarPacienteDTO.getPaisId()).flatMap(paisRepository::findById).ifPresent(paciente::setPaisId);
        Optional.ofNullable(actualizarPacienteDTO.getTipoPacienteId()).flatMap(tipoPacienteRepository::findById).ifPresent(paciente::setTipoPacienteId);
        Optional.ofNullable(actualizarPacienteDTO.getAseguradoraId()).flatMap(aseguradoraRepository::findById).ifPresent(paciente::setAseguradoraId);
        Optional.ofNullable(actualizarPacienteDTO.getEmpresaId()).flatMap(empresaRepository::findById).ifPresent(paciente::setEmpresaId);
        Optional.ofNullable(actualizarPacienteDTO.getInformacionClinicaId()).flatMap(informacionClinicaRepository::findById).ifPresent(paciente::setInformacionClinicaId);
        Optional.ofNullable(actualizarPacienteDTO.getEstudioId()).flatMap(estudioRepository::findById).ifPresent(paciente::setEstudioId);
        Optional.ofNullable(actualizarPacienteDTO.getSedeId()).flatMap(sedeRepository::findById).ifPresent(paciente::setSedeId);
        pacienteRepository.save(paciente);
        return modelMapper.map(paciente, ActualizarPacienteDTO.class);
    }

    @Override
    public Optional<PacienteDTO> getPacienteById(UUID pacienteId) {
        return Optional.ofNullable(pacienteRepository.findById(pacienteId).map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado")));
    }

    @Override
    public List<PacienteDTO> getPacienteList() {
        return pacienteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<PacienteDTO> getAllPaciente(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PacienteModel> pacienteModelPage = pacienteRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PacienteDTO> data = pacienteModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, pacienteModelPage.getTotalElements(), pacienteModelPage.getTotalPages(), pacienteModelPage.getNumber() + 1);
    }

    @Override
    public ApiResponse deletePaciente(UUID pacienteId) {
        pacienteRepository.deleteById(pacienteId);
        return new ApiResponse(true, "Paciente eliminado correctamente");
    }

    private PacienteDTO convertToDTO(PacienteModel paciente) {
        return modelMapper.map(paciente, PacienteDTO.class);
    }

}