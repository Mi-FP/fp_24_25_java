package fp.tipos.sevici;

import java.util.Objects;
import static fp.utiles.Checkers.*;
public class Estacion implements Comparable<Estacion>{
	private String id;
	private String nombre;
	private Integer numPuestos;
	private Integer bicisDisponibles;
	private CoordenadasGPS coordenadas;
	//name,slots,empty_slots,free_bikes,latitude,longitude
	public Estacion(String id, String nombre, Integer numPuestos, Integer bicisDisponibles,
			CoordenadasGPS coordenadas) {
		super();
		checkCondicion("Numero de puesto de ser mayor que 0", numPuestos>0);
		try {
		checkCondicion("Numero de bicicletas debe estar en [0, numPuestos]", 
				bicisDisponibles>=0 && bicisDisponibles<=numPuestos);
		}catch(IllegalArgumentException e) {
			System.out.println(bicisDisponibles);
		}
		
		
		this.id = id;
		this.nombre = nombre;
		this.numPuestos = numPuestos;
		this.bicisDisponibles = bicisDisponibles;
		this.coordenadas = coordenadas;
	}

	public Double getOcupacion() {
		return bicisDisponibles.doubleValue() / numPuestos;
	}

	public Integer getPuestosVacios() {
		return numPuestos - bicisDisponibles;
	}

	public Boolean getTieneBicisDisponibles() {
		return bicisDisponibles > 0;
	}

	public Integer getBicisDisponibles() {
		return bicisDisponibles;
	}

	public void setBicisDisponibles(Integer bicisDisponibles) {
		this.bicisDisponibles = bicisDisponibles;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNumPuestos() {
		return numPuestos;
	}

	public CoordenadasGPS getCoordenadas() {
		return coordenadas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacion other = (Estacion) obj;
		return Objects.equals(id, other.id);
	}

	public int compareTo(Estacion o) {
		return id.compareTo(o.id);
	}

	@Override
	public String toString() {
		return "Estacion [id=" + id + ", nombre=" + nombre + ", numPuestos=" + numPuestos + ", bicisDisponibles="
				+ bicisDisponibles + ", coordenadas=" + coordenadas + "]";
	}
	
	

}
