package com.saludsystem.submodules.rest.controller.configuracion.command;

import com.saludsystem.submodules.adapter.entity.configuracion.UserEntity;
import com.saludsystem.submodules.configuracion.command.create.UsuarioCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.UsuarioDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.UsuarioEditHandler;
import com.saludsystem.submodules.configuracion.model.dto.UserDto;
import com.saludsystem.submodules.configuracion.model.dto.command.UserCreateCommand;
import com.saludsystem.submodules.configuracion.model.dto.command.UserEditCommand;
import com.saludsystem.submodules.adapter.jpa.interfaces.configuracion.UserJpaRepository;
import com.saludsystem.submodules.response.ApiResponse;
import com.saludsystem.submodules.security.util.FileStorageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Tag(name = "Usuarios")
@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioCommandController {

  private final FileStorageService
          fileStorageService;
  private final UserJpaRepository userJpaRepository;
  private final UsuarioCreateHandler createHandler;
  private final UsuarioEditHandler editHandler;
  private final UsuarioDeleteHandler deleteHandler;

  public UsuarioCommandController(FileStorageService fileStorageService, UserJpaRepository userJpaRepository, UsuarioCreateHandler createHandler, UsuarioEditHandler editHandler, UsuarioDeleteHandler deleteHandler) {
    this.fileStorageService = fileStorageService;
    this.userJpaRepository = userJpaRepository;
    this.createHandler = createHandler;
    this.editHandler = editHandler;
    this.deleteHandler = deleteHandler;
  }

  @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<ApiResponse> createUser(
          @ModelAttribute UserCreateCommand command,
          @RequestParam("photo") MultipartFile photo) throws IOException {

    String photoPath = fileStorageService.storeFile(photo);
    command.setPhoto(photoPath);
    //return ResponseEntity.ok(createHandler.execute(command));
    return ResponseEntity.ok(new ApiResponse(true, "Usuario creado exitosamente"));
  }

  @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<UserDto> updateUser(
          @PathVariable("id") UUID userId,
          @ModelAttribute UserEditCommand command,
          @RequestParam(value = "photo", required = false) MultipartFile photo) throws IOException {

    if (photo != null && !photo.isEmpty()) {
      UserEntity existingUser = userJpaRepository.findById(userId)
              .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
      if (existingUser.getPhoto() != null) {
        fileStorageService.deleteFile(existingUser.getPhoto());
      }
      String newPhotoPath = fileStorageService.storeFile(photo);
      command.setPhoto(newPhotoPath);
    }

    return ResponseEntity.ok(editHandler.execute(command, userId));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") UUID userId) {
    deleteHandler.execute(userId);
    return ResponseEntity.ok("Usuario eliminado correctamente");
  }
}
