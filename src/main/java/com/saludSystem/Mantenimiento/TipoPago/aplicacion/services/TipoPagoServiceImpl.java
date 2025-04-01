package com.saludSystem.Mantenimiento.TipoPago.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos.ActualizarTipoPagoDTO;
import com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos.CrearTipoPagoDTO;
import com.saludSystem.Mantenimiento.TipoPago.aplicacion.dtos.TipoPagoDTO;
import com.saludSystem.Mantenimiento.TipoPago.dominio.TipoPagoModel;
import com.saludSystem.Mantenimiento.TipoPago.infraestructura.repository.TipoPagoRepository;
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
public class TipoPagoServiceImpl implements TipoPagoService {

    private final TipoPagoRepository tipoPagoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TipoPagoServiceImpl(TipoPagoRepository tipoPagoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tipoPagoRepository = tipoPagoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoPago(CrearTipoPagoDTO crearTipoPagoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoPagoModel tipoPagoModel = new TipoPagoModel();
        tipoPagoModel.setMetodoPago(crearTipoPagoDTO.getMetodoPago());
        tipoPagoModel.setDescripcion(crearTipoPagoDTO.getDescripcion());
        tipoPagoModel.setEstado(crearTipoPagoDTO.getEstado());
        tipoPagoModel.setUser(user);
        tipoPagoModel.setHospital(hospital);
        tipoPagoRepository.save(tipoPagoModel);
        return new ApiResponse(true, "Tipo pago registrado correctamente");
    }

    @Override
    public ListResponse<TipoPagoDTO> getAllTipoPago(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoPagoModel> tipoPagoModelPage = tipoPagoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoPagoDTO> data = tipoPagoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoPagoModelPage.getTotalElements(), tipoPagoModelPage.getTotalPages(), tipoPagoModelPage.getNumber() + 1);
    }

    @Override
    public List<TipoPagoDTO> getListTipoPago() {
        return tipoPagoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TipoPagoDTO getTipoPagoById(UUID tipoPagoId) {
        TipoPagoModel tipoPagoModel = tipoPagoRepository.findById(tipoPagoId).orElseThrow( () -> new ResourceNotFoundException("Tipo Pago no encontrado"));
        return convertToDTO(tipoPagoModel);
    }

    @Override
    public ApiResponse updateTipoPago(UUID tipoPagoId, ActualizarTipoPagoDTO actualizarTipoPagoDTO) {
        TipoPagoModel tipoPagoModel = tipoPagoRepository.findById(tipoPagoId).orElseThrow(
                () -> new ResourceNotFoundException("Tipo pago no encontrado"));
        Optional.ofNullable(actualizarTipoPagoDTO.getMetodoPago()).filter(desc -> !desc.isBlank()).ifPresent(tipoPagoModel::setMetodoPago);
        Optional.ofNullable(actualizarTipoPagoDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(tipoPagoModel::setDescripcion);
        Optional.ofNullable(actualizarTipoPagoDTO.getEstado()).ifPresent(tipoPagoModel::setEstado);
        tipoPagoRepository.save(tipoPagoModel);
        return new ApiResponse(true, "Tipo pago actualizado correctamente");
    }

    @Override
    public ApiResponse deleteTipoPago(UUID tipoPagoId) {
        tipoPagoRepository.deleteById(tipoPagoId);
        return new ApiResponse(true, "Tipo pago eliminado correctamente");
    }

    private TipoPagoDTO convertToDTO(TipoPagoModel tipoPagoModel) {
        return modelMapper.map(tipoPagoModel, TipoPagoDTO.class);
    }

}