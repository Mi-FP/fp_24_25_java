package fp.tipos;

import java.util.Objects;

/**
 * Jugador de fútbol: nombre, fecha de nacimiento, altura, nacionalidad, (edad).
 * 2. Videojuego: nombre, distribuidora, año de lanzamiento, ventas globales,
 * (ventas por años). 3. Empresa: nombre, CIF, fecha de fundación, número de
 * empleados, (año de fundación). 4. País: nombre, número de habitantes,
 * extensión, capital, (densidad media). 5. Artículo de tienda: nombre,
 * referencia, precio, categoría, stock, (disponibilidad)
 */
public class Pais {
	private String nombre;
	private Integer numeroHabitantes;
	private Double extension;
	private String capital;

	public Pais(String nombre, Integer numeroHabitantes, Double extension, String capital) {
		super();
		this.nombre = nombre;
		this.numeroHabitantes = numeroHabitantes;
		this.extension = extension;
		this.capital = capital;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public void setNumeroHabitantes(Integer numeroHabitantes) {
		this.numeroHabitantes = numeroHabitantes;
	}

	public Double getExtension() {
		return extension;
	}

	public void setExtension(Double extension) {
		this.extension = extension;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capital, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(capital, other.capital) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", numeroHabitantes=" + numeroHabitantes + ", extension=" + extension
				+ ", capital=" + capital + "]";
	}

}
