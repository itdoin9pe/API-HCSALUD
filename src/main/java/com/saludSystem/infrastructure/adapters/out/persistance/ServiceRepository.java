package com.saludSystem.infrastructure.adapters.out.persistance;

import com.saludSystem.domain.model.ServicioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServicioEntity, Long> {
}
