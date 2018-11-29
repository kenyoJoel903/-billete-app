package com.kenyo.hackathon.bcrp.service;

import java.util.List;

public interface ICRUD<T>{
	
	
	T registar(T object);
	
	T modificar(T object);
	
	T listarId(Long id);
	
	List<T> listar();

}
