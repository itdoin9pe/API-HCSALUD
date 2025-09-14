package com.saludsystem.submodules.core.catalogo.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.catalogo.command.create.CategoriaCreateHandler;
import com.saludsystem.submodules.catalogo.command.delete.CategoriaDeleteHandler;
import com.saludsystem.submodules.catalogo.command.edit.CategoriaEditHandler;
import com.saludsystem.submodules.catalogo.model.constant.CategoriaConstant;
import com.saludsystem.submodules.catalogo.model.dto.command.CategoriaCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.CategoriaEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Categorias")
@RestController
@RequestMapping("/api/Categorias")
public class CategoriaCommandController
{
	private final CategoriaCreateHandler createHandler;
	private final CategoriaEditHandler editHandler;
	private final CategoriaDeleteHandler deleteHandler;

	public CategoriaCommandController(
		CategoriaCreateHandler createHandler,
		CategoriaEditHandler editHandler,
		CategoriaDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody CategoriaCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, CategoriaConstant.CREATED);
	}

	@PutMapping("/Update/{categoriaId}")
	public ApiResponse update(@PathVariable UUID categoriaId, @RequestBody CategoriaEditCommand dto)
	{
		editHandler.execute(categoriaId, dto);
		return new ApiResponse(true, CategoriaConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{categoriaId}")
	public ApiResponse delete(@PathVariable UUID categoriaId)
	{
		deleteHandler.execute(categoriaId);
		return new ApiResponse(true, CategoriaConstant.DELETED);
	}
}