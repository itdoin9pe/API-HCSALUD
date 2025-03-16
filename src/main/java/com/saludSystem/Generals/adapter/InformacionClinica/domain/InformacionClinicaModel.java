package com.saludSystem.Generals.adapter.InformacionClinica.domain;

import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "informacion_clinicas")
public class InformacionClinicaModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_informacionClinica", nullable = false, unique = true)
    private UUID informacionClinicaId;

    @NotBlank
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}