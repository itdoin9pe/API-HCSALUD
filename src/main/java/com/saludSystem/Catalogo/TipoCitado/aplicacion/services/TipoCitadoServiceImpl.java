package com.saludSystem.Catalogo.TipoCitado.aplicacion.services;

import com.saludSystem.Catalogo.TipoCitado.aplicacion.dtos.ActualizarTipoCitadoDTO;
import com.saludSystem.Catalogo.TipoCitado.aplicacion.dtos.CrearTipoCitadoDTO;
import com.saludSystem.Catalogo.TipoCitado.aplicacion.dtos.TipoCitadoDTO;
import com.saludSystem.Catalogo.TipoCitado.dominio.TipoCitadoModel;
import com.saludSystem.Catalogo.TipoCitado.infraestructura.repositories.TipoCitadoRepository;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
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
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoCitadoModel tipoCitado = new TipoCitadoModel();
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
        TipoCitadoModel tipoCitado = tipoCitadoRepository.findById(tipoCitadoId).orElseThrow(
                () -> new ResourceNotFoundException("Tipo de citado no encontrado"));
        Optional.ofNullable(actualizarTipoCitadoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(tipoCitado::setNombre);
        Optional.ofNullable(actualizarTipoCitadoDTO.getColor()).filter(desc -> !desc.isBlank()).ifPresent(tipoCitado::setColor);
        Optional.ofNullable(actualizarTipoCitadoDTO.getEstado()).ifPresent(tipoCitado::setEstado);
        tipoCitadoRepository.save(tipoCitado);
        return new ApiResponse(true, "Tipo de citado actualizado correctamente");
    }

    @Override
    public TipoCitadoDTO getTipoCitadoById(UUID tipoCitadoId) {
        TipoCitadoModel tipoCitado = tipoCitadoRepository.findById(tipoCitadoId)
                .orElseThrow( () -> new ResourceNotFoundException("Tipo de citado no encontrado"));
        return convertToDTO(tipoCitado);
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
        Page<TipoCitadoModel> tipoCitadoPage = tipoCitadoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoCitadoDTO> data = tipoCitadoPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoCitadoPage.getTotalElements(), tipoCitadoPage.getTotalPages(), tipoCitadoPage.getNumber() + 1);
    }

    private TipoCitadoDTO convertToDTO(TipoCitadoModel tipoCitado) {
        return modelMapper.map(tipoCitado, TipoCitadoDTO.class);
    }

}
