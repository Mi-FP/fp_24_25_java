package fp.tipos;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Vuelo {
	private String identificador;
	private Set<Persona> pasajeros;
	
	public Vuelo(String identificador, Set<Persona> pasajeros) {
		super();
		this.identificador = identificador;
		this.pasajeros = new HashSet<>(pasajeros);
	}

	public String getIdentificador() {
		return identificador;
	}

	public Set<Persona> getPasajeros() {
		return new HashSet<>(pasajeros);
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(identificador, other.identificador);
	}

	@Override
	public String toString() {
		return "Vuelo [identificador=" + identificador + ", pasajeros=" + pasajeros + "]";
	}

	
	
	
}
