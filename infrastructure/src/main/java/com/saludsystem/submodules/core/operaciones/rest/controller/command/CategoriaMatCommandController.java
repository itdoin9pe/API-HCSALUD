package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.command.create.CategoriaMaterialCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.CategoriaMaterialDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.CategoriaMaterialEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.CategoriaMaterialConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.CategotiaMatCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.CategoriaMatEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "CategoriasMateriales")
@RestController
@RequestMapping("/api/CategoriasMateriales")
public class CategoriaMatCommandController
{
	private final CategoriaMaterialCreateHandler createHandler;
	private final CategoriaMaterialEditHandler editHandler;
	private final CategoriaMaterialDeleteHandler deleteHandler;

	public CategoriaMatCommandController(
		CategoriaMaterialCreateHandler createHandler,
		CategoriaMaterialEditHandler editHandler,
		CategoriaMaterialDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody CategotiaMatCreateCommand dto)
	{
		createHandler.execute(dto);
		return new ApiResponse(true, CategoriaMaterialConstant.CREATED);
	}

	@PutMapping("/Update/{categoriaMaterialId}")
	public ApiResponse update(@PathVariable UUID categoriaMaterialId, @RequestBody CategoriaMatEditCommand dto)
	{
		editHandler.execute(categoriaMaterialId, dto);
		return new ApiResponse(true, CategoriaMaterialConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{categoriaMaterialId}")
	public ApiResponse delete(@PathVariable UUID categoriaMaterialId)
	{
		deleteHandler.execute(categoriaMaterialId);
		return new ApiResponse(true, CategoriaMaterialConstant.DELETED);
	}
}