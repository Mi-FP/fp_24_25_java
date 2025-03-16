package fp.controles;
import static fp.utiles.Checkers.*;
/**
 * seleccionar record: 0.5
 * getDiferenciaGoles: 0.5
 * comparable: 0.5
 * restricciones y constructor: 0.5 
 * equals y hashCode y toString correctos: 0.5
 * parse: 0.5
 * */
public record Resultado(Integer minuto, Integer golesLocal, Integer golesVisitante) implements Comparable<Resultado>{
	public Resultado{
		checkCondicion("Minutos mayores o iguales a 0", minuto>=0);
		checkCondicion("Goles mayores o iguales a 0", golesLocal>=0);
		checkCondicion("Goles mayores o iguales a 0", golesVisitante>=0);
	}
	
	public Integer getDiferenciaGoles() {
		return golesLocal-golesVisitante;
	}
	
	public static Resultado parseaResultado(String formato) {
		String [] splits = formato.split("-");
		checkCondicion("Formato erróneo", splits.length==3);
		Integer minuto = Integer.valueOf(splits[0]);
		Integer golesLocal = Integer.valueOf(splits[1]);
		Integer golesVisitante = Integer.valueOf(splits[2]);
		return new Resultado(minuto, golesLocal, golesVisitante);
	}
	
	public int compareTo(Resultado o) {
		int cmp = minuto.compareTo(o.minuto);
		if (cmp == 0) {
			cmp = getDiferenciaGoles().compareTo(o.getDiferenciaGoles());
		}
		if (cmp == 0) {
			cmp = golesLocal.compareTo(o.golesLocal);
		}
		if (cmp == 0) {
			cmp = golesVisitante.compareTo(o.golesVisitante);
		}
		return cmp;
	}
}
