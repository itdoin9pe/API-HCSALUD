package com.saludsystem.submodules.catalogo.model.dto.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicamentoEditCommand extends BaseDTO {
    private UUID medicamentoId;
    private String nombre;
    private String formaFarmaceutica;
    private String concentracion;
    private String contenido;
    @Schema(example = "0")
    private Integer estado;
}