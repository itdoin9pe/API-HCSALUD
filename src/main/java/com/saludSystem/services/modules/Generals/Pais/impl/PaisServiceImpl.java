package com.saludSystem.services.modules.Generals.Pais.impl;

import com.saludSystem.dtos.Generals.Pais.CrearPaisDTO;
import com.saludSystem.dtos.Generals.Pais.PaisDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.Pais;
import com.saludSystem.entities.User;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.repositories.UserRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.repositories.modules.Generals.PaisRepository;
import com.saludSystem.services.modules.Generals.Pais.PaisService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        Pais pais = new Pais();
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
        List<Pais> paises = paisRepository.findByHospital_HospitalId(hospitalId);
        List<PaisDTO> data = paises.stream().map(pais -> {
            PaisDTO dto = new PaisDTO();
            dto.setPaisId(pais.getId());
            dto.setIso(pais.getIso());
            dto.setNombre(pais.getNombre());
            dto.setGentilicio(pais.getGentilicio());
            dto.setOrden(pais.getOrden());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    @Override
    public List<PaisDTO> getPaisList() {
        return paisRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private PaisDTO convertToDTO(Pais pais) {
        return modelMapper.map(pais, PaisDTO.class);
    }

}
