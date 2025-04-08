package com.gyana.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	@Value("${file.storage.path}")
	private String storagePath;

	public String storeFile(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Path targetLocation = Paths.get(storagePath).resolve(fileName);
		Files.createDirectories(targetLocation.getParent());
		Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		return fileName;
	}

	public File getFile(String fileName) {
		Path filePath = Paths.get(storagePath).resolve(fileName);
		return filePath.toFile();
	}

	public boolean fileExists(String fileName) {
		Path filePath = Paths.get(storagePath).resolve(fileName);
		return Files.exists(filePath);
	}
}
