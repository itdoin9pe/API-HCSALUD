package com.saludsystem.submodules.configuracion.model.dtos.command.edit;

import java.util.UUID;

import com.saludsystem.submodules.BaseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoDocumentoEditCommand extends BaseDTO
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