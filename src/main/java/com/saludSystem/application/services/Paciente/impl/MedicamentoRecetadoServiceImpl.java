package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.MedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearMedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarMedicamentoRecetadoDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.MedicamentoRecetadoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Catalogo.MedicamentoEntity;
import com.saludSystem.domain.model.Paciente.MedicamentoRecetadoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.MedicamentoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.MedicamentoRecetadoRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentoRecetadoServiceImpl extends GenericServiceImpl<MedicamentoRecetadoEntity,
        MedicamentoRecetadoDTO, UUID, CrearMedicamentoRecetadoDTO, ActualizarMedicamentoRecetadoDTO>
        implements MedicamentoRecetadoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoRecetadoServiceImpl(
            MedicamentoRecetadoRepository medicamentoRecetadoRepository, ModelMapper modelMapper,
            AuthValidator authValidator, MedicamentoRepository medicamentoRepository) {
        super(medicamentoRecetadoRepository, modelMapper, authValidator, MedicamentoRecetadoDTO.class,
                medicamentoRecetadoEntity -> modelMapper.map(medicamentoRecetadoEntity,
                        MedicamentoRecetadoDTO.class));
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    protected MedicamentoRecetadoEntity convertCreateDtoToEntity(CrearMedicamentoRecetadoDTO crearMedicamentoRecetadoDTO) {
        MedicamentoRecetadoEntity entity = new MedicamentoRecetadoEntity();
        MedicamentoEntity medicamento = medicamentoRepository.findById(crearMedicamentoRecetadoDTO.getMedicamentoId())
                .orElseThrow( () -> new ResourceNotFoundException("Medicamento not found"));
        entity.setDosis(crearMedicamentoRecetadoDTO.getDosis());
        entity.setFrecuencia(crearMedicamentoRecetadoDTO.getFrecuencia());
        entity.setIndicaciones(crearMedicamentoRecetadoDTO.getIndicaciones());
        entity.setDuracionDias(crearMedicamentoRecetadoDTO.getDuracionDias());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarMedicamentoRecetadoDTO actualizarMedicamentoRecetadoDTO, MedicamentoRecetadoEntity entity) {
        Optional.ofNullable(actualizarMedicamentoRecetadoDTO.getMedicamentoId()).flatMap(medicamentoRepository::findById).
                ifPresent(entity::setMedicamentoEntity);
        entity.setDosis(actualizarMedicamentoRecetadoDTO.getDosis());
        entity.setFrecuencia(actualizarMedicamentoRecetadoDTO.getFrecuencia());
        entity.setIndicaciones(actualizarMedicamentoRecetadoDTO.getIndicaciones());
        entity.setDuracionDias(actualizarMedicamentoRecetadoDTO.getDuracionDias());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearMedicamentoRecetadoDTO crearMedicamentoRecetadoDTO) {
        return super.save(crearMedicamentoRecetadoDTO);
    }

    @Override
    public ListResponse<MedicamentoRecetadoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarMedicamentoRecetadoDTO actualizarMedicamentoRecetadoDTO) {
        return super.update(uuid, actualizarMedicamentoRecetadoDTO);
    }

    @Override
    public List<MedicamentoRecetadoDTO> getList() {
        return super.getList();
    }

    @Override
    public MedicamentoRecetadoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}