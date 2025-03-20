package com.saludSystem.Mantenimiento.Banco.aplicacion.services.impl;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.adapter.Aseguradora.aplicacion.dtos.AseguradoraDTO;
import com.saludSystem.Generals.adapter.Aseguradora.dominio.AseguradoraModel;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.ActualizarBancoDTO;
import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.BancoDTO;
import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.CrearBancoDTO;
import com.saludSystem.Mantenimiento.Banco.aplicacion.services.BancoService;
import com.saludSystem.Mantenimiento.Banco.dominio.BancoModel;
import com.saludSystem.Mantenimiento.Banco.infraestructura.repository.BancoRepository;
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
public class BancoServiceImpl implements BancoService {

    private final BancoRepository bancoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public BancoServiceImpl(BancoRepository bancoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.bancoRepository = bancoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveBanco(CrearBancoDTO crearBancoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        BancoModel bancoModel = new BancoModel();
        bancoModel.setDescripcion(crearBancoDTO.getDescripcion());
        bancoModel.setEstado(crearBancoDTO.getEstado());
        bancoModel.setHospital(hospital);
        bancoModel.setUser(user);
        bancoRepository.save(bancoModel);
        return new ApiResponse(true, "Banco creado correctamente");
    }

    @Override
    public List<BancoDTO> getBancoList() {
        return bancoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public BancoDTO getBancoById(UUID bancoId) {
        BancoModel bancoModel = bancoRepository.findById(bancoId)
                .orElseThrow( () -> new ResourceNotFoundException("Registro de Banco no encontrado"));
        return convertToDTO(bancoModel);
    }

    @Override
    public ListResponse<BancoDTO> getAllBanco(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<BancoModel> bancoModelPage = bancoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<BancoDTO> data = bancoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, bancoModelPage.getTotalElements(), bancoModelPage.getTotalPages(), bancoModelPage.getNumber() + 1);
    }

    @Override
    public ApiResponse updateBanco(UUID bancoId, ActualizarBancoDTO actualizarBancoDTO) {
        BancoModel bancoModel = bancoRepository.findById(bancoId).orElseThrow(
                () -> new ResourceNotFoundException("Registro de banco no encontrado"));
        Optional.ofNullable(actualizarBancoDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(bancoModel::setDescripcion);
        Optional.ofNullable(actualizarBancoDTO.getEstado()).ifPresent(bancoModel::setEstado);
        bancoRepository.save(bancoModel);
        return new ApiResponse(true, "Banco registrado correctamente");
    }

    @Override
    public ApiResponse deleteBanco(UUID bancoId) {
        bancoRepository.deleteById(bancoId);
        return new ApiResponse(true, "Banco eliminado correctamente");
    }

    private BancoDTO convertToDTO(BancoModel bancoModel) {
        return modelMapper.map(bancoModel, BancoDTO.class);
    }
}
