package com.kenyo.hackathon.bcrp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.hackathon.bcrp.entity.Denominacion;
import com.kenyo.hackathon.bcrp.repository.DenominacionRepository;
import com.kenyo.hackathon.bcrp.service.DenominaiconService;

@Service
public class DenominacionServiceImpl implements DenominaiconService{

	
	@Autowired
	private DenominacionRepository denominacionRepository;
	
	@Override
	public Denominacion registar(Denominacion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Denominacion modificar(Denominacion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Denominacion listarId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Denominacion> listar() {
		return denominacionRepository.findAll();
	}

	
}
