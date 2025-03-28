package fp.tipos.sevici;

import static fp.utiles.Checkers.checkCondicion;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.utiles.Ficheros;

public class FactoriaEstaciones {

	private static final String DELIMITADOR = ",";

	
	
	/** lee un fichero de estaciones y construye un objeto de tipo RedEstaciones con el nombre de la red dado como parámetro.*/
	public static RedEstaciones leerRedEstaciones(String nombreFichero, String nombreRed) {
		SortedSet<Estacion> estaciones = new TreeSet<>();
		
		List<String> lineas = Ficheros.leerLineas(nombreFichero);
		lineas.remove(0);
		
		for(String linea: lineas) {
			estaciones.add(parsearEstacion(linea));
		}
		
		
		return new RedEstacionesNoStream(nombreRed, estaciones);
	}
	/**
	 * : crea un objeto de tipo Estación a partir de una cadena de caracteres. La
	 * cadena de caracteres debe tener el mismo formato que las líneas del fichero
	 * CSV.
	 */

	// name,slots,empty_slots,free_bikes,latitude,longitude
	// 149_CALLE ARROYO,20,11,9,37.397829929383,-5.97567172039552
	public static Estacion parsearEstacion(String lineaCSV) {
		String[] trozos = lineaCSV.split(DELIMITADOR);
		checkCondicion("Cadena con formato no válido", trozos.length == 6);

		String aux = trozos[0].trim();
		
		String [] trozos_2 = aux.split("_");
		String id = trozos_2[0].trim();
		String nombre = trozos_2[1].trim();
		
		Integer numPuestos = Integer.valueOf(trozos[1].trim());
		Integer bicisDisponibles = Integer.valueOf(trozos[2].trim());

		Double latitud = Double.valueOf(trozos[3].trim());
		Double longitud = Double.valueOf(trozos[4].trim());

		CoordenadasGPS ubicacion = new CoordenadasGPS(latitud, longitud);

		return new Estacion(id, nombre, numPuestos, bicisDisponibles, ubicacion);
	}

}
