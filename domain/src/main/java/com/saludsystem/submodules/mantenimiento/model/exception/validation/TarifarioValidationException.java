package com.saludsystem.submodules.mantenimiento.model.exception.validation;

import java.io.Serial;

public class TarifarioValidationException extends RuntimeException
{
	@Serial
	private static final long serialVersionUID = 1L;

	public TarifarioValidationException(String message)
	{
		super(message);
	}
}
