package fp.tipos;

import static fp.utiles.Checkers.checkCondicion;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Jugador de fútbol: nombre, fecha de nacimiento, altura, nacionalidad, (edad).
 * 2. Videojuego: nombre, distribuidora, año de lanzamiento, ventas globales,
 * (ventas por años). 3. Empresa: nombre, CIF, fecha de fundación, número de
 * empleados, (año de fundación). 4. País: nombre, número de habitantes,
 * extensión, capital, (densidad media). 5. Artículo de tienda: nombre,
 * referencia, precio, categoría, stock, (disponibilidad)
 */
public class Empresa implements Comparable<Empresa>{
	private String nombre;
	private String CIF;
	private LocalDate fechaFundacion;
	private Integer numeroEmpleados;

	public Empresa(String nombre, String cIF, LocalDate fechaFundacion, Integer numeroEmpleados) {
		super();
		checkCondicion("Fecha fundación anterior a la actual", fechaFundacion.isBefore(LocalDate.now()));
		checkCondicion("Número de emplados debe ser mayor que 0", numeroEmpleados>0);
		this.nombre = nombre;
		CIF = cIF;
		this.fechaFundacion = fechaFundacion;
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public LocalDate getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(LocalDate fechaFundacion) {
		checkCondicion("Fecha fundación anterior a la actual", fechaFundacion.isBefore(LocalDate.now()));
		this.fechaFundacion = fechaFundacion;
	}

	public Integer getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(Integer numeroEmpleados) {
		checkCondicion("Número de emplados debe ser mayor que 0", numeroEmpleados>0);
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", CIF=" + CIF + ", fechaFundacion=" + fechaFundacion
				+ ", numeroEmpleados=" + numeroEmpleados + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CIF);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(CIF, other.CIF);
	}

	@Override
	public int compareTo(Empresa o) {
		
		return CIF.compareTo(o.CIF);
	}


}
