package fp.tipos.sevici;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class RedEstacionesStream implements RedEstaciones {

	private SortedSet<Estacion> estaciones;
	private String nombreRed;

	public RedEstacionesStream(String nombreRed, SortedSet<Estacion> estaciones) {
		this.nombreRed = nombreRed;
		this.estaciones = estaciones;
	}

	public void agregarEstacion(Estacion e) {
		estaciones.add(e);
	}

	public Integer getNumeroEstaciones() {
		Long l = estaciones.stream().count();
		return l.intValue();
	}

	public List<Estacion> getEstacionesBicisDisponibles() {
		return estaciones.stream().filter(Estacion::getTieneBicisDisponibles).toList();
	}

	@Override
	public List<Estacion> getEstacionesBicisDisponibles(Integer k) {
		return estaciones.stream().filter((Estacion e) -> e.getBicisDisponibles() >= k).toList();
	}

	@Override
	public SortedSet<Estacion> getEstacionesCercanas(CoordenadasGPS cs, Double distancia) {
		Comparator<Estacion> cmp = Comparator.comparing((Estacion e) -> e.getCoordenadas().getDistanciaHaversine(cs))
				.thenComparing(Comparator.naturalOrder());
		Predicate<Estacion> predicado = (Estacion e) -> e.getCoordenadas().getDistanciaHaversine(cs) <= distancia;
		Supplier<SortedSet<Estacion>> suministrador = () -> new TreeSet<>(cmp);
		return getEstacionesBicisDisponibles().stream().filter(predicado)
				.collect(Collectors.toCollection(suministrador));
	}

	@Override
	public Estacion getEstacionMasBicisDisponibles() {
		Comparator<Estacion> cmp = Comparator.comparing(Estacion::getBicisDisponibles)
				.thenComparing(Comparator.naturalOrder());
		return estaciones.stream().max(cmp).get();
	}

	@Override
	public Integer getTotalPuestos() {
		ToIntFunction<Estacion> funcion = Estacion::getNumPuestos;
		return estaciones.stream().mapToInt(funcion).sum();
	}

	@Override
	public Double getOcupacionMediaEstacionesConBicis() {
		ToDoubleFunction<Estacion> funcion = Estacion::getOcupacion;
		return getEstacionesBicisDisponibles().stream().mapToDouble(funcion).average().orElse(0);
	}

	@Override
	public Boolean tienenBicisDisponiblesTodasEstacionesCercanas(CoordenadasGPS cs, Double distancia) {

		return getEstacionesCercanas(cs, distancia).stream().allMatch(Estacion::getTieneBicisDisponibles);
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
		RedEstacionesStream other = (RedEstacionesStream) obj;
		return Objects.equals(nombreRed, other.nombreRed);
	}

	@Override
	public String toString() {
		String s = nombreRed + "\n";

		return s + estaciones.stream().map(e -> e.toString() + "\n").reduce("", (s1, s2) -> s1 + s2);

	}

	@Override
	public Map<Integer, List<Estacion>> estacionesPorBicisDisponibles() {
		return estaciones.stream().collect(Collectors.groupingBy(Estacion::getBicisDisponibles));
	}

	@Override
	public Map<Integer, Integer> numEstacionesPorBicisDisponibles() {
		Function<Long, Integer> funcion = l -> l.intValue();

		return estaciones.stream().collect(Collectors.groupingBy(Estacion::getBicisDisponibles,
				Collectors.collectingAndThen(Collectors.counting(), funcion)));
	}

	public SortedMap<Integer, Integer> numEstacionesPorBicisDisponibles2() {
		Function<Long, Integer> funcion = l -> l.intValue();

		return estaciones.stream().collect(Collectors.groupingBy(Estacion::getBicisDisponibles,
				() -> new TreeMap<Integer, Integer>(), Collectors.collectingAndThen(Collectors.counting(), funcion)));
	}
}
