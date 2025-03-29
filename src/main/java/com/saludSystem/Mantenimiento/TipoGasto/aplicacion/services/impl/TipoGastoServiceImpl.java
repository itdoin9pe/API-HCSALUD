package com.saludSystem.Mantenimiento.TipoGasto.aplicacion.services.impl;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos.ActualizarTipoGastoDTO;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos.CrearTipoGastoDTO;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.dtos.TipoGastoDTO;
import com.saludSystem.Mantenimiento.TipoGasto.aplicacion.services.TipoGastoService;
import com.saludSystem.Mantenimiento.TipoGasto.dominio.TipoGastoModel;
import com.saludSystem.Mantenimiento.TipoGasto.infraestructura.repository.TipoGastoRepository;
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
public class TipoGastoServiceImpl implements TipoGastoService {

    private final TipoGastoRepository tipoGastoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TipoGastoServiceImpl(TipoGastoRepository tipoGastoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tipoGastoRepository = tipoGastoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoGasto(CrearTipoGastoDTO crearTipoGastoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(userModel.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoGastoModel tipoGastoModel = new TipoGastoModel();
        tipoGastoModel.setNombre(crearTipoGastoDTO.getNombre());
        tipoGastoModel.setEstado(crearTipoGastoDTO.getEstado());
        tipoGastoModel.setHospital(hospital);
        tipoGastoModel.setUser(userModel);
        tipoGastoRepository.save(tipoGastoModel);
        return new ApiResponse(true, "Concepto de gasto registrado correctamente");
    }

    @Override
    public List<TipoGastoDTO> getTipoGastoList() {
        return tipoGastoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<TipoGastoDTO> getAllTipoGasto(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoGastoModel> tipoGastoModelPage = tipoGastoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoGastoDTO> data = tipoGastoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoGastoModelPage.getTotalElements(), tipoGastoModelPage.getTotalPages(), tipoGastoModelPage.getNumber() +1 );
    }

    @Override
    public TipoGastoDTO getTipoGastoById(UUID conceptoGastoId) {
        TipoGastoModel tipoGastoModel = tipoGastoRepository.findById(conceptoGastoId)
                .orElseThrow( () -> new ResourceNotFoundException("Concepto de gasto no encontrado"));
        return convertToDTO(tipoGastoModel);
    }

    @Override
    public ApiResponse updateTipoGasto(UUID conceptoGastoId, ActualizarTipoGastoDTO actualizarTipoGastoDTO) {
        TipoGastoModel tipoGastoModel = tipoGastoRepository.findById(conceptoGastoId)
                .orElseThrow( () -> new ResourceNotFoundException("Concepto de gasto no encontrado"));
        Optional.ofNullable(actualizarTipoGastoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(tipoGastoModel::setNombre);
        Optional.ofNullable(actualizarTipoGastoDTO.getEstado()).ifPresent(tipoGastoModel::setEstado);
        tipoGastoRepository.save(tipoGastoModel);
        return new ApiResponse(true, "Concepto de gasto actualizado correctamente");
    }

    @Override
    public ApiResponse deleteTipoGasto(UUID conceptoGastoId) {
        tipoGastoRepository.deleteById(conceptoGastoId);
        return new ApiResponse(true, "Concepto de gasto eliminado correctamente");
    }

    private TipoGastoDTO convertToDTO(TipoGastoModel tipoGastoModel) {
        return modelMapper.map(tipoGastoModel, TipoGastoDTO.class);
    }

}