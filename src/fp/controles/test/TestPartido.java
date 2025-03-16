package fp.controles.test;

import fp.controles.Partido;

public class TestPartido {

	public static void main(String[] args) {
		
		Partido p = new Partido("19/4/2023;Celta de Vigo;Villarreal;14467;Liga;[22-0-1,42-1-1,67-2-1]");
		System.out.println(p.getMinutos());
		System.out.println(new Partido("21/3/2023;Mallorca;Espanyol;13780;Liga;[0-0-0]"));
	}

}
