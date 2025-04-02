package com.saludSystem.domain.model.Mantenimiento;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "cajas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CajaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "caja_id", nullable = false)
    private UUID cajaId;

    @Column(name = "nombre_caja", nullable = false, unique = true)
    private String nombre;

    @Column(name = "estado_caja", nullable = false)
    private Integer estado;

}