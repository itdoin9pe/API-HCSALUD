package com.saludSystem.Configuracion.SysSalud.aplicacion.services;

import com.saludSystem.Catalogo.Plan.dominio.PlanModel;
import com.saludSystem.Catalogo.Plan.infraestructura.repositories.PlanRepository;
import com.saludSystem.Configuracion.SysSalud.aplicacion.dtos.ActualizarHospitalDTO;
import com.saludSystem.Configuracion.SysSalud.aplicacion.dtos.CrearSysSaludDTO;
import com.saludSystem.Configuracion.SysSalud.aplicacion.dtos.SysSaludDTO;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public SysSaludModel saveClinica(CrearSysSaludDTO crearSysSaludDTO) {
        SysSaludModel sysSalud = new SysSaludModel();

        sysSalud.setNombre(crearSysSaludDTO.getNombre());
        sysSalud.setDireccion(crearSysSaludDTO.getDireccion());
        sysSalud.setCelular(crearSysSaludDTO.getCelular());
        sysSalud.setEmail(crearSysSaludDTO.getEmail());
        sysSalud.setRuc(crearSysSaludDTO.getRuc());
        sysSalud.setFecha(crearSysSaludDTO.getFecha());
        sysSalud.setFoto(crearSysSaludDTO.getFoto());
        Optional<PlanModel> plan = planRepository.findById(crearSysSaludDTO.getPlanId());
        plan.ifPresent(sysSalud::setPlan);
        sysSalud.setEstado(crearSysSaludDTO.getEstado());

        return sysSaludRespository.save(sysSalud);
    }

    @Override
    public ListResponse<SysSaludDTO> getAllHospital(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<SysSaludModel> medidasPage = sysSaludRespository.findByHospitalId(hospitalId, pageable);
        List<SysSaludDTO> data = medidasPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, medidasPage.getTotalElements(), medidasPage.getTotalPages(), medidasPage.getNumber() + 1);
    }

    @Override
    public List<SysSaludDTO> getHospitalList() {
        return sysSaludRespository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ActualizarHospitalDTO updateHospital(UUID hospitalId, ActualizarHospitalDTO actualizarHospitalDTO) {
        SysSaludModel sysSalud = sysSaludRespository.findById(hospitalId).orElseThrow(
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

    private SysSaludDTO convertToDTO(SysSaludModel sysSalud) {
        return modelMapper.map(sysSalud, SysSaludDTO.class);
    }

}