package com.saludSystem.services.modules.Generals.InformacionClinica;

import com.saludSystem.dtos.Generals.InformacionClinicaDTO;
import java.util.List;
import java.util.Optional;

public interface InformacionClinicaService {

    InformacionClinicaDTO saveInformacionClinica(InformacionClinicaDTO informacionClinicaDTO);

    List<InformacionClinicaDTO> getAllInformacionClinica();

    Optional<InformacionClinicaDTO> getInformacionClinicaById(Integer id);

    void deleteInformacionClinica(Integer id);

    InformacionClinicaDTO updateInformacionClinica(Integer id, InformacionClinicaDTO informacionClinicaDTO);

}
