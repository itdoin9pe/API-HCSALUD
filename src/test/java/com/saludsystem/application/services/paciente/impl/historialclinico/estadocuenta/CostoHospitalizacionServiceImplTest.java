package com.saludsystem.application.services.paciente.impl.historialclinico.estadocuenta;

import com.saludsystem.application.dtos.paciente.get.historialclinico.estadocuenta.CostoHospitalizacionDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.estadocuenta.CrearCostoHospitalizacionDTO;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.configuracion.UserEntity;
import com.saludsystem.domain.model.paciente.EstadoCuenta.CostoHospitalizacionEntity;
import com.saludsystem.domain.model.paciente.EstadoCuenta.EstadoCuentaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta.CostoHospitalizacionRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.EstadoCuenta.EstadoCuentaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CostoHospitalizacionServiceImplTest {

    private CostoHospitalizacionServiceImpl service;

    private CostoHospitalizacionRepository repository;
    private EstadoCuentaRepository estadoCuentaRepository;
    private ModelMapper modelMapper;
    private AuthValidator authValidator;

    @BeforeEach
    void setUp() {
        repository = mock(CostoHospitalizacionRepository.class);
        estadoCuentaRepository = mock(EstadoCuentaRepository.class);
        modelMapper = new ModelMapper();
        authValidator = mock(AuthValidator.class);
        service = new CostoHospitalizacionServiceImpl(repository, modelMapper, authValidator, estadoCuentaRepository);
    }

    @Test
    void testSaveSuccess() {
        CrearCostoHospitalizacionDTO dto = new CrearCostoHospitalizacionDTO();
        dto.setPacEstadoCuentaId(UUID.randomUUID());
        dto.setFechaIngreso(LocalDate.now());
        dto.setFechaAlta(LocalDate.now().plusDays(5));
        dto.setTipoHabitacion("Privada");
        dto.setCostoPorDia(100.0);
        dto.setCantidadDias(5);
        dto.setTotalCosto(500.0);

        EstadoCuentaEntity estadoCuenta = new EstadoCuentaEntity();
        when(estadoCuentaRepository.findById(dto.getPacEstadoCuentaId()))
                .thenReturn(Optional.of(estadoCuenta));

        UserEntity mockUser = new UserEntity();
        mockUser.setHospital(mock());
        when(authValidator.getCurrentUser()).thenReturn(mockUser);

        doNothing().when(authValidator).validateAdminAccess();

        ApiResponse response = service.save(dto);

        assertTrue(response.isSuccess());
        assertEquals("Registro creado exitosamente", response.getMessage());
    }

    @Test
    void testGetByIdSuccess() {
        UUID id = UUID.randomUUID();
        CostoHospitalizacionEntity entity = new CostoHospitalizacionEntity();
        entity.setCostoPorDia(100.0);
        when(repository.findById(id)).thenReturn(Optional.of(entity));

        CostoHospitalizacionDTO dto = service.getById(id);

        assertNotNull(dto);
        assertEquals(100.0, dto.getCostoPorDia());
    }

    @Test
    void testGetList() {
        CostoHospitalizacionEntity entity = new CostoHospitalizacionEntity();
        entity.setCostoPorDia(50.0);
        when(repository.findAll()).thenReturn(List.of(entity));

        List<CostoHospitalizacionDTO> result = service.getList();

        assertEquals(1, result.size());
        assertEquals(50.0, result.get(0).getCostoPorDia());
    }

    @Test
    void testDelete() {
        UUID id = UUID.randomUUID();
        ApiResponse response = service.delete(id);
        verify(repository).deleteById(id);
        assertTrue(response.isSuccess());
    }

    @Test
    void testSaveThrowsWhenEstadoCuentaNotFound() {
        CrearCostoHospitalizacionDTO dto = new CrearCostoHospitalizacionDTO();
        dto.setPacEstadoCuentaId(UUID.randomUUID());

        when(estadoCuentaRepository.findById(dto.getPacEstadoCuentaId()))
                .thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.save(dto));
    }
}