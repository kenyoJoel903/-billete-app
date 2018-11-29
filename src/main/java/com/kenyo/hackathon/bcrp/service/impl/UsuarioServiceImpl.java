package com.kenyo.hackathon.bcrp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.hackathon.bcrp.entity.Usuario;
import com.kenyo.hackathon.bcrp.repository.UsuarioRepository;
import com.kenyo.hackathon.bcrp.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario registar(Usuario object) {
		if(buscarUsuario(object.getEmail()) != null) {
			return modificar(object);
		}else {
			return usuarioRepository.save(object);
		}
	}

	@Override
	public Usuario modificar(Usuario object) {
		return usuarioRepository.save(object);
	}

	@Override
	public Usuario listarId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Usuario buscarUsuario(String email) {
		List<Usuario> listaEmail = usuarioRepository.findByEmail(email);
		if(!listaEmail.isEmpty()) {
			return listaEmail.get(0);
		}
		return null;
	}

}
