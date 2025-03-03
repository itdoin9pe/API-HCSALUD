package com.saludSystem.aplicacion.services.modules.Configuracion.TipoDocumento.Impl;

import com.saludSystem.aplicacion.dtos.Configuracion.TipoDocumento.ActualizarTipoDocumentoDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.TipoDocumento.CrearTipoDocumentoDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.TipoDocumento.TipoDocumentoDTO;
import com.saludSystem.aplicacion.dtos.responses.ApiResponse;
import com.saludSystem.aplicacion.dtos.responses.ListResponse;
import com.saludSystem.dominio.entities.Configuracion.User;
import com.saludSystem.dominio.entities.Configuracion.SysSalud;
import com.saludSystem.dominio.entities.Configuracion.TipoDocumento;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.UserRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.SysSaludRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.TipoDocumentoRepository;
import com.saludSystem.aplicacion.services.modules.Configuracion.TipoDocumento.TipoDocumentoService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public TipoDocumentoServiceImpl(TipoDocumentoRepository tipoDocumentoRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoDocumento(CrearTipoDocumentoDTO crearTipoDocumentoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setTipoComprobante(crearTipoDocumentoDTO.getTipoComprobante());
        tipoDocumento.setSerie(crearTipoDocumentoDTO.getSerie());
        tipoDocumento.setInicio(crearTipoDocumentoDTO.getInicio());
        tipoDocumento.setFin(crearTipoDocumentoDTO.getFin());
        tipoDocumento.setCorrelativoActual(crearTipoDocumentoDTO.getCorrelativoActual());
        tipoDocumento.setEstado(crearTipoDocumentoDTO.getEstado());
        tipoDocumento.setHospital(hospital);
        tipoDocumento.setUser(user);
        tipoDocumentoRepository.save(tipoDocumento);
        return new ApiResponse(true, "TIpo de documento registrado correctamente");
    }

    @Override
    public ListResponse<TipoDocumentoDTO> getAllTipoDocumento(UUID hospitalId, int page, int rows) {
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findByHospital_HospitalId(hospitalId);
        List<TipoDocumentoDTO> data = tipoDocumentos.stream().map(tipoDocumento -> {
            TipoDocumentoDTO dto = new TipoDocumentoDTO();
            dto.setTDocumentoId(tipoDocumento.getTDocumentoId());
            dto.setTipoComprobante(tipoDocumento.getTipoComprobante());
            dto.setSerie(tipoDocumento.getSerie());
            dto.setInicio(tipoDocumento.getInicio());
            dto.setFin(tipoDocumento.getFin());
            dto.setCorrelativoActual(tipoDocumento.getCorrelativoActual());
            dto.setEstado(tipoDocumento.getEstado());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    @Override
    public TipoDocumentoDTO getTipoDocumentoById(UUID tDocumentoId) {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(tDocumentoId)
                .orElseThrow( () -> new RuntimeException("Tipo de documento no encontrado"));
        TipoDocumentoDTO dto = new TipoDocumentoDTO();
        dto.setTDocumentoId(tipoDocumento.getTDocumentoId());
        dto.setTipoComprobante(tipoDocumento.getTipoComprobante());
        dto.setSerie(tipoDocumento.getSerie());
        dto.setInicio(tipoDocumento.getInicio());
        dto.setFin(tipoDocumento.getFin());
        dto.setCorrelativoActual(tipoDocumento.getCorrelativoActual());
        dto.setEstado(tipoDocumento.getEstado());
        return dto;
    }

    @Override
    public List<TipoDocumentoDTO> getTipoDocumentoList() {
        return tipoDocumentoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse updateTipoDocumento(UUID tDocumentoId, ActualizarTipoDocumentoDTO actualizarTipoDocumentoDTO) {
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(tDocumentoId).orElseThrow(
                () -> new RuntimeException("Tipo Documento no encontrado"));
        Optional.ofNullable(actualizarTipoDocumentoDTO.getTipoComprobante()).filter(desc -> !desc.isBlank()).ifPresent(tipoDocumento::setTipoComprobante);
        Optional.ofNullable(actualizarTipoDocumentoDTO.getSerie()).ifPresent(tipoDocumento::setSerie);
        Optional.ofNullable(actualizarTipoDocumentoDTO.getInicio()).ifPresent(tipoDocumento::setInicio);
        Optional.ofNullable(actualizarTipoDocumentoDTO.getFin()).ifPresent(tipoDocumento::setFin);
        Optional.ofNullable(actualizarTipoDocumentoDTO.getCorrelativoActual()).ifPresent(tipoDocumento::setCorrelativoActual);
        tipoDocumentoRepository.save(tipoDocumento);
        return new ApiResponse(true, "Tipo de documento actualizado correctamente");
    }

    @Override
    public ApiResponse deleteTipoDocumento(UUID tDocumentoId) {
        tipoDocumentoRepository.deleteById(tDocumentoId);
        return new ApiResponse(true, "Tipo de documento eliminado correctamente");
    }

    private TipoDocumentoDTO convertToDTO(TipoDocumento tipoDocumento) {
        return modelMapper.map(tipoDocumento, TipoDocumentoDTO.class);
    }

}