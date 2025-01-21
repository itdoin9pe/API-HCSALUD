package com.saludSystem.services.modules.Generals.InformacionClinica;

import com.saludSystem.dtos.Generals.InformacionClinicaDTO;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InformacionClinicaService {

    List<InformacionClinicaDTO> getInformacionClinicaList();

    InformacionClinicaDTO saveInformacionClinica(InformacionClinicaDTO informacionClinicaDTO);

    Optional<InformacionClinicaDTO> getInformacionClinicaById(UUID id);

    void deleteInformacionClinica(UUID id);

    InformacionClinicaDTO updateInformacionClinica(UUID id, InformacionClinicaDTO informacionClinicaDTO);

}
