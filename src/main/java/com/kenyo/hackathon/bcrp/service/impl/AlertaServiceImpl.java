package com.kenyo.hackathon.bcrp.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.hackathon.bcrp.entity.Alerta;
import com.kenyo.hackathon.bcrp.repository.AlertaRepository;
import com.kenyo.hackathon.bcrp.service.AlertaService;

@Service
public class AlertaServiceImpl implements AlertaService{
	
	@Autowired
	private AlertaRepository alertaReository;

	@Override
	public Alerta registar(Alerta object) {
		object.setFecha(LocalDateTime.now());
		if(object.getUsuario() != null && object.getDenominacion() != null) {
			return alertaReository.save(object);
		}
		return null;
	}

	@Override
	public Alerta modificar(Alerta object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alerta listarId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alerta> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alerta> obtenerNuevasAlertas(Long lastId) {
		List<Alerta> alertas = alertaReository.obtenerAlertasNuevas(lastId);
		if(alertas == null) {
			alertas = new ArrayList<>();
		}
		return alertas;
	}

}
