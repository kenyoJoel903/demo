package com.kenyo.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.demo.config.Propiedades;
import com.kenyo.demo.dto.PersonaDTO;
import com.kenyo.demo.dto.PideCliente;
import com.kenyo.demo.model.Persona;
import com.kenyo.demo.repository.PersonaRepository;

@Service
public class PersonaServiceImpl  implements PersonaService{
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private Propiedades propiedades;

	@Override
	public Persona registrar(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public Persona actualizar(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public List<Persona> listar() {
		List<Persona> personas = personaRepository.findAll();
		return personas;
	}

	@Override
	public PideCliente estadisticas() {
		PideCliente pideCliente = new PideCliente();
		List<Persona> personas = listar();
		if(personas != null) {
			pideCliente.setPromedio(promedioEdad(personas));
			pideCliente.setDesviacionEstandar(desviacionEstandar(personas));
		}
		return pideCliente;
	}

	@Override
	public double promedioEdad(List<Persona> personas) {
		if(personas == null)
			return 0;
		int sum = 0;
		for (Persona persona : personas) {
			sum += persona.getEdad();
		}
		double promedio = sum / personas.size();
		return promedio;
	}

	@Override
	public double desviacionEstandar(List<Persona> personas) {
		if(personas == null)
			return 0;
		double promedio = promedioEdad(personas);
		double sum = 0;
		for (Persona persona : personas) {
			sum += Math.pow(Math.abs(persona.getEdad() - promedio), 2);
		}
		double ds = Math.sqrt(sum / personas.size());
		return ds;
	}

	@Override
	public List<PersonaDTO> personas() {
		List<PersonaDTO> lista = new ArrayList<>();
		List<Persona> personas = listar();
		if(personas == null) 
			return lista;
		for (Persona persona : personas) {
			LocalDate fechaMuerte = persona.getFechaNacimiento().plusYears(propiedades.getTiempo_vida());
			PersonaDTO p = new PersonaDTO();
			p.setId(persona.getId());
			p.setNombre(persona.getNombre());
			p.setApellido(persona.getApellido());
			p.setEdad(persona.getEdad());
			p.setFechaNacimiento(persona.getFechaNacimiento());
			p.setFechaMuerte(fechaMuerte);
			lista.add(p);
		}
		return lista;
	}

}
