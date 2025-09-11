package com.saludsystem.submodules;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Service
public class FileStorageService implements WebMvcConfigurer
{

	@Value("${file.upload-dir}")
	private String uploadDir;

	public String storeFile(MultipartFile file) throws IOException
	{
		// Crear el directorio si no existe
		Path uploadPath = Paths.get(uploadDir);
		if (!Files.exists(uploadPath))
		{
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

	public String storeFileInSubfolder(MultipartFile file, String subfolder) throws IOException
	{
		Path basePath = Paths.get(uploadDir);
		Path uploadPath = basePath.resolve(subfolder);

		if (!Files.exists(uploadPath))
		{
			Files.createDirectories(uploadPath);
		}

		String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
		Path filePath = uploadPath.resolve(fileName);
		Files.copy(file.getInputStream(), filePath);

		// URL pública -> http://localhost:8081/uploads/pacientes/uuid.png
		return "/uploads/" + subfolder + "/" + fileName;
	}

	public String storeFirma(MultipartFile file) throws IOException
	{
		return storeFileInSubfolder(file, "firmas");
	}

	// Delete Public Function
	public void deleteFile(String filePath) throws IOException
	{
		Path path = Paths.get(filePath);
		if (Files.exists(path))
		{
			Files.delete(path);
		}
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/uploads/**").addResourceLocations("file:" + uploadDir);
	}

}