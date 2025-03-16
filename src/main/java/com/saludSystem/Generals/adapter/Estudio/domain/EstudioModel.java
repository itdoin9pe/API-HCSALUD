package com.saludSystem.Generals.adapter.Estudio.domain;

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
@Table(name = "estudios")
public class EstudioModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_estudio", nullable = false)
    private UUID estudioId;

    @NotBlank(message = "The description field can't be blank")
    @Column(nullable = false)
    private String descripcion;

}