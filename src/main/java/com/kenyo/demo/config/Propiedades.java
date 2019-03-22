package com.kenyo.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("com.kenyo.demo")
public class Propiedades {
	
	private int tiempo_vida;

	public int getTiempo_vida() {
		return tiempo_vida;
	}

	public void setTiempo_vida(int tiempo_vida) {
		this.tiempo_vida = tiempo_vida;
	}
	
	

}
