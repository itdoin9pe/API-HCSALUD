package com.saludSystem.Generals.adapter;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseEntity {

    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id", nullable = false)
    private SysSaludModel hospital;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

}
