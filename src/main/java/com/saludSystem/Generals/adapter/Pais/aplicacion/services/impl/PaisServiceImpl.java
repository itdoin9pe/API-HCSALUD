package com.saludSystem.Generals.adapter.Pais.aplicacion.services.impl;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.adapter.Pais.aplicacion.dtos.CrearPaisDTO;
import com.saludSystem.Generals.adapter.Pais.aplicacion.dtos.PaisDTO;
import com.saludSystem.Generals.adapter.Pais.aplicacion.services.PaisService;
import com.saludSystem.Generals.adapter.Pais.domain.PaisModel;
import com.saludSystem.Generals.adapter.Pais.infraestructura.repositories.PaisRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public PaisServiceImpl(PaisRepository paisRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.paisRepository = paisRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse savePais(CrearPaisDTO crearPaisDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        PaisModel pais = new PaisModel();
        pais.setIso(crearPaisDTO.getIso());
        pais.setNombre(crearPaisDTO.getNombre());
        pais.setGentilicio(crearPaisDTO.getGentilicio());
        pais.setOrden(crearPaisDTO.getOrden());
        pais.setUser(user);
        pais.setHospital(hospital);
        paisRepository.save(pais);
        return new ApiResponse(true, "Pais registrado correctamente");
    }

    @Override
    public ListResponse<PaisDTO> getAllPais(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PaisModel> paisModelPage = paisRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PaisDTO> data = paisModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, paisModelPage.getTotalElements(), paisModelPage.getTotalPages(), paisModelPage.getNumber() + 1);
    }

    @Override
    public List<PaisDTO> getPaisList() {
        return paisRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PaisDTO convertToDTO(PaisModel pais) {
        return modelMapper.map(pais, PaisDTO.class);
    }

}