package fp.tipos.test;

import fp.tipos.Videojuego;

public class TestVideojuego {

	public static void main(String[] args) {
		Videojuego v = new Videojuego("Fifa2024", "EA", 2024, 1500.0);
		System.out.println(v);
		System.out.println(v.getVentasGlobalesPorAnyo());
	}

}
