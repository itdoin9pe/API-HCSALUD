package com.saludSystem.services.modules.Paciente.impl;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.dtos.Paciente.PacienteDTO;
import com.saludSystem.entities.*;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.repositories.modules.Generals.*;
import com.saludSystem.repositories.modules.Paciente.PacienteRepository;
import com.saludSystem.services.modules.Paciente.PacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    private final ModelMapper modelMapper;

    @Autowired
    public PacienteServiceImpl(
            PacienteRepository pacienteRepository, PaisRepository paisRepository,
            SedeRepository sedeRepository, EmpresaRepository empresaRepository,
            AseguradoraRepository aseguradoraRepository, EstudioRepository estudioRepository,
            TipoPacienteRepository tipoPacienteRepository, InformacionClinicaRepository informacionClinicaRepository,
            ModelMapper modelMapper
    )
    {
        this.pacienteRepository = pacienteRepository;
        this.paisRepository = paisRepository;
        this.sedeRepository = sedeRepository;
        this.empresaRepository = empresaRepository;
        this.aseguradoraRepository = aseguradoraRepository;
        this.estudioRepository = estudioRepository;
        this.tipoPacienteRepository = tipoPacienteRepository;
        this.informacionClinicaRepository = informacionClinicaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Paciente savePaciente(CrearPacienteDTO crearPacienteDTO) {
        Paciente paciente = new Paciente();

        paciente.setTipoDocumentoId(crearPacienteDTO.getTipoDocumentoId());
        paciente.setNumeroDocumento(crearPacienteDTO.getNumeroDocumento());
        paciente.setApellidos(crearPacienteDTO.getApellidos());
        paciente.setNombres(crearPacienteDTO.getNombres());
        paciente.setFechaNacimiento(crearPacienteDTO.getFechaNacimiento());
        paciente.setEdad(crearPacienteDTO.getEdad());
        paciente.setEstado(crearPacienteDTO.getEstado());
        paciente.setOcupacion(crearPacienteDTO.getOcupacion());
        paciente.setDireccion(crearPacienteDTO.getDireccion());

        Optional<Pais> pais = paisRepository.findById(crearPacienteDTO.getPaisId());
        pais.ifPresent(paciente::setPaisId);

        paciente.setUbigeo(crearPacienteDTO.getUbigeo());

        Optional<TipoPaciente> tipoPaciente = tipoPacienteRepository.findById(crearPacienteDTO.getTipoPacienteId());
        tipoPaciente.ifPresent(paciente::setTipoPacienteId);

        paciente.setEstadoCivil(crearPacienteDTO.getEstadoCivil());
        paciente.setSexo(crearPacienteDTO.getSexo());
        paciente.setNombreContacto(crearPacienteDTO.getNombreContacto());
        paciente.setTipoHistoria(crearPacienteDTO.getTipoHistoria());

        Optional<Aseguradora> aseguradora = aseguradoraRepository.findById(crearPacienteDTO.getAseguradoraId());
        aseguradora.ifPresent(paciente::setAseguradoraId);

        Optional<Empresa> empresa = empresaRepository.findById(crearPacienteDTO.getEmpresaId());
        empresa.ifPresent(paciente::setEmpresaId);

        paciente.setEmail(crearPacienteDTO.getEmail());
        paciente.setFotoPaciente(crearPacienteDTO.getFotoPaciente());
        paciente.setTitulo(crearPacienteDTO.getTitulo());
        paciente.setObservacion(crearPacienteDTO.getObservacion());

        Optional<InformacionClinica> informacionClinica = informacionClinicaRepository.findById(crearPacienteDTO.getInformacionClinicaId());
        informacionClinica.ifPresent(paciente::setInformacionClinicaId);

        Optional<Estudio> estudio = estudioRepository.findById(crearPacienteDTO.getEstudioId());
        estudio.ifPresent(paciente::setEstudioId);

        Optional<Sede> sede = sedeRepository.findById(crearPacienteDTO.getSedeId());
        sede.ifPresent(paciente::setSedeId);

        paciente.setCelular(crearPacienteDTO.getCelular());

        return pacienteRepository.save(paciente);
    }

    @Override
    public List<PacienteDTO> getPagedResults(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Paciente> pacientePage = pacienteRepository.findAll(pageable);
        return pacientePage.getContent().stream()
                .map(paciente -> modelMapper.map(paciente,PacienteDTO.class))
                .toList();
    }

    @Override
    public long getTotalCount() {
        return pacienteRepository.count();
    }
}