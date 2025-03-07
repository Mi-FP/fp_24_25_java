package fp.tipos.test;

import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.*;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.tipos.Jugador;
import fp.utiles.Matematicas;

public class TestColecciones {

	public static void main(String[] args) {
		testCollections();

		//testRetainAll();

		//testRemoveAll();

		//testSublist();

		//testSortedSet();
	}

	private static void testCollections() {
		List<Integer> enteros = Matematicas.generaEnterosAleatorios(10);
		System.out.println(enteros);
		sort(enteros);
		System.out.println(enteros);
		
	}

	private static void testSortedSet() {
		SortedSet<Jugador> result = new TreeSet<>();

		result.add(new Jugador("Rubén Castro", LocalDate.of(1981, 2, 23), 
				1.70, "Española"));
		result.add(new Jugador("Jorge Molina", 
				LocalDate.of(1979, 2, 23), 1.80, 
				"Española"));
		
		System.out.println(result);

	
	}

	private static void testSublist() {
		List<String> l1 = new LinkedList<>();
		List<String> l2 = new LinkedList<>();
		l1.add("A");
		l1.add("B");
		l1.add("B");
		l1.add("C");

		List<String> sub = new ArrayList<>(l1.subList(0, 2));
		l1.removeAll(sub);
		System.out.println("Sublista: " + sub);
		System.out.println("RemoveAll de sub: " + l1);

	}

	private static void testRemoveAll() {
		List<String> l1 = new LinkedList<>();
		List<String> l2 = new LinkedList<>();
		l1.add("A");
		l1.add("B");
		l1.add("B");
		l1.add("C");

		l2.add("B");

		l1.removeAll(l2);
		System.out.println("l1 después de l1.removeAll(l2): " + l1);

	}

	private static void testRetainAll() {
		List<String> l1 = new LinkedList<>();
		List<String> l2 = new LinkedList<>();
		l1.add("A");
		l1.add("B");
		l1.add("B");
		l1.add("C");

		l2.add("B");

		l1.retainAll(l2);
		System.out.println("l1 después de l1.retainAll(l2): " + l1);

	}

}
