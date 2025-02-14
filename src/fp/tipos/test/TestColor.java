package fp.tipos.test;

import fp.tipos.Color;

public class TestColor {

	public static void main(String[] args) {
		Color color = Color.VERDE;
		System.out.println(color);
		color = Color.AMARILLO;
		System.out.println(color);

		System.out.println(color.ordinal());

		int numero = 32;
		System.out.println(numero);
		System.out.println(numero);
		Integer numero2 = numero;
		System.out.println(numero2);
		System.out.println(numero2.floatValue());

//		Long l = 32l;
//		Double d = 3.13;
//		Float f = 3.13f;
//		Integer valor = 2 * l.intValue() + 32;
//
//		String cadena = "Hola Mundo";
//		LocalTime tiempo = LocalTime.of(11, 20);
		
		

	}

}
