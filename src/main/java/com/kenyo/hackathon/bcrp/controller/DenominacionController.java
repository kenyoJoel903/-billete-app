package com.kenyo.hackathon.bcrp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.hackathon.bcrp.entity.Denominacion;
import com.kenyo.hackathon.bcrp.service.DenominaiconService;

@RestController
@RequestMapping("/denominaciones")
public class DenominacionController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DenominaiconService denominaiconService;

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Denominacion>> obtenerUltimasAlertas(){
		List<Denominacion> lista = denominaiconService.listar();
		if(lista == null) {
			lista = new ArrayList<>();
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
}
