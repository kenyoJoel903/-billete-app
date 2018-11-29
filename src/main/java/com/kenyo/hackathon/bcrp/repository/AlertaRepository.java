package com.kenyo.hackathon.bcrp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kenyo.hackathon.bcrp.entity.Alerta;
import java.util.List;

import org.springframework.data.repository.query.Param;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
	
	@Query("from Alerta a where a.id > :lastId ")
	List<Alerta> obtenerAlertasNuevas(@Param("lastId") Long lastId);

}
