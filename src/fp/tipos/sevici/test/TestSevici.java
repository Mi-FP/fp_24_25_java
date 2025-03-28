package fp.tipos.sevici.test;

import java.util.List;

import fp.tipos.sevici.Estacion;
import fp.tipos.sevici.FactoriaEstaciones;
import fp.tipos.sevici.RedEstaciones;
import fp.utiles.Ficheros;

public class TestSevici {

	public static void main(String[] args) {

		List<String> lineas = Ficheros.leerLineas("data/estaciones.csv");
		
		System.out.println("---------------------------------------------");

		String linea = lineas.get(1);

		Estacion e = FactoriaEstaciones.parsearEstacion(linea);

		System.out.println(e);
		
		RedEstaciones red = 
				FactoriaEstaciones.leerRedEstaciones("data/estaciones.csv", "Sevici");
		System.out.println(red);
	}

}
