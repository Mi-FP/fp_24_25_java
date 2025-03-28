package fp.tipos.sevici;

import java.util.List;
import java.util.SortedSet;

public interface RedEstaciones {

	Integer getNumeroEstaciones();

	// : añade una estación a la red, si la estación no está en la red. Si ya está,
	// no hace nada.
	void agregarEstacion(Estacion e);

	// : obtiene una lista con las estaciones que tienen alguna bicicleta
	// disponible.
	List<Estacion> getEstacionesBicisDisponibles();

	// : obtiene una lista
	// con las estaciones que tienen un número mínimo de bicicletas disponibles.
	List<Estacion> getEstacionesBicisDisponibles(Integer k);

	// :
	// obtiene un conjunto ordenado con las estaciones que tienen alguna bicicleta
	// disponible y a una distancia de la ubicación dada, menor o igual que la
	// distancia dada como parámetro.
	SortedSet<Estacion> getEstacionesCercanas(CoordenadasGPS cs, Double distancia);

	// : obtiene la estación que tiene más
	// bicicletas disponibles.
	Estacion getEstacionMasBicisDisponibles();

	Integer getTotalPuestos();

	// : obtiene la ocupación media de
	// las estaciones que tienen bicis disponibles. Si no se puede calcular la
	// media, devuelve `null`.
	Double getOcupacionMediaEstacionesConBicis();

	// devuelve cierto si todas las estaciones que se encuentran a una
	// distancia menor o igual que la dada como parámetro del punto con coordenadas
	// cs, tienen bicis disponibles. False en caso contrario.
	Boolean tienenBicisDisponiblesTodasEstacionesCercanas(CoordenadasGPS cs, Double distancia);

}