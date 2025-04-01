package com.saludSystem.Configuracion.TipoDocumento.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.TipoDocumento.aplicacion.dtos.ActualizarTipoDocumentoDTO;
import com.saludSystem.Configuracion.TipoDocumento.aplicacion.dtos.CrearTipoDocumentoDTO;
import com.saludSystem.Configuracion.TipoDocumento.aplicacion.dtos.TipoDocumentoDTO;
import com.saludSystem.Configuracion.TipoDocumento.dominio.TipoDocumentoModel;
import com.saludSystem.Configuracion.TipoDocumento.infraestructura.repositories.TipoDocumentoRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
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
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoDocumentoModel tipoDocumento = new TipoDocumentoModel();
        tipoDocumento.setTipoComprobante(crearTipoDocumentoDTO.getTipoComprobante());
        tipoDocumento.setSerie(crearTipoDocumentoDTO.getSerie());
        tipoDocumento.setInicio(crearTipoDocumentoDTO.getInicio());
        tipoDocumento.setFin(crearTipoDocumentoDTO.getFin());
        tipoDocumento.setCorrelativoActual(crearTipoDocumentoDTO.getCorrelativoActual());
        tipoDocumento.setEstado(crearTipoDocumentoDTO.getEstado());
        tipoDocumento.setHospital(hospital);
        tipoDocumento.setUser(user);
        tipoDocumentoRepository.save(tipoDocumento);
        return new ApiResponse(true, "Tipo de documento registrado correctamente");
    }

    @Override
    public ListResponse<TipoDocumentoDTO> getAllTipoDocumento(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoDocumentoModel> tipoDocumentoPage = tipoDocumentoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoDocumentoDTO> data = tipoDocumentoPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoDocumentoPage.getTotalElements(), tipoDocumentoPage.getTotalPages(), tipoDocumentoPage.getNumber() + 1);
    }

    @Override
    public TipoDocumentoDTO getTipoDocumentoById(UUID tDocumentoId) {
        TipoDocumentoModel tipoDocumento = tipoDocumentoRepository.findById(tDocumentoId)
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
        return tipoDocumentoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse updateTipoDocumento(UUID tDocumentoId, ActualizarTipoDocumentoDTO actualizarTipoDocumentoDTO) {
        TipoDocumentoModel tipoDocumento = tipoDocumentoRepository.findById(tDocumentoId).orElseThrow(
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

    private TipoDocumentoDTO convertToDTO(TipoDocumentoModel tipoDocumento) {
        return modelMapper.map(tipoDocumento, TipoDocumentoDTO.class);
    }

}