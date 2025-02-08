package com.saludSystem.services.modules.configuration.SysSalud.impl;

import com.saludSystem.dtos.configuration.SysSaludModule.CrearSysSaludDTO;
import com.saludSystem.dtos.configuration.SysSaludModule.SysSaludDTO;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.repositories.modules.Catalogo.PlanRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.services.modules.configuration.SysSalud.SysSaludService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysSaludServiceImpl implements SysSaludService {

    private final SysSaludRepository sysSaludRespository;
    private final PlanRepository planRepository;
    private final ModelMapper modelMapper;

    public SysSaludServiceImpl(SysSaludRepository sysSaludRespository, PlanRepository planRepository, ModelMapper modelMapper){
        this.sysSaludRespository = sysSaludRespository;
        this.planRepository = planRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SysSalud saveClinica(CrearSysSaludDTO crearSysSaludDTO) {
        SysSalud sysSalud = new SysSalud();

        sysSalud.setNombre(crearSysSaludDTO.getNombre());
        sysSalud.setDireccion(crearSysSaludDTO.getDireccion());
        sysSalud.setCelular(crearSysSaludDTO.getCelular());
        sysSalud.setEmail(crearSysSaludDTO.getEmail());
        sysSalud.setRuc(crearSysSaludDTO.getRuc());
        sysSalud.setFecha(crearSysSaludDTO.getFecha());
        sysSalud.setFoto(crearSysSaludDTO.getFoto());
        //DESCOMENTAR:
        // Optional<Plan> plan = planRepository.findById(sysSaludDTO.getPlanId());
        // plan.ifPresent(sysSalud::setPlanId);
        sysSalud.setEstado(sysSalud.getEstado());

        return sysSaludRespository.save(sysSalud);
    }

    @Override
    public List<SysSaludDTO> getAllClinica(int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<SysSalud> hospitalPage = sysSaludRespository.findAll(pageable);
        return hospitalPage.getContent().stream()
                .map(hospital -> modelMapper.map(hospital, SysSaludDTO.class))
                .toList();
    }

    @Override
    public long getTotalCount() {
        return sysSaludRespository.count();
    }
}
