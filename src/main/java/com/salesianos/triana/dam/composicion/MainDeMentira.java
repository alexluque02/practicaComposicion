package com.salesianos.triana.dam.composicion;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesianos.triana.dam.composicion.model.Asiento;
import com.salesianos.triana.dam.composicion.model.Avion;
import com.salesianos.triana.dam.composicion.model.TipoAsiento;
import com.salesianos.triana.dam.composicion.repository.AvionRepositorio;

@Component
public class MainDeMentira {
	
	@Autowired
	private AvionRepositorio repositorio;

	@PostConstruct
	public void ejecutar() {
		Avion airbus320=Avion.builder()
				.modelo("Airbus A320")
				.maxPasajeros(300)
				.build();
		
		for(int i=1; i<=2; i++) {
			for (int j=1; i<6; j++) {
				airbus320.addAsientos(
						Asiento.builder()
						.tipo(TipoAsiento.PRIMERA)
						.fila(i)
						.columna(j)
						.build());
			}
		}
		
		for(int i=1; i<=2; i++) {
			for (int j=1; i<6; j++) {
				airbus320.addAsientos(
						Asiento.builder()
						.tipo(TipoAsiento.TURISTA)
						.fila(i)
						.columna(j)
						.build());
			}
		}
		
		repositorio.save(airbus320);
		/*Asiento asiento = airbus320.getAsientos().get(0);
		airbus320.removeAsiento(asiento);
		
		repositorio.save(airbus320);*/
		repositorio.delete(airbus320);
	}
}
