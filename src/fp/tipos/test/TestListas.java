package fp.tipos.test;

import java.util.ArrayList;
import java.util.List;

public class TestListas {

	public static void main(String[] args) {
		Integer i = 32;
		Integer j = new Integer(32);
		String s = new String("Hola Mundo");
		List<Integer> lista = new ArrayList<>();
		lista.add(i);
		lista.add(j);
		System.out.println(s);
		System.out.println(lista);

	}

}
