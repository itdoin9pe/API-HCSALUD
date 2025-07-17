package com.saludsystem.submodules.sections.configuracion.rest.controller.command;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.configuracion.command.create.UsuarioCreateHandler;
import com.saludsystem.submodules.configuracion.command.delete.UsuarioDeleteHandler;
import com.saludsystem.submodules.configuracion.command.edit.UsuarioEditHandler;
import com.saludsystem.submodules.configuracion.model.dto.UserDto;
import com.saludsystem.submodules.configuracion.model.dto.command.create.UserCreateCommand;
import com.saludsystem.submodules.configuracion.model.dto.command.edit.UserEditCommand;
import com.saludsystem.submodules.sections.configuracion.adapter.jpa.UserJpaRepository;
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

  private final FileStorageService fileStorageService;
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
  public ResponseEntity<UserDto> createUser(
          @ModelAttribute UserCreateCommand command,
          @RequestParam("photo") MultipartFile photo) throws IOException {

    String photoPath = fileStorageService.storeFile(photo);
    command.setPhoto(photoPath);
    return ResponseEntity.ok(createHandler.execute(command));
  }

  @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<UserDto> updateUser(
          @PathVariable("id") UUID userId, String firstName, String lastName, String email,
          String username, String password, String phoneNumber, String address, String documentType,
          String documentNumber, UUID rolId, UUID hospitalId, Integer estado, MultipartFile photoFile)
          throws IOException {

    UserEditCommand command = new UserEditCommand();
    command.setFirstName(firstName);
    command.setLastName(lastName);
    command.setEmail(email);
    command.setUsername(username);
    command.setPassword(password);
    command.setPhoneNumber(phoneNumber);
    command.setAddress(address);
    command.setDocumentType(documentType);
    command.setDocumentNumber(documentNumber);
    command.setRolId(rolId);
    command.setHospitalId(hospitalId);
    command.setEstado(estado);
    if (photoFile != null && !photoFile.isEmpty()) {
      UserEntity existingUser = userJpaRepository.findById(userId)
              .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
      if (existingUser.getPhoto() != null) {
        fileStorageService.deleteFile(existingUser.getPhoto());
      }
      String photoPath = fileStorageService.storeFile(photoFile);
      command.setPhoto(photoPath);
    }
    return ResponseEntity.ok(editHandler.execute(command, userId));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") UUID userId) {
    deleteHandler.execute(userId);
    return ResponseEntity.ok("Usuario eliminado correctamente");
  }
}