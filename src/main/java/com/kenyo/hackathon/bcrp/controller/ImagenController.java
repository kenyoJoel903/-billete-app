package com.kenyo.hackathon.bcrp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.kenyo.hackathon.bcrp.service.IImagenService;
import com.kenyo.hackathon.bcrp.util.HackathonUtil;

@RestController
@RequestMapping("/images")
public class ImagenController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IImagenService service;
	
	@Autowired
	private HackathonUtil util;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		if(!file.isEmpty()) {
			try {
				logger.info(file.getOriginalFilename());
				String extensionFile = file.getOriginalFilename().split("\\.")[1];
				String result = service.uploadImage(file.getInputStream(), extensionFile);
				return new ResponseEntity<>(result, HttpStatus.OK);
			} catch (Exception e) {
				logger.error("Error", e);
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/proccess")
	public ResponseEntity<String> proccessImage(@RequestParam("file") MultipartFile file) {
		if(!file.isEmpty()) {
			try {
				logger.info(file.getOriginalFilename());
				String extensionFile = file.getOriginalFilename().split("\\.")[1];
				System.out.println(extensionFile);
				String result = service.proccesImage2(file.getInputStream(), extensionFile);
				return new ResponseEntity<>(result, HttpStatus.OK);
			} catch (Exception e) {
				logger.error("Error", e);
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@GetMapping(value = "/view/{filename:.+}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImage(@PathVariable("filename") String fileName) throws IOException {
		File file = new File(util.getPath() + "/" + fileName);
		InputStream inputStream = new FileInputStream(file);
		return IOUtils.toByteArray(inputStream);
	}
	
	@GetMapping(value = "/proccess/{url_image:.+}")
	public ResponseEntity<String> getInfo(@PathVariable("url_image") String urlImage){
		logger.info(urlImage);
		String server = "https://api.ocr.space/parse/imageurl?apikey=8b7812c57288957&url=URL_IMAGE";
		server = server.replace("URL_IMAGE", urlImage);
		logger.info(server);
		RestTemplate template = new RestTemplate();
		HttpEntity<String> requestEntity = new HttpEntity<>("");
		ResponseEntity<String> response = template.exchange(server, HttpMethod.GET, requestEntity, String.class);
		String result = response.getBody();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	
	

}
