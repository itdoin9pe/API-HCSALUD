package com.saludsystem.submodules.catalogo.model.dto.command.edit;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClienteEditCommand extends BaseDTO {
    private UUID clienteId;
    private String tipoDocumento;

    private String nombre;

    private String direccion;

    private String contacto;

    @Schema(example = "999-888-555")
    private String telefono;

    @Schema(example = "user@gmail.com")
    private String email;

    @Schema(description = "Estado del Cliente (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;
}