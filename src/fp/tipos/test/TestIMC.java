package fp.tipos.test;

import static fp.utiles.UtilesIMC.*;

import java.util.List;

public class TestIMC {

	public static void main(String... args) {
		Double estatura = 1.67;
		Double peso = 70.1;
		Double imc = getIMC(peso, estatura);
		System.out.println("Tu imc es: " + imc);
		System.out.println("Estás con :" + getTipoIMC(imc));
		
		List<Double> imcs = generaNRandomIMCs(10);
		System.out.println("10 imcs aleatorios:" + imcs);
		imcs = generaNRandomIMCs(10);
		System.out.println("Otros 10 imcs aleatorios:" + imcs);
		
		System.out.println("La media del imc es: " + getIMCMedio(imcs));
		
	}

}
