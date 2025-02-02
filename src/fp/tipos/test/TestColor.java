package fp.tipos.test;

import fp.tipos.Color;

public class TestColor {

	public static void main(String[] args) {
		Color color = Color.VERDE;
		System.out.println(color);
		color = Color.AMARILLO;
		System.out.println(color);
		
		
		int numero = 32;
		System.out.println(numero);
		System.out.println(numero);
		Integer numero2 = numero;
		System.out.println(numero2);
		System.out.println(numero2.floatValue());
		
	}

}
