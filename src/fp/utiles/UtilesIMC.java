package fp.utiles;

import java.util.LinkedList;
import java.util.List;

import fp.tipos.TipoIMC;

public class UtilesIMC {
	public static Double getIMC(Double peso, Double estatura) {

		return peso / Math.pow(estatura, 2);
	}

	public static List<Double> generaNRandomIMCs(Integer n) {
		List<Double> result = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			Double imc = Math.random() * 35 + 15;
			result.add(imc);
		}
		return result;
	}

	public static TipoIMC getTipoIMC(Double imc) {
//		Si su IMC es menos de 18.5, 
		// se encuentra dentro del rango de peso insuficiente.
//		Si su IMC es entre 18.5 y 24.9, 
		// se encuentra dentro del rango de peso normal o saludable.
//		Si su IMC es entre 25.0 y 29.9, 
		// se encuentra dentro del rango de sobrepeso.
//		Si su IMC es 30.0 o superior, 
		// se encuentra dentro del rango de obesidad.

		TipoIMC result;
		if (imc<18.5) {
			result = TipoIMC.PESO_INSUFICIENTE;
		}else if(18.5<=imc && imc<=25) {
			result = TipoIMC.PESO_NORMAL;
		}else if(25<imc && imc<30) {
			result = TipoIMC.SOBREPESO;
		}else {
			result = TipoIMC.OBESIDAD;
		}
		return result;
	}

	public static Double getIMCMedio(List<Double> imcs) {
		Double suma = 0.0;
		for (Double imc:imcs) {
			suma += imc;
		}
		return suma/imcs.size();
	}
	
	public static Boolean existeIMCConTipo(List<Double> imcs, 
			TipoIMC tipo) {
		//TODO: Hacer en casa
		return null;
	}
}
