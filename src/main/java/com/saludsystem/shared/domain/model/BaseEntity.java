package com.saludsystem.shared.domain.model;

import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity {

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id", nullable = false)
    private SysSaludEntity hospital;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity user;

}