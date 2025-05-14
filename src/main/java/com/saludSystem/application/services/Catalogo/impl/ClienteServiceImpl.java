package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarClienteDTO;
import com.saludSystem.application.dtos.Catalogo.GET.ClienteDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearClienteDTO;
import com.saludSystem.application.services.Catalogo.ClienteService;
import com.saludSystem.domain.model.Catalogo.ClienteEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.ClienteRepository;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
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
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.clienteRepository = clienteRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveCliente(CrearClienteDTO crearClienteDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setTipoDocumento(crearClienteDTO.getTipoDocumento());
        clienteEntity.setNombre(crearClienteDTO.getNombre());
        clienteEntity.setDireccion(crearClienteDTO.getDireccion());
        clienteEntity.setContacto(crearClienteDTO.getContacto());
        clienteEntity.setTelefono(crearClienteDTO.getTelefono());
        clienteEntity.setEmail(crearClienteDTO.getEmail());
        clienteEntity.setEstado(crearClienteDTO.getEstado());
        clienteEntity.setUser(user);
        clienteEntity.setHospital(hospital);
        clienteRepository.save(clienteEntity);
        return new ApiResponse(true,  "Cliente registrado correctamente");
    }

    @Override
    public ApiResponse updateCliente(UUID clienteId, ActualizarClienteDTO actualizarClienteDTO) {
        ClienteEntity clienteEntity = clienteRepository.findById(clienteId)
                .orElseThrow( () -> new ResourceNotFoundException("Cliente no encontrado"));
        Optional.ofNullable(actualizarClienteDTO.getTipoDocumento()).filter(desc -> !desc.isBlank()).ifPresent(clienteEntity::setTipoDocumento);
        Optional.ofNullable(actualizarClienteDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(clienteEntity::setNombre);
        Optional.ofNullable(actualizarClienteDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(clienteEntity::setDireccion);
        Optional.ofNullable(actualizarClienteDTO.getContacto()).filter(desc -> !desc.isBlank()).ifPresent(clienteEntity::setContacto);
        Optional.ofNullable(actualizarClienteDTO.getTelefono()).filter(desc -> !desc.isBlank()).ifPresent(clienteEntity::setTelefono);
        Optional.ofNullable(actualizarClienteDTO.getEmail()).filter(desc -> !desc.isBlank()).ifPresent(clienteEntity::setEmail);
        Optional.ofNullable(actualizarClienteDTO.getEstado()).ifPresent(clienteEntity::setEstado);
        clienteRepository.save(clienteEntity);
        return new ApiResponse(true, "Cliente actualizado correctamente");
    }

    @Override
    public ClienteDTO getClienteById(UUID clienteId) {
        ClienteEntity clienteEntity = clienteRepository.findById(clienteId).orElseThrow(
                () -> new ResourceNotFoundException("Cliente no encontrado"));
        return convertToDTO(clienteEntity);
    }

    @Override
    public ApiResponse deleteCliente(UUID clienteId) {
        clienteRepository.deleteById(clienteId);
        return new ApiResponse(true, "Cliente eliminado correctamente");
    }

    @Override
    public ListResponse<ClienteDTO> getAllCliente(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ClienteEntity> clienteModelPage = clienteRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ClienteDTO> data = clienteModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, clienteModelPage.getTotalElements(), clienteModelPage.getTotalPages(), clienteModelPage.getNumber() + 1);
    }

    private ClienteDTO convertToDTO(ClienteEntity clienteEntity) {
        return modelMapper.map(clienteEntity, ClienteDTO.class);
    }

}