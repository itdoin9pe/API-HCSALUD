package com.saludsystem.submodules.paciente.service.fichaclinica.pconsentimiento;

import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;
import com.saludsystem.submodules.paciente.port.repository.PConsentimientoRepository;

public class PConsentimientoCreateService {

    private final PConsentimientoRepository pConsentimientoRepository;

    public PConsentimientoCreateService(PConsentimientoRepository pConsentimientoRepository) {
        this.pConsentimientoRepository = pConsentimientoRepository;
    }

    public PacienteConsentimiento execute(PacienteConsentimiento pacienteConsentimiento) {

        return pConsentimientoRepository.save(pacienteConsentimiento);

    }

}
