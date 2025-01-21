package com.saludSystem.services.modules.configuration.SysSalud.impl;

import com.saludSystem.dtos.configuration.SysSaludDTO;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.repositories.modules.Catalogo.PlanRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRespository;
import com.saludSystem.services.modules.configuration.SysSalud.SysSaludService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysSaludServiceImpl implements SysSaludService {

    private final SysSaludRespository sysSaludRespository;
    private final PlanRepository planRepository;
    private final ModelMapper modelMapper;

    public SysSaludServiceImpl(SysSaludRespository sysSaludRespository, PlanRepository planRepository, ModelMapper modelMapper){
        this.sysSaludRespository = sysSaludRespository;
        this.planRepository = planRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SysSalud saveClinica(SysSaludDTO sysSaludDTO) {
        SysSalud sysSalud = new SysSalud();

        sysSalud.setNombre(sysSaludDTO.getNombre());
        sysSalud.setDireccion(sysSaludDTO.getDireccion());
        sysSalud.setCelular(sysSaludDTO.getCelular());
        sysSalud.setEmail(sysSaludDTO.getEmail());
        sysSalud.setRuc(sysSaludDTO.getRuc());
        sysSalud.setFecha(sysSaludDTO.getFecha());
        sysSalud.setFoto(sysSalud.getFoto());
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
