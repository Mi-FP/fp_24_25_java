package fp.tipos.sevici;

import java.util.List;
import java.util.Objects;
import java.util.SortedSet;

public class RedEstacionesNoStream implements RedEstaciones {

	private SortedSet<Estacion> estaciones;
	private String nombreRed;

	public RedEstacionesNoStream(String nombreRed, SortedSet<Estacion> estaciones) {
		this.nombreRed = nombreRed;
		this.estaciones = estaciones;
	}

	@Override
	public Integer getNumeroEstaciones() {
		return estaciones.size();
	}

	// : añade una estación a la red, si la estación no está en la red. Si ya está,
	// no hace nada.
	@Override
	public void agregarEstacion(Estacion e) {
		
	}

	// : obtiene una lista con las estaciones que tienen alguna bicicleta
	// disponible.
	@Override
	public List<Estacion> getEstacionesBicisDisponibles() {
		return null;
	}

	// : obtiene una lista
	// con las estaciones que tienen un número mínimo de bicicletas disponibles.
	@Override
	public List<Estacion> getEstacionesBicisDisponibles(Integer k) {
		return null;
	}

	// :
	// obtiene un conjunto ordenado con las estaciones que tienen alguna bicicleta
	// disponible y a una distancia de la ubicación dada, menor o igual que la
	// distancia dada como parámetro.
	@Override
	public SortedSet<Estacion> getEstacionesCercanas(CoordenadasGPS cs, Double distancia) {
		return null;
	}

	// : obtiene la estación que tiene más
	// bicicletas disponibles.
	@Override
	public Estacion getEstacionMasBicisDisponibles() {
		return null;
	}

	@Override
	public Integer getTotalPuestos() {
		return null;
	}

	// : obtiene la ocupación media de
	// las estaciones que tienen bicis disponibles. Si no se puede calcular la
	// media, devuelve `null`.
	@Override
	public Double getOcupacionMediaEstacionesConBicis() {
		return null;
	}

	// devuelve cierto si todas las estaciones que se encuentran a una
	// distancia menor o igual que la dada como parámetro del punto con coordenadas
	// cs, tienen bicis disponibles. False en caso contrario.
	@Override
	public Boolean tienenBicisDisponiblesTodasEstacionesCercanas(CoordenadasGPS cs, Double distancia) {
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombreRed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RedEstacionesNoStream other = (RedEstacionesNoStream) obj;
		return Objects.equals(nombreRed, other.nombreRed);
	}

	@Override
	public String toString() {
		return "RedEstaciones [estaciones=" + estaciones + ", nombreRed=" + nombreRed + "]";
	}

}
