package com.saludSystem.application.services.Mantenimiento.impl;

import com.saludSystem.application.services.Mantenimiento.TarifarioService;
import com.saludSystem.domain.model.Catalogo.CategoriaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.CategoriaRepository;
import com.saludSystem.domain.model.Catalogo.MedidaEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.MedidaRepository;
import com.saludSystem.domain.model.Catalogo.TipoConceptoEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.TipoConceptoRepository;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Mantenimiento.PUT.ActualizarTarifarioDTO;
import com.saludSystem.application.dtos.Mantenimiento.POST.CrearTarifarioDTO;
import com.saludSystem.application.dtos.Mantenimiento.GET.TarifarioDTO;
import com.saludSystem.domain.model.Mantenimiento.TarifarioEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.TarifarioRepository;
import com.saludSystem.domain.model.Operaciones.UnidadEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.UnidadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TarifarioServiceImpl implements TarifarioService {

    private final TarifarioRepository tarifarioRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final TipoConceptoRepository tipoConceptoRepository;
    private final CategoriaRepository categoriaRepository;
    private final UnidadRepository unidadRepository;
    private final MedidaRepository medidaRepository;
    private final ModelMapper modelMapper;

    public TarifarioServiceImpl(TarifarioRepository tarifarioRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, TipoConceptoRepository tipoConceptoRepository, CategoriaRepository categoriaRepository, UnidadRepository unidadRepository, MedidaRepository medidaRepository, ModelMapper modelMapper) {
        this.tarifarioRepository = tarifarioRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.tipoConceptoRepository = tipoConceptoRepository;
        this.categoriaRepository = categoriaRepository;
        this.unidadRepository = unidadRepository;
        this.medidaRepository = medidaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTarifario(CrearTarifarioDTO crearTarifarioDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TarifarioEntity tarifarioEntity = new TarifarioEntity();
        Optional<TipoConceptoEntity> tipoConceptoModel = tipoConceptoRepository.findById(crearTarifarioDTO.getTipoConceptoId());
        tipoConceptoModel.ifPresent(tarifarioEntity::setTipoConceptoEntity);
        Optional<CategoriaEntity> categoriaModel = categoriaRepository.findById(crearTarifarioDTO.getCategoriaId());
        categoriaModel.ifPresent(tarifarioEntity::setCategoriaEntity);
        Optional<UnidadEntity> unidadModel = unidadRepository.findById(crearTarifarioDTO.getUnidadId());
        unidadModel.ifPresent(tarifarioEntity::setUnidadEntity);
        Optional<MedidaEntity> medidaModel = medidaRepository.findById(crearTarifarioDTO.getMedidaId());
        medidaModel.ifPresent(tarifarioEntity::setMedidaEntity);
        tarifarioEntity.setGrupo(crearTarifarioDTO.getGrupo());
        tarifarioEntity.setDescripcion(crearTarifarioDTO.getDescripcion());
        tarifarioEntity.setPrecio(crearTarifarioDTO.getPrecio());
        tarifarioEntity.setEstado(crearTarifarioDTO.getEstado());
        tarifarioEntity.setHospital(hospital);
        tarifarioEntity.setUser(userEntity);
        tarifarioRepository.save(tarifarioEntity);
        return new ApiResponse(true, "Tarifario registrado correctamente");
    }

    @Override
    public ListResponse<TarifarioDTO> getAllTarifario(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TarifarioEntity> tarifarioModelPage = tarifarioRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TarifarioDTO> data = tarifarioModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tarifarioModelPage.getTotalElements(), tarifarioModelPage.getTotalPages(), tarifarioModelPage.getNumber() +1 );
    }

    @Override
    public List<TarifarioDTO> getTarifarioList() {
        return tarifarioRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TarifarioDTO getTarifarioById(UUID tarifarioId) {
        TarifarioEntity tarifarioEntity = tarifarioRepository.findById(tarifarioId).orElseThrow( () -> new ResourceNotFoundException("Tarifario no encontrado"));
        return convertToDTO(tarifarioEntity);
    }

    @Override
    public ApiResponse updateTarifario(UUID tarifarioId, ActualizarTarifarioDTO actualizarTarifarioDTO) {
        TarifarioEntity tarifarioEntity = tarifarioRepository.findById(tarifarioId).orElseThrow(() -> new ResourceNotFoundException("Tarifario no encontrado"));
        Optional.ofNullable(actualizarTarifarioDTO.getTipoConceptoId()).flatMap(tipoConceptoRepository::findById).ifPresent(tarifarioEntity::setTipoConceptoEntity);
        Optional.ofNullable(actualizarTarifarioDTO.getCategoriaId()).flatMap(categoriaRepository::findById).ifPresent(tarifarioEntity::setCategoriaEntity);
        Optional.ofNullable(actualizarTarifarioDTO.getUnidadId()).flatMap(unidadRepository::findById).ifPresent(tarifarioEntity::setUnidadEntity);
        Optional.ofNullable(actualizarTarifarioDTO.getMedidaId()).flatMap(medidaRepository::findById).ifPresent(tarifarioEntity::setMedidaEntity);
        Optional.ofNullable(actualizarTarifarioDTO.getGrupo()).filter(desc -> !desc.isBlank()).ifPresent(tarifarioEntity::setGrupo);
        Optional.ofNullable(actualizarTarifarioDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(tarifarioEntity::setDescripcion);
        Optional.ofNullable(actualizarTarifarioDTO.getPrecio()).ifPresent(tarifarioEntity::setPrecio);
        Optional.ofNullable(actualizarTarifarioDTO.getEstado()).ifPresent(tarifarioEntity::setEstado);
        tarifarioRepository.save(tarifarioEntity);
        return new ApiResponse(true, "Tarifario actualizado correctamente");
    }

    @Override
    public ApiResponse deleteTarifario(UUID tarifarioId) {
        tarifarioRepository.deleteById(tarifarioId);
        return new ApiResponse(true, "Tarifario eliminado correctamente");
    }

    private TarifarioDTO convertToDTO(TarifarioEntity tarifarioEntity) {
        return modelMapper.map(tarifarioEntity, TarifarioDTO.class);
    }

}