package com.saludSystem.services.modules.Paciente;

import com.saludSystem.entities.Paciente;
import com.saludSystem.entities.User;
import com.saludSystem.repositories.modules.Paciente.PacienteRepository;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    /*
    public Paciente createPaciente(PacienteRequest request, User user){
        if (!user.getRole().equals(request.getEspeciality())){
            throw new AccessDeniedException("You can only create patients for your speciality");
        }
        Paciente paciente = new Paciente();

        return pacienteRepository.save(paciente);
    }*/
}
