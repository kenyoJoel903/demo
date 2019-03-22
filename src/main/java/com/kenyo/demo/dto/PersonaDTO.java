package com.kenyo.demo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.kenyo.demo.model.Persona;

public class PersonaDTO extends Persona {
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDate fechaMuerte;	

	public LocalDate getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(LocalDate fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}
	
	
}
