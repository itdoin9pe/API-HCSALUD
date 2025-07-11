package com.saludsystem.infrastructure.adapter.entity.principal;

import com.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aseguradoras")
@EqualsAndHashCode(callSuper = true)
public class AseguradoraEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_aseguradora", nullable = false)
    private UUID aseguradoraId;

    @NotBlank
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Integer estado;
}