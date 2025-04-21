package com.saludSystem.application.services;

import com.saludSystem.application.dtos.Principal.GET.ServicioDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearServicioDTO;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarServicioDTO;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.ServicioEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicioServiceImpl implements ServicioService{

    private final ServiceRepository serviceRepository;
    private final ModelMapper modelMapper;

    public ServicioServiceImpl(ServiceRepository serviceRepository, ModelMapper modelMapper) {
        this.serviceRepository = serviceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ServicioDTO> listarTodos() {
        return serviceRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse guardar(CrearServicioDTO crearServicioDTO) {
        ServicioEntity servicioEntity = new ServicioEntity();
        servicioEntity.setNombre(crearServicioDTO.getNombre());
        servicioEntity.setDescripcion(crearServicioDTO.getDescripcion());
        servicioEntity.setEstado(crearServicioDTO.getEstado());
        serviceRepository.save(servicioEntity);
        return new ApiResponse(true, "Servicio creado correctamente");
    }

    @Override
    public ServicioDTO buscarPorId(Long id) {
        ServicioEntity servicioEntity = serviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Servicio no encontrado"));
        return convertToDTO(servicioEntity);
    }

    @Override
    public ApiResponse updateServicio(Long id, ActualizarServicioDTO actualizarServicioDTO) {
        ServicioEntity servicioEntity = serviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Servicio no encontrado"));
        Optional.ofNullable(actualizarServicioDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(servicioEntity::setNombre);
        Optional.ofNullable(actualizarServicioDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(servicioEntity::setDescripcion);
        Optional.ofNullable(actualizarServicioDTO.getEstado()).ifPresent(servicioEntity::setEstado);
        serviceRepository.save(servicioEntity);
        return new ApiResponse(true, "Servicio no encontrado");
    }

    @Override
    public ApiResponse eliminar(Long id) {
        serviceRepository.deleteById(id);
        return new ApiResponse(true, "Servicio eliminado correctamente");
    }

    private ServicioDTO convertToDTO(ServicioEntity servicioEntity) {
        return modelMapper.map(servicioEntity, ServicioDTO.class);
    }

}