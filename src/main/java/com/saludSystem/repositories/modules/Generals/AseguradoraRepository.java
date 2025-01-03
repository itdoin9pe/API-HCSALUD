package com.saludSystem.repositories.modules.Generals;

import com.saludSystem.entities.Aseguradora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AseguradoraRepository extends JpaRepository<Aseguradora, Integer> {
}
