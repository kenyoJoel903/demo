package com.kenyo.demo.service;

import java.util.List;

import com.kenyo.demo.dto.PersonaDTO;
import com.kenyo.demo.dto.PideCliente;
import com.kenyo.demo.model.Persona;

public interface PersonaService {
	
	Persona registrar(Persona persona);
	
	Persona actualizar(Persona persona);
	
	List<Persona> listar();
	
	PideCliente estadisticas();
	
	double promedioEdad(List<Persona> personas);
	
	double desviacionEstandar(List<Persona> personas);
	
	List<PersonaDTO> personas();

}
