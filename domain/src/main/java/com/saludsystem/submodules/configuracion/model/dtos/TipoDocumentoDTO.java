package com.saludsystem.submodules.configuracion.model.dtos;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoDocumentoDTO
{
	private UUID tipoDocumentoId;
	private String tipoComprobante;
	private String serie;

	@Schema(description = "Valor Inicio", example = "0")
	private Integer inicio;

	@Schema(description = "Valor Fin", example = "0")
	private Integer fin;

	@Schema(description = "Valor Correlativo", example = "0")
	private Integer correlativoActual;

	@Schema(description = "Estado del tipo de Documento", example = "0")
	private Integer estado;
}
