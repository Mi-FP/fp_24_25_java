package fp.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/*Cosas importantes:
 * 1. El nombre de la clase siempre con su .java
 * 2. El nombre del fichero igual que 
 * el nombre de la clase
 * 3. Nuestras clases siempre public
 * */

//

public class Persona implements IPersona, Comparable<Persona> {
	private static final String DELIMITADOR = ";";
	private String nombre;
	private String apellido1;
	private String apellido2;
	private LocalDate fechaNacimiento;
	
	// Aquí el resto de operaciones...
	
	//Formato: Apellido1;Apellido2;Nombre;dd/MM/yyyy
	public Persona(String s) {
		//1. Trocear
		String [] splits = s.split(DELIMITADOR);
		//2. Chequear número de trozos
		if(splits.length!=4) {
			throw new IllegalArgumentException("Número de trozos incorrecto");
		}
		//3. Conversión de tipos (parsing)
		String apellido1 = splits[0].trim();
		String apellido2 = splits[1].trim();
		String nombre = splits[2].trim();
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNacimiento = LocalDate.parse(splits[3].trim(), formateador);
		
		//4.0 Compración de restricciones
		checkFechaNacimiento(fechaNacimiento);
		
		//4.1 Asignación en atributos
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona() {
		nombre = "No name";
		apellido1 = "No surname 1";
		apellido2 = "No surname 2";
		fechaNacimiento = LocalDate.of(1900, 1, 1);
	}

	private void checkFechaNacimiento(LocalDate fecha) {
		if (fecha.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException();
		}
	}	
	
	public Persona(String nombre, 
			String apellido1, String apellido2, 
			LocalDate fechaNacimiento) {
		checkFechaNacimiento(fechaNacimiento);
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNacimiento = fechaNacimiento;
	}





	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fecha) {
		checkFechaNacimiento(fecha);
		this.fechaNacimiento = fecha;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String toString() {
		return nombre + " " + apellido1 + " " + apellido2 + 
				"(" + fechaNacimiento + ")";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(nombre, other.nombre);
	}

	public Integer getEdad() {
		//TODO: Hacerla
		return 0;
	}

	
	public int compareTo(Persona o) {
		return getNombre().compareTo(o.getNombre());
	}

}
