package com.arpan.services;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.arpan.beans.FileDB;
import com.arpan.repository.FileDBRepository;


@Service
public class FileStorageServicImpl implements FileStorageService {

	@Autowired
	private  FileDBRepository fileDBRepository; 
	
	 public FileDB store(MultipartFile file) throws IOException {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

		    return fileDBRepository.save(FileDB);
		  }

		  public FileDB getFile(String id) {
		    return fileDBRepository.findById(id).get();
		  }
		  
		  public Stream<FileDB> getAllFiles() {
		    return fileDBRepository.findAll().stream();
		  }

		@Override
		public void deleteById(String id) {
		  fileDBRepository.deleteById(id);	
		}
		  
		@Override
		public FileDB edit(MultipartFile file, String id) throws IOException {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		    FileDB FileDB = new FileDB(id,fileName, file.getContentType(), file.getBytes());

		    return fileDBRepository.save(FileDB);
		  } 
	
}
