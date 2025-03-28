package fp.tipos.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<Character, Integer> contador = contadorCarac("En un lugar de la Mancha...");
		System.out.println(contador);
		String [] palabras = new String[] {"hola", "adios", "hola"};
		System.out.println(indicePalabras(Arrays.asList(palabras)));
	}

	public static Map<Character, Integer> contadorCarac(String frase) {
		Map<Character, Integer> contador = new HashMap<>();
		for (char caracter : frase.toUpperCase().toCharArray()) {
			if (!contador.containsKey(caracter)) {
				contador.put(caracter, 1);
			} else {
				Integer valor = contador.get(caracter);
				valor++;
				contador.put(caracter, valor);
			}
		}
		return contador;
	}

	public static Map<String, List<Integer>> indicePalabras(List<String> palabras) {
		Map<String, List<Integer>> indice = new HashMap<>();
		for (int pos = 0; pos < palabras.size(); pos++) {
			String palabra = palabras.get(pos);
			if (indice.containsKey(palabra)) {
				indice.get(palabra).add(pos);
			} else {
				List<Integer> lista = new ArrayList<>();
				lista.add(pos);
				indice.put(palabra, lista);
			}
		}
		return indice;
	}
}
