package fp.tipos.test;

import java.util.stream.Stream;

public class TestForEach {

	public static void main(String[] args) {
		String [] array = {"Hola", "Jorge", "Adiós"};
		Stream<String> stream = Stream.of(array);
		stream.forEach(s->System.out.println(s));
	}

}
