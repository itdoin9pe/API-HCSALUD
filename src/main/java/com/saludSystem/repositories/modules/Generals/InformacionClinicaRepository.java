package com.saludSystem.repositories.modules.Generals;

import com.saludSystem.entities.InformacionClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionClinicaRepository extends JpaRepository<InformacionClinica, Long> {
}
