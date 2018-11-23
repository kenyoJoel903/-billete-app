package com.kenyo.hackathon.bcrp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kenyo.hackathon.bcrp.service.IImagenService;

@RestController
@RequestMapping("/images")
public class ImagenController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IImagenService service;
	
	@PostMapping("/proccess")
	public ResponseEntity<String> proccessImage(@RequestParam("file") MultipartFile file) {
		if(!file.isEmpty()) {
			try {
				logger.info(file.getOriginalFilename());
				String extensionFile = file.getOriginalFilename().split("\\.")[1];
				System.out.println(extensionFile);
				String result = service.proccesImage(file.getInputStream(), extensionFile);
				return new ResponseEntity<>(result, HttpStatus.OK);
			} catch (Exception e) {
				logger.error("Error", e);
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	
	

}
