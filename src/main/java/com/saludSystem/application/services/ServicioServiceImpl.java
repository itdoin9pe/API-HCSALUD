package com.saludSystem.application.services;

import com.saludSystem.domain.model.ServicioEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService{

    private final ServiceRepository serviceRepository;

    public ServicioServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<ServicioEntity> listarTodos() {
        return serviceRepository.findAll();
    }

    @Override
    public ServicioEntity guardar(ServicioEntity servicio) {
        return serviceRepository.save(servicio);
    }

    @Override
    public Optional<ServicioEntity> buscarPorId(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void eliminar(Long id) {
        serviceRepository.deleteById(id);
    }

}