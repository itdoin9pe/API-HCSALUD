package com.saludsystem.submodules.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationRequest
{
	private Integer page = 0;
	private Integer rows = 10;

	public PaginationRequest()
	{
	}

	public PaginationRequest(Integer page, Integer rows)
	{
		this.page = (page != null) ? page : 0;
		this.rows = (rows != null) ? rows : 10;
	}
}
