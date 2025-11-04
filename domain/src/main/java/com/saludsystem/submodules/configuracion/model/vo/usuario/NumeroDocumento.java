package com.saludsystem.submodules.configuracion.model.vo.usuario;

public record NumeroDocumento(String value)
{
	public NumeroDocumento
	{
		if (value == null || value.isBlank())
		{
			throw new IllegalArgumentException("El número de documento no puede estar vacío");
		}
		if (!value.matches("\\d{8}|\\d{11}"))
		{
			throw new IllegalArgumentException("El número de documento debe tener 8 (DNI) o 11 (RUC) dígitos");
		}
	}

	@Override
	public String toString()
	{
		return value;
	}
}