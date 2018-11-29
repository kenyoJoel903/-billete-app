package com.kenyo.hackathon.bcrp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 2, message = "Los nombres deben de tener mínimo 2 caracteres")
	@Column(name="nombres", nullable=false, length=50)
	private String nombres;
	
	
	@Size(min = 2, message = "Los apellidos deben de tener mínimo 2 caracteres")
	@Column(name="apellidos", nullable=false, length=50)
	private String apellidos;
	
	
	@Size(min = 2, message = "El email deben de tener mínimo 2 caracteres")
	@Column(name="email", nullable=false, length=50)
	private String email;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
