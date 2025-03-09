package com.saludSystem.aplicacion.services.modules.Catalogo.TipoCitado.impl;

import com.saludSystem.aplicacion.dtos.Catalogo.TipoCitado.ActualizarTipoCitadoDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.TipoCitado.CrearTipoCitadoDTO;
import com.saludSystem.aplicacion.dtos.Catalogo.TipoCitado.TipoCitadoDTO;
import com.saludSystem.aplicacion.responses.ApiResponse;
import com.saludSystem.aplicacion.responses.ListResponse;
import com.saludSystem.aplicacion.services.modules.Catalogo.TipoCitado.TipoCitadoService;
import com.saludSystem.dominio.entities.Catalogo.TipoCitado;
import com.saludSystem.dominio.entities.Configuracion.SysSalud;
import com.saludSystem.dominio.entities.Configuracion.User;
import com.saludSystem.infraestructura.repositories.modules.Catalogo.TipoCitadoRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.SysSaludRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.UserRepository;
import com.saludSystem.infraestructura.security.exception.ResourceNotFoundException;
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
public class TipoCitadoServiceImpl implements TipoCitadoService {

    private final TipoCitadoRepository tipoCitadoRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public TipoCitadoServiceImpl(TipoCitadoRepository tipoCitadoRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.tipoCitadoRepository = tipoCitadoRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ApiResponse saveTipoCitado(CrearTipoCitadoDTO crearTipoCitadoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoCitado tipoCitado = new TipoCitado();
        tipoCitado.setNombre(crearTipoCitadoDTO.getNombre());
        tipoCitado.setColor(crearTipoCitadoDTO.getColor());
        tipoCitado.setEstado(crearTipoCitadoDTO.getEstado());
        tipoCitado.setUser(user);
        tipoCitado.setHospital(hospital);
        tipoCitadoRepository.save(tipoCitado);
        return new ApiResponse(true, "Estado de Cita registrado correctamente");
    }

    @Override
    public ApiResponse updateTipoCitado(UUID tipoCitadoId, ActualizarTipoCitadoDTO actualizarTipoCitadoDTO) {
        TipoCitado tipoCitado = tipoCitadoRepository.findById(tipoCitadoId).orElseThrow(
                () -> new ResourceNotFoundException("Tipo de citado no encontrado"));
        Optional.ofNullable(actualizarTipoCitadoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(tipoCitado::setNombre);
        Optional.ofNullable(actualizarTipoCitadoDTO.getColor()).filter(desc -> !desc.isBlank()).ifPresent(tipoCitado::setColor);
        Optional.ofNullable(actualizarTipoCitadoDTO.getEstado()).ifPresent(tipoCitado::setEstado);
        tipoCitadoRepository.save(tipoCitado);
        return new ApiResponse(true, "Tipo de citado actualizado correctamente");
    }

    @Override
    public TipoCitadoDTO getTipoCitadoById(UUID tipoCitadoId) {
        TipoCitado tipoCitado = tipoCitadoRepository.findById(tipoCitadoId)
                .orElseThrow( () -> new ResourceNotFoundException("Tipo de citado no encontrado"));
        TipoCitadoDTO dto = new TipoCitadoDTO();
        dto.setTipoCitadoId(tipoCitado.getTipoCitadoId());
        dto.setNombre(tipoCitado.getNombre());
        dto.setColor(tipoCitado.getColor());
        dto.setEstado(tipoCitado.getEstado());
        return dto;
    }

    @Override
    public List<TipoCitadoDTO> getTipoCitadoList() {
        return tipoCitadoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteTipoCitado(UUID tipocitadoId) {
        tipoCitadoRepository.deleteById(tipocitadoId);
        return new ApiResponse(true, "Tipo de citado eliminado correctamente");
    }

    @Override
    public ListResponse<TipoCitadoDTO> getAllTipoCitado(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoCitado> tipoCitadoPage = tipoCitadoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoCitadoDTO> data = tipoCitadoPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoCitadoPage.getTotalElements(), tipoCitadoPage.getTotalPages(), tipoCitadoPage.getNumber() + 1);
    }

    private TipoCitadoDTO convertToDTO(TipoCitado tipoCitado) {
        return modelMapper.map(tipoCitado, TipoCitadoDTO.class);
    }

}
