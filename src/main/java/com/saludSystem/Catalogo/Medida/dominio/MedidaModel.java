package com.saludSystem.Catalogo.Medida.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medidas")
public class MedidaModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_medida", nullable = false)
    private UUID medidaId;

    @Column(name = "nombres")
    private String nombre;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Integer estado;

}