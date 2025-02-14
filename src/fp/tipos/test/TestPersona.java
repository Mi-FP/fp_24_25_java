package fp.tipos.test;

import java.time.LocalDate;

import fp.tipos.Persona;
import fp.tipos.PersonaInmutable;

public class TestPersona {

	public static void main(String[] args) {
		Persona p = new Persona();
		System.out.println(p);
		p = new Persona();
		System.out.println(p);
		
		
//		IPersona p2 = new Persona();
//		System.out.println(p2);
		
		Persona p3 = new Persona();
		System.out.println(p3.getNombre());
		
		Persona p4 = new Persona("Jorge", "Garcia", "Gutierrez", 
				LocalDate.of(1981, 5, 3));
		System.out.println(p4.getNombre());
		
		Persona p5 = new Persona("German", "Garcia", "Gutierrez", 
				LocalDate.of(1985, 9, 5));
		System.out.println(p5.getNombre());
		System.out.println(p5.toString());
	
		PersonaInmutable p6 = new PersonaInmutable("German", "Garcia", "Gutierrez", 
				LocalDate.of(1985, 9, 5));
		System.out.println(p6.nombre());
		System.out.println(p6.toString());
		
		// TODO:Mostrar la diferencia en días entre los nacimientos de 
		// Jorge y Germán.

	}

}
