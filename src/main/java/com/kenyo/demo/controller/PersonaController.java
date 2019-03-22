package com.kenyo.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.kenyo.demo.dto.PersonaDTO;
import com.kenyo.demo.dto.PideCliente;
import com.kenyo.demo.model.Persona;
import com.kenyo.demo.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> registrar(@Valid @RequestBody Persona persona){
		persona = personaService.registrar(persona);
		if(persona == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(persona, HttpStatus.OK);
	}
	
	@GetMapping(value = "/kpidecliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PideCliente> statidicas(){
		return new ResponseEntity<>(personaService.estadisticas(), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonaDTO>> listaCLientes(){
		return new ResponseEntity<>(personaService.personas(), HttpStatus.OK);
	}
	

}
