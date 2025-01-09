package com.saludSystem.services.modules.Paciente;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.*;

import com.saludSystem.entities.InformacionClinica;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.entities.configuracion.TipoDocumento;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.repositories.modules.Configuration.TipoDocumentoRepository;
import com.saludSystem.repositories.modules.Generals.*;
import com.saludSystem.repositories.modules.Paciente.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;


@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private AseguradoraRepository aseguradoraRepository;

    @Autowired
    private EstudioRepository estudioRepository;

    @Autowired
    private TipoPacienteRepository tipoPacienteRepository;

    @Autowired
    private InformacionClinicaRepository informacionClinicaRepository;

    public Paciente savePaciente(CrearPacienteDTO crearPacienteDTO, String fotoPacienteBase64) {

        byte[] fotoPaciente = convertirBase64ABytes(fotoPacienteBase64);

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
        paciente.setCelular(crearPacienteDTO.getCelular());
        paciente.setEmail(crearPacienteDTO.getEmail());
        paciente.setFotoPaciente(fotoPaciente);  // Asignar la foto convertida en Base64
        paciente.setTitulo(crearPacienteDTO.getTitulo());
        paciente.setObservacion(crearPacienteDTO.getObservacion());

        Pais pais = paisRepository.findById(crearPacienteDTO.getPaisId()).orElseThrow(() -> new RuntimeException("País no encontrado"));
        paciente.setPaisId(pais);

        Sede sede = sedeRepository.findById(crearPacienteDTO.getSedeId()).orElseThrow(() -> new RuntimeException("Sede no encontrada"));
        paciente.setSedeId(sede);

        Empresa empresa = empresaRepository.findById(crearPacienteDTO.getEmpresaId()).orElseThrow(() ->new RuntimeException("Empresa no encontrada"));
        paciente.setEmpresaId(empresa);

        Aseguradora aseguradora = aseguradoraRepository.findById(crearPacienteDTO.getEmpresaId()).orElseThrow(() -> new RuntimeException("Aseguradora no encontrada"));
        paciente.setAseguradoraId(aseguradora);

        Estudio estudio = estudioRepository.findById(crearPacienteDTO.getEstudioId()).orElseThrow(() -> new RuntimeException("Estudio no encontrado"));
        paciente.setEstudioId(estudio);

        TipoPaciente tipoPaciente = tipoPacienteRepository.findById(crearPacienteDTO.getTipoPacienteId()).orElseThrow(() -> new RuntimeException("Tipo de Paciente no encontrado"));
        paciente.setTipoPacienteId(tipoPaciente);

        InformacionClinica informacionClinica = informacionClinicaRepository.findById(crearPacienteDTO.getInformacionClinicaId()).orElseThrow(() -> new RuntimeException("Informacion de la Clinica no encontrada"));
        paciente.setInformacionClinicaId(informacionClinica);

        return pacienteRepository.save(paciente);
    }

    // Método de utilidad para convertir base64 a byte[]
    public byte[] convertirBase64ABytes(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

}
