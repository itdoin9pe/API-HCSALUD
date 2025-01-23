package com.saludSystem.services.modules.Generals.InformacionClinica;

import com.saludSystem.dtos.Generals.InformacionClinica.CrearInformacionClinicaDTO;
import com.saludSystem.dtos.Generals.InformacionClinica.InformacionClinicaDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InformacionClinicaService {

    List<InformacionClinicaDTO> getInformacionClinicaList();

    CrearInformacionClinicaDTO saveInformacionClinica(CrearInformacionClinicaDTO crearInformacionClinicaDTO);

    Optional<InformacionClinicaDTO> getInformacionClinicaById(UUID id);

    void deleteInformacionClinica(UUID id);

    InformacionClinicaDTO updateInformacionClinica(UUID id, InformacionClinicaDTO informacionClinicaDTO);

}
