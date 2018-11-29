package com.kenyo.hackathon.bcrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kenyo.hackathon.bcrp.entity.Usuario;
import java.lang.String;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	
	List<Usuario> findByEmail(String email);
}
