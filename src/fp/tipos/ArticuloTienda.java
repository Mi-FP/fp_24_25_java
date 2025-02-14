package fp.tipos;

/**
 * Jugador de fútbol: nombre, fecha de nacimiento, altura, nacionalidad, (edad).
 * 2. Videojuego: nombre, distribuidora, año de lanzamiento, ventas globales,
 * (ventas por años). 3. Empresa: nombre, CIF, fecha de fundación, número de
 * empleados, (año de fundación). 4. País: nombre, número de habitantes,
 * extensión, capital, (densidad media). 5. Artículo de tienda: nombre,
 * referencia, precio, categoría, stock, (disponibilidad)
 */
public class ArticuloTienda {
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

	public Boolean getDisponibilidad() {
		return stock > 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ArticuloTienda [nombre=" + nombre + ", referencia=" + referencia + ", precio=" + precio + ", categoria="
				+ categoria + ", stock=" + stock + "]";
	}

}
