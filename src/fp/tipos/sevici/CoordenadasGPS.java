package fp.tipos.sevici;

import static fp.tipos.sevici.UnidadMedida.*;
import static fp.utiles.Checkers.*;

public record CoordenadasGPS(Double latitud, Double longitud, UnidadMedida unidad) {

	private static final String DELIM = ",";

	public CoordenadasGPS {
		checkCondicion("Latitud no válida", latitud >= -90 && latitud <= 90);
		checkCondicion("Longitud no válida", longitud >= -180 && longitud <= 180);
	}

	public CoordenadasGPS() {
		this(0.0, 0.0);
	}

	public CoordenadasGPS(Double latitud, Double longitud) {
		this(latitud, longitud, GRADOS);
	}

	public CoordenadasGPS(String s) {
		this(parse(s));
	}

	private CoordenadasGPS(CoordenadasGPS coordenadasGPS) {
		this(coordenadasGPS.latitud, coordenadasGPS.longitud, coordenadasGPS.unidad);
	}

	private static CoordenadasGPS parse(String s) {
		// “-1.5, 0.22”
		String[] splits = s.split(DELIM);
		checkCondicion("Formato no válido en cadena", splits.length == 2);

		Double latitud = Double.valueOf(splits[0].trim());
		Double longitud = Double.valueOf(splits[1].trim());

		// Chequear restricciones

		// Asignar a atributos.

		return new CoordenadasGPS(latitud, longitud);
	}

	public Double getDistanciaHaversine(CoordenadasGPS c) {
		// Calcula la distancia haversine entre dos coordenadas.
		return 0.0;
	}

	public CoordenadasGPS aRadianes() {
		// Devuelve una coordenada con la latitud y longitud medida en radianes. Si la
		// coordenada está en radianes, devuelve una copia de la coordenada original.
		return null;
	}

	public CoordenadasGPS aGrados() {
		// Devuelve una coordenada con la latitud y longitud medida en grados. Si la
		// coordenada está en grados, devuelve una copia de la coordenada original.
		return null;
	}

}
