package fp.tipos;

import java.time.LocalDate;
import java.util.Objects;

public record PersonaInmutable(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento) {
	
	
	
	public PersonaInmutable(String nombre, String apellido1) {
		this(nombre, apellido1, "", LocalDate.MIN);
	}
	
	public int hashCode() {
		return Objects.hash(nombre, apellido1, apellido2);
	}
	
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof PersonaInmutable) {
			PersonaInmutable persona = (PersonaInmutable) o;
			result = Objects.equals(nombre, persona.nombre) 
					&& Objects.equals(apellido1, persona.apellido1)
					&& Objects.equals(apellido2, persona.apellido2);
		}
		return result;
	}

	public String toString() {
		return nombre + " " + apellido1 + " " + apellido2 + "(" + fechaNacimiento + ")";
	}

}
