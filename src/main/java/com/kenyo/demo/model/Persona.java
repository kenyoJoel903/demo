package com.kenyo.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(min = 3, message = "Nombre debe tener minimo 3 caracteres")
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@Size(min = 3, message = "Apellido debe tener minimo 3 caracteres")
	@Column(nullable = false, length = 50)
	private String apellido;
	
	@Transient
	private short edad;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDate fechaNacimiento;
	
	
	public Persona() {}

	public Persona(int id, String nombre, String apellido, LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public short getEdad() {
		if(fechaNacimiento != null) {
			LocalDate ahora = LocalDate.now();
			Period periodo = Period.between(fechaNacimiento, ahora);
			this.edad = (short)periodo.getYears();
		}
		return edad;
	}

	public void setEdad(short edad) {
		this.edad = edad;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}	
	
}
