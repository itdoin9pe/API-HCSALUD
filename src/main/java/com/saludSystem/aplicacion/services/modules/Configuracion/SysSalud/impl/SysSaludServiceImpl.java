package com.saludSystem.aplicacion.services.modules.Configuracion.SysSalud.impl;

import com.saludSystem.aplicacion.dtos.Configuracion.SysSalud.ActualizarHospitalDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.SysSalud.CrearSysSaludDTO;
import com.saludSystem.aplicacion.dtos.Configuracion.SysSalud.SysSaludDTO;
import com.saludSystem.aplicacion.dtos.responses.ApiResponse;
import com.saludSystem.aplicacion.dtos.responses.ListResponse;
import com.saludSystem.dominio.entities.Catalogo.Plan;
import com.saludSystem.dominio.entities.Configuracion.SysSalud;
import com.saludSystem.infraestructura.security.exception.ResourceNotFoundException;
import com.saludSystem.infraestructura.repositories.modules.Catalogo.PlanRepository;
import com.saludSystem.infraestructura.repositories.modules.Configuracion.SysSaludRepository;
import com.saludSystem.aplicacion.services.modules.Configuracion.SysSalud.SysSaludService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        Optional<Plan> plan = planRepository.findById(crearSysSaludDTO.getPlanId());
        plan.ifPresent(sysSalud::setPlan);
        sysSalud.setEstado(crearSysSaludDTO.getEstado());

        return sysSaludRespository.save(sysSalud);
    }

    @Override
    public ListResponse<SysSaludDTO> getAllHospital(UUID hospitalId, int page, int rows) {
        List<SysSalud> hospitals = sysSaludRespository.findByHospitalId(hospitalId);
        List<SysSaludDTO> data = hospitals.stream().map(sysSalud -> {
            SysSaludDTO dto = new SysSaludDTO();
            dto.setHospitalId(sysSalud.getHospitalId());
            dto.setNombre(sysSalud.getNombre());
            dto.setDireccion(sysSalud.getDireccion());
            dto.setCelular(sysSalud.getCelular());
            dto.setRuc(sysSalud.getRuc());
            dto.setFecha(sysSalud.getFecha());
            dto.setFoto(sysSalud.getFoto());
            dto.setPlanId(sysSalud.getPlan().getPlanId());
            dto.setEmail(sysSalud.getEmail());
            dto.setEstado(sysSalud.getEstado());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    @Override
    public List<SysSaludDTO> getHospitalList() {
        return sysSaludRespository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ActualizarHospitalDTO updateHospital(UUID hospitalId, ActualizarHospitalDTO actualizarHospitalDTO) {
        SysSalud sysSalud = sysSaludRespository.findById(hospitalId).orElseThrow(
                () -> new ResourceNotFoundException("Hospital not found"));
        Optional.ofNullable(actualizarHospitalDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(sysSalud::setNombre);
        Optional.ofNullable(actualizarHospitalDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(sysSalud::setDireccion);
        Optional.ofNullable(actualizarHospitalDTO.getCelular()).filter(desc -> !desc.isBlank()).ifPresent(sysSalud::setCelular);
        Optional.ofNullable(actualizarHospitalDTO.getRuc()).filter(desc -> !desc.isBlank()).ifPresent(sysSalud::setRuc);
        Optional.ofNullable(actualizarHospitalDTO.getFecha()).ifPresent(sysSalud::setFecha);
        Optional.ofNullable(actualizarHospitalDTO.getFoto()).ifPresent(sysSalud::setFoto);
        Optional.ofNullable(actualizarHospitalDTO.getPlanId()).flatMap(planRepository::findById).ifPresent(sysSalud::setPlan);
        Optional.ofNullable(actualizarHospitalDTO.getEmail()).filter(desc -> !desc.isBlank()).ifPresent(sysSalud::setEmail);
        Optional.ofNullable(actualizarHospitalDTO.getEstado()).ifPresent(sysSalud::setEstado);
        sysSaludRespository.save(sysSalud);
        return modelMapper.map(sysSalud, ActualizarHospitalDTO.class);
    }

    @Override
    public ApiResponse deleteHospital(UUID hospitalId) {
        sysSaludRespository.deleteById(hospitalId);
        return new ApiResponse(true, "Hospital eliminado correctamente");
    }

    @Override
    public Optional<SysSaludDTO> getHospitalBysId(UUID hospitalId) {
        return Optional.ofNullable(sysSaludRespository.findById(hospitalId).map(this::convertToDTO)
                .orElseThrow( () -> new ResourceNotFoundException("Hospital not found")));
    }

    private SysSaludDTO convertToDTO(SysSalud sysSalud) {
        return modelMapper.map(sysSalud, SysSaludDTO.class);
    }

}