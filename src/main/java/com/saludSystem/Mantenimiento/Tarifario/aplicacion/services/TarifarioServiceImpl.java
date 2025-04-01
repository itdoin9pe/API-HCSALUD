package com.saludSystem.Mantenimiento.Tarifario.aplicacion.services;

import com.saludSystem.Catalogo.Categoria.dominio.CategoriaModel;
import com.saludSystem.Catalogo.Categoria.infraestructura.repositories.CategoriaRepository;
import com.saludSystem.Catalogo.Medida.dominio.MedidaModel;
import com.saludSystem.Catalogo.Medida.infraestructura.repositories.MedidaRepository;
import com.saludSystem.Catalogo.TipoConcepto.dominio.TipoConceptoModel;
import com.saludSystem.Catalogo.TipoConcepto.infraestructura.repositories.TipoConceptoRepository;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Mantenimiento.Tarifario.aplicacion.dtos.ActualizarTarifarioDTO;
import com.saludSystem.Mantenimiento.Tarifario.aplicacion.dtos.CrearTarifarioDTO;
import com.saludSystem.Mantenimiento.Tarifario.aplicacion.dtos.TarifarioDTO;
import com.saludSystem.Mantenimiento.Tarifario.dominio.TarifarioModel;
import com.saludSystem.Mantenimiento.Tarifario.infraestructura.repository.TarifarioRepository;
import com.saludSystem.Operaciones.Unidad.dominio.UnidadModel;
import com.saludSystem.Operaciones.Unidad.infraestructura.repository.UnidadRepository;
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
        UserModel userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(userModel.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TarifarioModel tarifarioModel = new TarifarioModel();
        Optional<TipoConceptoModel> tipoConceptoModel = tipoConceptoRepository.findById(crearTarifarioDTO.getTipoConceptoId());
        tipoConceptoModel.ifPresent(tarifarioModel::setTipoConceptoModel);
        Optional<CategoriaModel> categoriaModel = categoriaRepository.findById(crearTarifarioDTO.getCategoriaId());
        categoriaModel.ifPresent(tarifarioModel::setCategoriaModel);
        Optional<UnidadModel> unidadModel = unidadRepository.findById(crearTarifarioDTO.getUnidadId());
        unidadModel.ifPresent(tarifarioModel::setUnidadModel);
        Optional<MedidaModel> medidaModel = medidaRepository.findById(crearTarifarioDTO.getMedidaId());
        medidaModel.ifPresent(tarifarioModel::setMedidaModel);
        tarifarioModel.setGrupo(crearTarifarioDTO.getGrupo());
        tarifarioModel.setDescripcion(crearTarifarioDTO.getDescripcion());
        tarifarioModel.setPrecio(crearTarifarioDTO.getPrecio());
        tarifarioModel.setEstado(crearTarifarioDTO.getEstado());
        tarifarioModel.setHospital(hospital);
        tarifarioModel.setUser(userModel);
        tarifarioRepository.save(tarifarioModel);
        return new ApiResponse(true, "Tarifario registrado correctamente");
    }

    @Override
    public ListResponse<TarifarioDTO> getAllTarifario(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TarifarioModel> tarifarioModelPage = tarifarioRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TarifarioDTO> data = tarifarioModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tarifarioModelPage.getTotalElements(), tarifarioModelPage.getTotalPages(), tarifarioModelPage.getNumber() +1 );
    }

    @Override
    public List<TarifarioDTO> getTarifarioList() {
        return tarifarioRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public TarifarioDTO getTarifarioById(UUID tarifarioId) {
        TarifarioModel tarifarioModel = tarifarioRepository.findById(tarifarioId).orElseThrow( () -> new ResourceNotFoundException("Tarifario no encontrado"));
        return convertToDTO(tarifarioModel);
    }

    @Override
    public ApiResponse updateTarifario(UUID tarifarioId, ActualizarTarifarioDTO actualizarTarifarioDTO) {
        TarifarioModel tarifarioModel = tarifarioRepository.findById(tarifarioId).orElseThrow(() -> new ResourceNotFoundException("Tarifario no encontrado"));
        Optional.ofNullable(actualizarTarifarioDTO.getTipoConceptoId()).flatMap(tipoConceptoRepository::findById).ifPresent(tarifarioModel::setTipoConceptoModel);
        Optional.ofNullable(actualizarTarifarioDTO.getCategoriaId()).flatMap(categoriaRepository::findById).ifPresent(tarifarioModel::setCategoriaModel);
        Optional.ofNullable(actualizarTarifarioDTO.getUnidadId()).flatMap(unidadRepository::findById).ifPresent(tarifarioModel::setUnidadModel);
        Optional.ofNullable(actualizarTarifarioDTO.getMedidaId()).flatMap(medidaRepository::findById).ifPresent(tarifarioModel::setMedidaModel);
        Optional.ofNullable(actualizarTarifarioDTO.getGrupo()).filter(desc -> !desc.isBlank()).ifPresent(tarifarioModel::setGrupo);
        Optional.ofNullable(actualizarTarifarioDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(tarifarioModel::setDescripcion);
        Optional.ofNullable(actualizarTarifarioDTO.getPrecio()).ifPresent(tarifarioModel::setPrecio);
        Optional.ofNullable(actualizarTarifarioDTO.getEstado()).ifPresent(tarifarioModel::setEstado);
        tarifarioRepository.save(tarifarioModel);
        return new ApiResponse(true, "Tarifario actualizado correctamente");
    }

    @Override
    public ApiResponse deleteTarifario(UUID tarifarioId) {
        tarifarioRepository.deleteById(tarifarioId);
        return new ApiResponse(true, "Tarifario eliminado correctamente");
    }

    private TarifarioDTO convertToDTO(TarifarioModel tarifarioModel) {
        return modelMapper.map(tarifarioModel, TarifarioDTO.class);
    }

}