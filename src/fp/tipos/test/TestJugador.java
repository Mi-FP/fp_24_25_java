package fp.tipos.test;

import java.time.LocalDate;

import fp.tipos.Jugador;

public class TestJugador {

	public static void main(String[] args) {
		Jugador j1 = new Jugador("Rubén Castro", LocalDate.of(1981, 12, 24), 1.70, "Española");
		System.out.println(j1);
		System.out.println(j1.getEdad());

	}

}
