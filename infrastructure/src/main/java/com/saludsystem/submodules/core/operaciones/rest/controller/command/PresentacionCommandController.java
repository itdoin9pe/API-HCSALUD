package com.saludsystem.submodules.core.operaciones.rest.controller.command;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saludsystem.submodules.operaciones.command.create.PresentacionCreateHandler;
import com.saludsystem.submodules.operaciones.command.delete.PresentacionDeleteHandler;
import com.saludsystem.submodules.operaciones.command.edit.PresentacionEditHandler;
import com.saludsystem.submodules.operaciones.model.constant.PresentacionConstant;
import com.saludsystem.submodules.operaciones.model.dtos.command.PresentacionCreateCommand;
import com.saludsystem.submodules.operaciones.model.dtos.command.edit.PresentacionEditCommand;
import com.saludsystem.submodules.response.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Presentaciones")
@RestController
@RequestMapping("/api/Presentaciones")
public class PresentacionCommandController
{
	private final PresentacionCreateHandler createHandler;
	private final PresentacionEditHandler editHandler;
	private final PresentacionDeleteHandler deleteHandler;

	public PresentacionCommandController(
		PresentacionCreateHandler createHandler,
		PresentacionEditHandler editHandler,
		PresentacionDeleteHandler deleteHandler)
	{
		this.createHandler = createHandler;
		this.editHandler = editHandler;
		this.deleteHandler = deleteHandler;
	}

	@PostMapping("/Save")
	public ApiResponse save(@RequestBody PresentacionCreateCommand createCommand)
	{
		createHandler.execute(createCommand);
		return new ApiResponse(true, PresentacionConstant.CREATED);
	}

	@PutMapping("/Update/{presentacionId}")
	public ApiResponse update(@PathVariable UUID presentacionId, @RequestBody PresentacionEditCommand editCommand)
	{
		editHandler.execute(presentacionId, editCommand);
		return new ApiResponse(true, PresentacionConstant.UPDATED);
	}

	@DeleteMapping("/Delete/{presentacionId}")
	public ApiResponse delete(@PathVariable UUID presentacionId)
	{
		deleteHandler.execute(presentacionId);
		return new ApiResponse(true, PresentacionConstant.DELETED);
	}
}