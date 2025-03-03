package com.saludSystem.domain.entities.Generals;

import com.saludSystem.domain.entities.configuracion.User;
import com.saludSystem.domain.entities.configuracion.SysSalud;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id", nullable = false)
    private SysSalud hospital;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
