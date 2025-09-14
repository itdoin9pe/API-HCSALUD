package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.command.create.ProductoCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.ProductoDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.ProductoEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.ProductoConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.ProductoCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.ProductoEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Productos")
@RestController
@RequestMapping("/api/Productos")
@Validated
public class ProductoCommandController
{
	private final ProductoCreateHandler createHandler;
	private final ProductoEditHandler editHandler;
	private final ProductoDeleteHandler deleteHandler;

	public ProductoCommandController(
		ProductoCreateHandler createHandler,
		ProductoEditHandler editHandler,
		ProductoDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody ProductoCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, ProductoConstant.CREATED);
	}

	@PutMapping("/Update/{productoId}")
	public ApiResponse update(@PathVariable UUID productoId, @RequestBody ProductoEditCommand editCommand)
	{
		editHandler.execute(productoId, editCommand);
		return new ApiResponse(true, ProductoConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{productoId}")
	public ApiResponse delete(@PathVariable UUID productoId)
	{
		deleteHandler.execute(productoId);
		return new ApiResponse(true, ProductoConstant.DELETED);
	}
}