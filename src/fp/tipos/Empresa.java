package fp.tipos;

import java.time.LocalDate;

/**
 * Jugador de fútbol: nombre, fecha de nacimiento, altura, nacionalidad, (edad).
 * 2. Videojuego: nombre, distribuidora, año de lanzamiento, ventas globales,
 * (ventas por años). 3. Empresa: nombre, CIF, fecha de fundación, número de
 * empleados, (año de fundación). 4. País: nombre, número de habitantes,
 * extensión, capital, (densidad media). 5. Artículo de tienda: nombre,
 * referencia, precio, categoría, stock, (disponibilidad)
 */
public class Empresa {
	private String nombre;
	private String CIF;
	private LocalDate fechaFundacion;
	private Integer numeroEmpleados;

	public Empresa(String nombre, String cIF, LocalDate fechaFundacion, Integer numeroEmpleados) {
		super();
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
		this.fechaFundacion = fechaFundacion;
	}

	public Integer getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(Integer numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", CIF=" + CIF + ", fechaFundacion=" + fechaFundacion
				+ ", numeroEmpleados=" + numeroEmpleados + "]";
	}

}
