package com.saludsystem.submodules.response;

import java.util.List;

import lombok.Data;

@Data
public class PaginatedResponse<T>
{
	private List<T> data;
	private Long totalData;
}