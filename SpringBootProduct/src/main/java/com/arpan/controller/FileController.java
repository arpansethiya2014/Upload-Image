package com.arpan.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.arpan.beans.FileDB;
import com.arpan.beans.Product;
import com.arpan.response.ResponseFile;
import com.arpan.response.ResponseMessage;
import com.arpan.services.FileStorageService;


@Controller
public class FileController {

  @Autowired
  private FileStorageService storageService;

//  @RequestMapping("/imagePage")
//	public String newImagePage() {
//		return "showImage";
//	}
  
  @RequestMapping("/image")
	public String newImage(Model m) {
		System.out.println("Upload Image....!");
		FileDB fDB = new FileDB();
		m.addAttribute("image", fDB);
		return "NewImage";
	}
  
  
  
  @RequestMapping(value = "/upload",method = RequestMethod.POST)
  public String uploadFile(@RequestParam("data") MultipartFile file) {
    String message = "";
    ModelAndView m = new ModelAndView("NewImage");
    try {
      storageService.store(file);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
    }
     return "redirect:/";
  }

  @RequestMapping("/imagePage")
  public String getListFiles(Model model) {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId())
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length,
          dbFile.getId());
    }).collect(Collectors.toList());
    
    model.addAttribute("imagelist", files);
   return "showImage";
  }

  @RequestMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable("id") String id) {
    FileDB fileDB = storageService.getFile(id);
 return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
  
  @RequestMapping("/delete/file/{id}")
  public String deleteById(@PathVariable("id") String id){
	  String message = "";
	  try {
		  storageService.deleteById(id);
		  message = "Deleted the file successfully: " + id;
	} catch (Exception e) {
		 message = "Could not Find Id: " + id + "!";
	}
	  return "redirect:/"; 
  }
  
}
