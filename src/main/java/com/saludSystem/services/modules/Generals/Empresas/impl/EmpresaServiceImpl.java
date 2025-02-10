package com.saludSystem.services.modules.Generals.Empresas.impl;

import com.saludSystem.dtos.Generals.Empresa.ActualizarEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.CrearEmpresaDTO;
import com.saludSystem.dtos.Generals.Empresa.EmpresaDTO;
import com.saludSystem.entities.Empresa;
import com.saludSystem.entities.User;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.UserRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.repositories.modules.Generals.EmpresaRepository;
import com.saludSystem.services.modules.Generals.Empresas.EmpresaService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.empresaRepository = empresaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmpresaDTO> getEmpresaList() {
        return empresaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmpresaDTO> getEmpresaById(UUID empresaId) {
        return Optional.ofNullable(empresaRepository.findById(empresaId)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con Id" + empresaId)));
    }

    @Override
    public ActualizarEmpresaDTO updateEmpresa(UUID empresaId, ActualizarEmpresaDTO actualizarEmpresaDTO) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con ID: " + empresaId));
        Optional.ofNullable(actualizarEmpresaDTO.getDescripcion()).filter(desc -> !desc.isBlank())
                .ifPresent(empresa::setDescripcion);
        Optional.ofNullable(actualizarEmpresaDTO.getEstado()).ifPresent(empresa::setEstado);
        empresaRepository.save(empresa);
        return modelMapper.map(empresa, ActualizarEmpresaDTO.class);
    }


    @Override
    public CrearEmpresaDTO saveEmpresa(CrearEmpresaDTO crearEmpresaDTO){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        //SysSalud sysSalud = sysSaludRepository.findById(user.getHospitalId().getHospitalId())
          //      .orElseThrow(() -> new ResourceNotFoundException("Hospital no encontrado"));

        Empresa empresa = new Empresa();
        empresa.setEmpresaId(UUID.randomUUID());
        empresa.setDescripcion(crearEmpresaDTO.getDescripcion());
        empresa.setEstado(crearEmpresaDTO.getEstado());
        //empresa.setHospitalId(sysSalud);
        empresaRepository.save(empresa);
        return new CrearEmpresaDTO(empresa.getDescripcion(), empresa.getEstado());
    }

    @Override
    public void deleteEmpresa(UUID empresaId) {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa no encontrada con Id: " + empresaId));
        empresaRepository.delete(empresa);
    }

    private EmpresaDTO convertToDTO(Empresa empresa) {
        return modelMapper.map(empresa, EmpresaDTO.class);
    }

}