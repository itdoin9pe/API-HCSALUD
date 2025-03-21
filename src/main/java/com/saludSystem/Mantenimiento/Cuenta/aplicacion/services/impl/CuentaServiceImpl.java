package com.saludSystem.Mantenimiento.Cuenta.aplicacion.services.impl;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Mantenimiento.Cuenta.aplicacion.dtos.ActualizarCuentaDTO;
import com.saludSystem.Mantenimiento.Cuenta.aplicacion.dtos.CrearCuentaDTO;
import com.saludSystem.Mantenimiento.Cuenta.aplicacion.dtos.CuentaDTO;
import com.saludSystem.Mantenimiento.Cuenta.aplicacion.services.CuentaService;
import com.saludSystem.Mantenimiento.Cuenta.dominio.CuentaModel;
import com.saludSystem.Mantenimiento.Cuenta.infraestructura.repository.CuentaRepository;
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
public class CuentaServiceImpl implements CuentaService {

    private final CuentaRepository cuentaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CuentaServiceImpl(CuentaRepository cuentaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.cuentaRepository = cuentaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveCuenta(CrearCuentaDTO crearCuentaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(userModel.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CuentaModel cuentaModel = new CuentaModel();
        cuentaModel.setNombre(crearCuentaDTO.getNombre());
        cuentaModel.setTotal(crearCuentaDTO.getTotal());
        cuentaModel.setEstado(crearCuentaDTO.getEstado());
        cuentaModel.setHospital(hospital);
        cuentaModel.setUser(userModel);
        cuentaRepository.save(cuentaModel);
        return new ApiResponse(true, "Cuenta a pagar registrada correctamente");
    }

    @Override
    public List<CuentaDTO> getCuentaList() {
        return cuentaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<CuentaDTO> getAllCuenta(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CuentaModel> cuentaModelPage = cuentaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CuentaDTO> data = cuentaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, cuentaModelPage.getTotalElements(), cuentaModelPage.getTotalPages(), cuentaModelPage.getNumber() +1 );
    }

    @Override
    public ApiResponse updateCuenta(UUID cuentaPagarId, ActualizarCuentaDTO actualizarCuentaDTO) {
        CuentaModel cuentaModel = cuentaRepository.findById(cuentaPagarId).orElseThrow(
                () -> new ResourceNotFoundException("Cuenta no encontrada"));
        Optional.ofNullable(actualizarCuentaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(cuentaModel::setNombre);
        Optional.ofNullable(actualizarCuentaDTO.getTotal()).ifPresent(cuentaModel::setTotal);
        Optional.ofNullable(actualizarCuentaDTO.getEstado()).ifPresent(cuentaModel::setEstado);
        cuentaRepository.save(cuentaModel);
        return new ApiResponse(true, "Cuenta a pagar actualizada correctamente");
    }

    @Override
    public CuentaDTO getCuentaById(UUID cuentaPagarId) {
        CuentaModel cuentaModel = cuentaRepository.findById(cuentaPagarId).orElseThrow(
                () -> new ResourceNotFoundException("Cuenta no encontrada"));
        return convertToDTO(cuentaModel);
    }

    @Override
    public ApiResponse deleteCuenta(UUID cuentaPagarId) {
        cuentaRepository.deleteById(cuentaPagarId);
        return new ApiResponse(true, "Cuenta eliminada correctamente");
    }

    private CuentaDTO convertToDTO(CuentaModel cuentaModel) {
        return modelMapper.map(cuentaModel, CuentaDTO.class);
    }

}
