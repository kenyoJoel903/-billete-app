package com.kenyo.hackathon.bcrp.service;

import java.util.List;

import com.kenyo.hackathon.bcrp.entity.Alerta;

public interface AlertaService extends ICRUD<Alerta> {
	
	List<Alerta> obtenerNuevasAlertas(Long lastId);

}
