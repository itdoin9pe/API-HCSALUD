package com.saludSystem.Catalogo.Clientes.aplicacion.services;

import com.saludSystem.Catalogo.Clientes.aplicacion.dtos.ActualizarClienteDTO;
import com.saludSystem.Catalogo.Clientes.aplicacion.dtos.ClienteDTO;
import com.saludSystem.Catalogo.Clientes.aplicacion.dtos.CrearClienteDTO;
import com.saludSystem.Catalogo.Clientes.dominio.ClienteModel;
import com.saludSystem.Catalogo.Clientes.infraestructura.repositories.ClienteRepository;
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
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setTipoDocumento(crearClienteDTO.getTipoDocumento());
        clienteModel.setNombre(crearClienteDTO.getNombre());
        clienteModel.setDireccion(crearClienteDTO.getDireccion());
        clienteModel.setContacto(crearClienteDTO.getContacto());
        clienteModel.setTelefono(crearClienteDTO.getTelefono());
        clienteModel.setEmail(crearClienteDTO.getEmail());
        clienteModel.setEstado(crearClienteDTO.getEstado());
        clienteModel.setUser(user);
        clienteModel.setHospital(hospital);
        clienteRepository.save(clienteModel);
        return new ApiResponse(true,  "Cliente registrado correctamente");
    }

    @Override
    public ApiResponse updateCliente(UUID clienteId, ActualizarClienteDTO actualizarClienteDTO) {
        ClienteModel clienteModel = clienteRepository.findById(clienteId)
                .orElseThrow( () -> new ResourceNotFoundException("Cliente no encontrado"));
        Optional.ofNullable(actualizarClienteDTO.getTipoDocumento()).filter(desc -> !desc.isBlank()).ifPresent(clienteModel::setTipoDocumento);
        Optional.ofNullable(actualizarClienteDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(clienteModel::setNombre);
        Optional.ofNullable(actualizarClienteDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(clienteModel::setDireccion);
        Optional.ofNullable(actualizarClienteDTO.getContacto()).filter(desc -> !desc.isBlank()).ifPresent(clienteModel::setContacto);
        Optional.ofNullable(actualizarClienteDTO.getTelefono()).filter(desc -> !desc.isBlank()).ifPresent(clienteModel::setTelefono);
        Optional.ofNullable(actualizarClienteDTO.getEmail()).filter(desc -> !desc.isBlank()).ifPresent(clienteModel::setEmail);
        Optional.ofNullable(actualizarClienteDTO.getEstado()).ifPresent(clienteModel::setEstado);
        clienteRepository.save(clienteModel);
        return new ApiResponse(true, "Cliente actualizado correctamente");
    }

    @Override
    public ClienteDTO getClienteById(UUID clienteId) {
        ClienteModel clienteModel = clienteRepository.findById(clienteId).orElseThrow(
                () -> new ResourceNotFoundException("Cliente no encontrado"));
        return convertToDTO(clienteModel);
    }

    @Override
    public ApiResponse deleteCliente(UUID clienteId) {
        clienteRepository.deleteById(clienteId);
        return new ApiResponse(true, "Cliente eliminado correctamente");
    }

    @Override
    public ListResponse<ClienteDTO> getAllCliente(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ClienteModel> clienteModelPage = clienteRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ClienteDTO> data = clienteModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, clienteModelPage.getTotalElements(), clienteModelPage.getTotalPages(), clienteModelPage.getNumber() + 1);
    }

    private ClienteDTO convertToDTO(ClienteModel clienteModel) {
        return modelMapper.map(clienteModel, ClienteDTO.class);
    }

}