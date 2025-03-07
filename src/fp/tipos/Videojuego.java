package fp.tipos;

import static fp.utiles.Checkers.checkCondicion;

import java.time.LocalDate;
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
public class Videojuego implements Comparable<Videojuego>{
	private String nombre;
	private String distribuidora;
	private Integer anyo;
	private Double ventasGlobales;
	
	public Videojuego(String nombre, String distribuidora, Integer anyo, Double ventasGlobales) {
		super();
		checkCondicion("Ventas globales deben ser superior a 0", ventasGlobales>0);
		this.nombre = nombre;
		this.distribuidora = distribuidora;
		this.anyo = anyo;
		this.ventasGlobales = ventasGlobales;
	}
	
	public Double getVentasGlobalesPorAnyo() {
		Integer anyo = LocalDate.now().getYear();
		return ventasGlobales/(anyo-this.anyo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	public Integer getAnyo() {
		return anyo;
	}

	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}

	public Double getVentasGlobales() {
		return ventasGlobales;
	}

	public void setVentasGlobales(Double ventasGlobales) {
		checkCondicion("Ventas globales deben ser superior a 0", ventasGlobales>0);
		this.ventasGlobales = ventasGlobales;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(anyo, nombre);
	}
	
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Videojuego) {
			Videojuego v = (Videojuego) o;
			result = Objects.equals(nombre, v.nombre) && 
					Objects.equals(anyo, v.anyo);
					
		}
		return result;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Videojuego other = (Videojuego) obj;
//		return Objects.equals(anyo, other.anyo) && Objects.equals(nombre, other.nombre);
//	}

	@Override
	public String toString() {
		return "Videojuego [nombre=" + nombre + ", distribuidora=" + distribuidora + ", anyo=" + anyo
				+ ", ventasGlobales=" + ventasGlobales + "]";
	}

	@Override
	public int compareTo(Videojuego o) {
		int cmp = nombre.compareTo(o.nombre);
		if (cmp == 0) {
			cmp = distribuidora.compareTo(o.distribuidora);
		}
		if (cmp == 0) {
			cmp = anyo.compareTo(o.anyo);
		}
		return cmp;
	}
	
	
}
