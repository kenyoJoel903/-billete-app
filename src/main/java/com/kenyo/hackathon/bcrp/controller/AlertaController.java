package com.kenyo.hackathon.bcrp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.hackathon.bcrp.entity.Alerta;
import com.kenyo.hackathon.bcrp.service.AlertaService;

@RestController
@RequestMapping("/alertas")
public class AlertaController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AlertaService alertaService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alerta> registrar(@Valid @RequestBody Alerta alerta){
		alerta = alertaService.registar(alerta);
		if(alerta == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(alerta, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{lastId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Alerta>> obtenerUltimasAlertas(@PathVariable("lastId") Long id){
		List<Alerta> alertas = alertaService.obtenerNuevasAlertas(id);
		return new ResponseEntity<>(alertas, HttpStatus.OK);
	}

	
}
