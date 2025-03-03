package com.saludSystem.infraestructura.repositories.Generals;

import com.saludSystem.dominio.entities.Generals.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Menu, UUID> {

    List<Menu> findByHospitalHospitalId(UUID hospitalId);

}
