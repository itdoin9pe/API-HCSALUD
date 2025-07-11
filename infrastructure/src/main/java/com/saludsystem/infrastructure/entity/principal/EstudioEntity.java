package com.saludsystem.infrastructure.entity.principal;

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