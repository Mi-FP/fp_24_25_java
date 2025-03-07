package fp.tipos.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.tipos.Persona;
import fp.tipos.Vuelo;

public class TestVuelo {

	public static void main(String[] args) {
		Set<Persona> conjunto = new HashSet<>();
		
		Persona p4 = new Persona("Jorge", "Garcia", "Gutierrez", 
				LocalDate.of(1981, 5, 3));
		Persona p5 = new Persona("German", "Garcia", "Gutierrez", 
				LocalDate.of(1985, 9, 5));
		
		conjunto.add(p4);
		conjunto.add(p5);
		
		Vuelo v = new Vuelo("IB3564", conjunto);
		System.out.println(v);
		
		Set<Persona> pasajeros = v.getPasajeros();
		pasajeros.remove(p4);
		
		System.out.println(v);
		
		System.out.println(conjunto);
		List<Persona> copia = new ArrayList<>(conjunto);
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(32);
		lista.add(1);
		System.out.println(copia);
		Collections.sort(copia);
		System.out.println(copia);
		
		
		
		
		
		
		
		
		
	}

}
