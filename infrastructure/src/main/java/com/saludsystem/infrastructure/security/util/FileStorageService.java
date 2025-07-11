package com.saludsystem.infrastructure.security.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String storeFile(MultipartFile file) throws IOException {
        // Crear el directorio si no existe
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generar un nombre único para el archivo
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Guardar el archivo en el directorio
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);

        // Devolver la ruta relativa del archivo
        return uploadDir + fileName;
    }

    public String storeFileInSubfolder(MultipartFile file, String subfolder) throws IOException {
        Path uploadPath = Paths.get(uploadDir).resolve(subfolder);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), filePath);
        return uploadDir + subfolder + "/" + fileName;
    }

    public String storeFirma(MultipartFile file) throws IOException {
        return storeFileInSubfolder(file, "firmas");
    }

    // Delete Public Function
    public void deleteFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            Files.delete(path);
        }
    }

}