package com.arpan.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.arpan.beans.FileDB;


public interface FileStorageService {

	FileDB store(MultipartFile file) throws IOException;

	FileDB getFile(String id);

	Stream<FileDB> getAllFiles();

	void deleteById(String id);
	
	FileDB edit(MultipartFile file, String id) throws IOException;
}
