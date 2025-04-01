package com.saludSystem.Mantenimiento.Cajas.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.dtos.ActualizarCajaDTO;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.dtos.CajaDTO;
import com.saludSystem.Mantenimiento.Cajas.aplicacion.dtos.CrearCajaDTO;
import com.saludSystem.Mantenimiento.Cajas.dominio.CajaModel;
import com.saludSystem.Mantenimiento.Cajas.infraestructura.repository.CajaRepository;
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
public class CajaServiceImpl implements CajaService {

    private final CajaRepository cajaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CajaServiceImpl(CajaRepository cajaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.cajaRepository = cajaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveCaja(CrearCajaDTO crearCajaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(userModel.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CajaModel cajaModel = new CajaModel();
        cajaModel.setNombre(crearCajaDTO.getNombre());
        cajaModel.setEstado(crearCajaDTO.getEstado());
        cajaModel.setHospital(hospital);
        cajaModel.setUser(userModel);
        cajaRepository.save(cajaModel);
        return new ApiResponse(true, "Caja registrado correctamente");
    }

    @Override
    public List<CajaDTO> getCajaList() {
        return cajaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<CajaDTO> getAllCaja(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CajaModel> cajaModelPage = cajaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CajaDTO> data = cajaModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, cajaModelPage.getTotalElements(), cajaModelPage.getTotalPages(), cajaModelPage.getNumber() +1 );
    }

    @Override
    public CajaDTO getCajaById(UUID cajaId) {
        CajaModel cajaModel = cajaRepository.findById(cajaId).orElseThrow( () -> new ResourceNotFoundException("Caja no encontrada"));
        return convertToDTO(cajaModel);
    }

    @Override
    public ApiResponse updateCaja(UUID cajaId, ActualizarCajaDTO actualizarCajaDTO) {
        CajaModel cajaModel = cajaRepository.findById(cajaId).orElseThrow( () -> new ResourceNotFoundException("Caja no encontrada"));
        Optional.ofNullable(actualizarCajaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(cajaModel::setNombre);
        Optional.ofNullable(actualizarCajaDTO.getEstado()).ifPresent(cajaModel::setEstado);
        cajaRepository.save(cajaModel);
        return new ApiResponse(true, "Caja actualizada correctamente");
    }

    @Override
    public ApiResponse deleteCaja(UUID cajaId) {
        cajaRepository.deleteById(cajaId);
        return new ApiResponse(true, "Caja eliminado correctamente");
    }

    CajaDTO convertToDTO(CajaModel cajaModel) {
        return modelMapper.map(cajaModel, CajaDTO.class);
    }

}