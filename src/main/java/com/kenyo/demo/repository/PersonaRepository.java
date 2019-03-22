package com.kenyo.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kenyo.demo.model.Persona;

public interface PersonaRepository  extends JpaRepository<Persona, Integer>{
}
