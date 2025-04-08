package fp.tipos.sevici;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class RedEstacionesNoStream implements RedEstaciones {

	private SortedSet<Estacion> estaciones;
	private String nombreRed;

	public RedEstacionesNoStream(String nombreRed, SortedSet<Estacion> estaciones) {
		this.nombreRed = nombreRed;
		this.estaciones = estaciones;
	}

	// : añade una estación a la red, si la estación no está en la red. Si ya está,
	// no hace nada.
	@Override
	public void agregarEstacion(Estacion e) {
		estaciones.add(e);
	}

	@Override
	public Integer getNumeroEstaciones() {
		return estaciones.size();
	}

	// : obtiene una lista con las estaciones que tienen alguna bicicleta
	// disponible.
	@Override
	public List<Estacion> getEstacionesBicisDisponibles() {
		List<Estacion> result = new ArrayList<Estacion>();
		for (Estacion e : estaciones) {
			if (e.getTieneBicisDisponibles()) {
				result.add(e);
			}
		}
		return result;
	}

	// : obtiene una lista
	// con las estaciones que tienen un número mínimo de bicicletas disponibles.
	@Override
	public List<Estacion> getEstacionesBicisDisponibles(Integer k) {
		List<Estacion> result = new ArrayList<Estacion>();
		for (Estacion e : estaciones) {
			if (e.getBicisDisponibles() >= k) {
				result.add(e);
			}
		}
		return result;
	}

	// :
	// obtiene un conjunto ordenado con las estaciones que tienen alguna bicicleta
	// disponible y a una distancia de la ubicación dada, menor o igual que la
	// distancia dada como parámetro.
	@Override
	public SortedSet<Estacion> getEstacionesCercanas(CoordenadasGPS cs, Double distancia) {
		Comparator<Estacion> cmp = Comparator.comparing((Estacion e) -> e.getCoordenadas().getDistanciaHaversine(cs))
				.thenComparing(Comparator.naturalOrder());
		SortedSet<Estacion> result = new TreeSet<Estacion>(cmp);
		for (Estacion e : getEstacionesBicisDisponibles()) {
			if (e.getCoordenadas().getDistanciaHaversine(cs) <= distancia) {
				result.add(e);
			}
		}
		return result;
	}

	// : obtiene la estación que tiene más
	// bicicletas disponibles.
	@Override
	public Estacion getEstacionMasBicisDisponibles() {
		Comparator<Estacion> cmp = Comparator.comparing(Estacion::getBicisDisponibles)
				.thenComparing(Comparator.naturalOrder());
		return Collections.max(estaciones, cmp);
	}

	public Integer getTotalPuestos() {
		Integer result = 0;
		for (Estacion e : estaciones) {
			result += e.getNumPuestos();
		}
		return result;
	}

	// : obtiene la ocupación media de
	// las estaciones que tienen bicis disponibles. Si no se puede calcular la
	// media, devuelve `null`.
	public Double getOcupacionMediaEstacionesConBicis() {
		Double result = 0.0;
		Integer numEstaciones = 0;
		for (Estacion e : getEstacionesBicisDisponibles()) {
			result += e.getOcupacion();
			numEstaciones++;
		}
		if (numEstaciones > 0) {
			result = result / numEstaciones;
		} else {
			result = null;
		}
		return result;
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
		//TODO:  Hacer forEach
		return nombreRed + "\n" + estaciones;
	}

}
