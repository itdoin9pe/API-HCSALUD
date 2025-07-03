package com.saludsystem.domain.model;

import com.saludsystem.domain.model.configuracion.SysSaludEntity;
import com.saludsystem.domain.model.configuracion.UserEntity;
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