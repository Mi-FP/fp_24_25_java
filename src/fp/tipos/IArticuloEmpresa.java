package fp.tipos;

public interface IArticuloEmpresa {

	Boolean getDisponibilidad();

	String getNombre();

	void setNombre(String nombre);

	String getReferencia();

	void setReferencia(String referencia);

	Double getPrecio();

	void setPrecio(Double precio);

	String getCategoria();

	void setCategoria(String categoria);

	Integer getStock();

	void setStock(Integer stock);

}