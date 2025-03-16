package com.saludSystem.Generals.adapter.Empresa.dominio;

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
@Table(name = "empresas")
public class EmpresaModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_empresa", nullable = false)
    private UUID empresaId;

    @NotBlank
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}