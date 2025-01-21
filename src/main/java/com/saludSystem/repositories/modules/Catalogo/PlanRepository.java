package com.saludSystem.repositories.modules.Catalogo;

import com.saludSystem.entities.catalogo.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID> {
}
