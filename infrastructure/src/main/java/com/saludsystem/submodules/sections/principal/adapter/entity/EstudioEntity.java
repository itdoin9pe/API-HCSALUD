package com.saludsystem.submodules.sections.principal.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "estudios")
public class EstudioEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_estudio", nullable = false)
    private UUID estudioId;

    @NotBlank(message = "The description field can't be blank")
    @Column(nullable = false)
    private String descripcion;

}