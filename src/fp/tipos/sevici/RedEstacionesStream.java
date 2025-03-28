package fp.tipos.sevici;

import java.util.List;
import java.util.SortedSet;

public class RedEstacionesStream implements RedEstaciones{

	private SortedSet<Estacion> estaciones;
	private String nombreRed;

	public RedEstacionesStream(String nombreRed, SortedSet<Estacion> estaciones) {
		this.nombreRed = nombreRed;
		this.estaciones = estaciones;
	}

	@Override
	public Integer getNumeroEstaciones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarEstacion(Estacion e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Estacion> getEstacionesBicisDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estacion> getEstacionesBicisDisponibles(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SortedSet<Estacion> getEstacionesCercanas(CoordenadasGPS cs, Double distancia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estacion getEstacionMasBicisDisponibles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getTotalPuestos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getOcupacionMediaEstacionesConBicis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean tienenBicisDisponiblesTodasEstacionesCercanas(CoordenadasGPS cs, Double distancia) {
		// TODO Auto-generated method stub
		return null;
	}

}
