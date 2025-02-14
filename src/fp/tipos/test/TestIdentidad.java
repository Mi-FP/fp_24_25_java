package fp.tipos.test;

import fp.tipos.Videojuego;

public class TestIdentidad {

	public static void main(String[] args) {
		Videojuego v1 = new Videojuego("EA2024", "EA", 2024, 1500.0);
		Videojuego v2 = new Videojuego("EA2024", "EA", 2024, 1500.0);
		Videojuego v3 = v2;
		
//		System.out.println(v1 == v2);
//		System.out.println(v2 == v3);
		
		System.out.println(v1.equals(v2));
		System.out.println(v2.equals(v3));

	}

}
