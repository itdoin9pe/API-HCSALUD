package com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.ActualizarTipoTarjetaDTO;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.CrearTipoTarjetaDTO;
import com.saludSystem.Mantenimiento.TipoTarjeta.aplicacion.dtos.TipoTarjetaDTO;
import com.saludSystem.Mantenimiento.TipoTarjeta.dominio.TipoTarjetaModel;
import com.saludSystem.Mantenimiento.TipoTarjeta.infraestructura.repository.TipoTarjetaRepository;
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
public class TipoTarjetaServiceImpl implements TipoTarjetaService {

    private final TipoTarjetaRepository tipoTarjetaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TipoTarjetaServiceImpl(TipoTarjetaRepository tipoTarjetaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tipoTarjetaRepository = tipoTarjetaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoTarjeta(CrearTipoTarjetaDTO crearTipoTarjetaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoTarjetaModel tipoTarjetaModel = new TipoTarjetaModel();
        tipoTarjetaModel.setDescripcion(crearTipoTarjetaDTO.getDescripcion());
        tipoTarjetaModel.setEstado(crearTipoTarjetaDTO.getEstado());
        tipoTarjetaModel.setHospital(hospital);
        tipoTarjetaModel.setUser(user);
        tipoTarjetaRepository.save(tipoTarjetaModel);
        return new ApiResponse(true, "Tipo tarjeta registrada correctamente");
    }

    @Override
    public List<TipoTarjetaDTO> getTipoTarjetaList() {
        return tipoTarjetaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<TipoTarjetaDTO> getAllTipoTarjeta(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoTarjetaModel> tipoTarjetaModelPage = tipoTarjetaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoTarjetaDTO> data = tipoTarjetaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoTarjetaModelPage.getTotalElements(), tipoTarjetaModelPage.getTotalPages(), tipoTarjetaModelPage.getNumber() + 1);
    }

    @Override
    public TipoTarjetaDTO getTipoTarjetaById(UUID tipoTarjetaId) {
        TipoTarjetaModel tipoTarjetaModel = tipoTarjetaRepository.findById(tipoTarjetaId)
                .orElseThrow( () -> new ResourceNotFoundException("Tipo de tarjeta no encontrado"));
        return convertToDTO(tipoTarjetaModel);
    }

    @Override
    public ApiResponse updateTipoTarjeta(UUID tipoTarjetaId, ActualizarTipoTarjetaDTO actualizarTipoTarjetaDTO) {
        TipoTarjetaModel tipoTarjetaModel = tipoTarjetaRepository.findById(tipoTarjetaId).orElseThrow(
                () -> new ResourceNotFoundException("Tipo de tarjeta no encontrada"));
        Optional.ofNullable(actualizarTipoTarjetaDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(tipoTarjetaModel::setDescripcion);
        Optional.ofNullable(actualizarTipoTarjetaDTO.getEstado()).ifPresent(tipoTarjetaModel::setEstado);
        tipoTarjetaRepository.save(tipoTarjetaModel);
        return new ApiResponse(true, "Tipo tarjeta actualizada correctamente");
    }

    @Override
    public ApiResponse deleteTipoTarjeta(UUID tipoTarjetaId) {
        tipoTarjetaRepository.deleteById(tipoTarjetaId);
        return new ApiResponse(true,  "Tipo Tarjeta eliminado correctamente");
    }

    private TipoTarjetaDTO convertToDTO(TipoTarjetaModel tipoTarjetaModel) {
        return modelMapper.map(tipoTarjetaModel, TipoTarjetaDTO.class);
    }

}