package com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta;

import com.saludsystem.submodules.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EPagoEditCommand extends BaseDTO {

    private UUID pecPagoId;

    private UUID pacEstadoCuentaId;

    private LocalDate fechaPago;

    @Schema(example = "0")
    private Double monto;

    private String metodoPago;

    private String referenciaPago;

}