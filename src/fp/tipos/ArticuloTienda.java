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
public class ArticuloTienda implements IArticuloEmpresa {
	private String nombre;
	private String referencia;
	private Double precio;
	private String categoria;
	private Integer stock;

	public ArticuloTienda(String nombre, String referencia, Double precio, String categoria, Integer stock) {
		super();
		this.nombre = nombre;
		this.referencia = referencia;
		this.precio = precio;
		this.categoria = categoria;
		this.stock = stock;
	}

	@Override
	public Boolean getDisponibilidad() {
		return stock > 0;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String getReferencia() {
		return referencia;
	}

	@Override
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	@Override
	public Double getPrecio() {
		return precio;
	}

	@Override
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String getCategoria() {
		return categoria;
	}

	@Override
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public Integer getStock() {
		return stock;
	}

	@Override
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ArticuloTienda [nombre=" + nombre + ", referencia=" + referencia + ", precio=" + precio + ", categoria="
				+ categoria + ", stock=" + stock + "]";
	}
	
	//TODO: Cambiar a formato de clase
	@Override
	public int hashCode() {
		return Objects.hash(referencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticuloTienda other = (ArticuloTienda) obj;
		return Objects.equals(referencia, other.referencia);
	}

}
