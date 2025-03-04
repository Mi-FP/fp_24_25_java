package fp.tipos;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Jugador de fútbol: nombre, fecha de nacimiento, altura, nacionalidad, (edad).
 * 2. Videojuego: nombre, distribuidora, año de lanzamiento, ventas globales,
 * (ventas por años). 
 * 3. Empresa: nombre, CIF, fecha de fundación, número de
 * empleados, (año de fundación). 
 * 4. País: nombre, número de habitantes,
 * extensión, capital, (densidad media). 5. Artículo de tienda: nombre,
 * referencia, precio, categoría, stock, (disponibilidad)
 */
public class Jugador {
	private String nombre;
	private LocalDate fechaNacimiento;
	private Double altura;
	private String nacionalidad;
	
	public Jugador(String nombre, LocalDate fechaNacimiento, Double altura, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		this.nacionalidad = nacionalidad;
	}
	
	public Integer getEdad() {
		Period periodo = fechaNacimiento.until(LocalDate.now());
		return periodo.getYears();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String toString() {
		return nombre + "(" + fechaNacimiento + ")" ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaNacimiento, nacionalidad, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nacionalidad, other.nacionalidad) && Objects.equals(nombre, other.nombre);
	}
	
	
	

	
}
