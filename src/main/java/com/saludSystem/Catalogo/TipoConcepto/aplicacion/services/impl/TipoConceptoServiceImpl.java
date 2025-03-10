package com.saludSystem.Catalogo.TipoConcepto.aplicacion.services.impl;

import com.saludSystem.Catalogo.TipoConcepto.aplicacion.dtos.ActualizarTipoConceptoDTO;
import com.saludSystem.Catalogo.TipoConcepto.aplicacion.dtos.CrearTipoConceptoDTO;
import com.saludSystem.Catalogo.TipoConcepto.aplicacion.dtos.TipoConceptoDTO;
import com.saludSystem.Catalogo.TipoConcepto.aplicacion.services.TipoConceptoService;
import com.saludSystem.Catalogo.TipoConcepto.dominio.TipoConceptoModel;
import com.saludSystem.Catalogo.TipoConcepto.infraestructura.repositories.TipoConceptoRepository;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
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
public class TipoConceptoServiceImpl implements TipoConceptoService {

    private final TipoConceptoRepository tipoConceptoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TipoConceptoServiceImpl(TipoConceptoRepository tipoConceptoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.tipoConceptoRepository = tipoConceptoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveTipoConcepto(CrearTipoConceptoDTO crearTipoConceptoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        TipoConceptoModel tipoConceptoModel = new TipoConceptoModel();
        tipoConceptoModel.setNombre(crearTipoConceptoDTO.getNombre());
        tipoConceptoModel.setEstado(crearTipoConceptoDTO.getEstado());
        tipoConceptoModel.setUser(user);
        tipoConceptoModel.setHospital(hospital);
        tipoConceptoRepository.save(tipoConceptoModel);
        return new ApiResponse(true, "Tipo concepto registrado correctamente");
    }

    @Override
    public ApiResponse updateTipoConcepto(UUID tipoConveptoId, ActualizarTipoConceptoDTO actualizarTipoConceptoDTO) {
        TipoConceptoModel tipoConceptoModel = tipoConceptoRepository.findById(tipoConveptoId).orElseThrow(
                () -> new ResourceNotFoundException("Tipo concepto no encontrado"));
        Optional.ofNullable(actualizarTipoConceptoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(tipoConceptoModel::setNombre);
        Optional.ofNullable(actualizarTipoConceptoDTO.getEstado()).ifPresent(tipoConceptoModel::setEstado);
        tipoConceptoRepository.save(tipoConceptoModel);
        return new ApiResponse(true, "Tipo concepto actualizado correctamente");
    }

    @Override
    public TipoConceptoDTO getTipoConceptoById(UUID tipoConceptoId) {
        TipoConceptoModel tipoConceptoModel = tipoConceptoRepository.findById(tipoConceptoId)
                .orElseThrow( () -> new ResourceNotFoundException("Tipo concepto no encontrado"));
        return convertToDTO(tipoConceptoModel);
    }

    @Override
    public List<TipoConceptoDTO> getTipoConceptoList() {
        return tipoConceptoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteTipoConcepto(UUID tipoConceptoId) {
        tipoConceptoRepository.deleteById(tipoConceptoId);
        return new ApiResponse(true, "Tipo concepto eliminado correcamente");
    }

    @Override
    public ListResponse<TipoConceptoDTO> getAllTipoConcepto(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<TipoConceptoModel> tipoConceptoModelPage = tipoConceptoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<TipoConceptoDTO> data = tipoConceptoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, tipoConceptoModelPage.getTotalElements(), tipoConceptoModelPage.getTotalPages(), tipoConceptoModelPage.getNumber() + 1);
    }

    private TipoConceptoDTO convertToDTO(TipoConceptoModel tipoConceptoModel) {
        return modelMapper.map(tipoConceptoModel, TipoConceptoDTO.class);
    }

}