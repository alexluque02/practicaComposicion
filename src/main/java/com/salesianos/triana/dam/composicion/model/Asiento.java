package com.salesianos.triana.dam.composicion.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asiento { //No va a tener repositorio propio al ser una composición
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int fila, columna;
	
	@Enumerated(EnumType.STRING)
	private TipoAsiento tipo;
	
	@ManyToOne
	@JoinColumn //Terminar
	private Avion avion;
	
}
