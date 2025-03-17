package fp.controles;

import static fp.utiles.Checkers.checkCondicion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
/**
 * Comaparable: 0.75
 * Propiedades: 0.75
 * Derivadas: 0.75
 * Igualdad y hash: 0.75
 * Constructor string: 4
 * */

public class Partido implements Comparable<Partido>{
	private LocalDate fechaPartido;
	private String equipoLocal, equipoVisitante;
	private Integer numeroEspectadores;
	private Competicion competicion;
	private List<Resultado> resultadosParciales;

	public Partido(String s) {
		//21/3/2023;Mallorca;Espanyol;13780;Liga;[0-0-0]
		String [] splits = s.split(";");
		checkCondicion("Formato erroneo", splits.length==6);
		
		LocalDate fechaPartido = LocalDate.parse(splits[0].trim(), DateTimeFormatter.ofPattern("dd/M/yyyy"));
		String equipoLocal = splits[1].trim();
		String equipoVisitante = splits[2].trim();
		Integer numeroEspectadores = Integer.parseInt(splits[3].trim());
		Competicion competicion = Competicion.valueOf(splits[4].trim().toUpperCase());
		List<Resultado> resultadosParciales = parseaResultadosParciales(splits[5].trim());
		
		checkResultados(resultadosParciales);
		checkCondicion("Fecha no válida", !fechaPartido.isAfter(LocalDate.now()));
		checkCondicion("Número de espectadores no válido", numeroEspectadores>=0);
		
		this.fechaPartido = fechaPartido;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.numeroEspectadores = numeroEspectadores;
		this.competicion = competicion;
		this.resultadosParciales = resultadosParciales;
	}
	
	private List<Integer> getMinutos(List<Resultado> resultadosParciales2) {
		List<Integer> result = new ArrayList<Integer>();
		for (Resultado r: resultadosParciales2) {
			result.add(r.minuto());
		}
		return result;
	}
	
	private List<Integer> getSumasGoles(List<Resultado> resultadosParciales2) {
		List<Integer> result = new ArrayList<Integer>();
		for (Resultado r: resultadosParciales2) {
			result.add(r.golesLocal() + r.golesVisitante());
		}
		return result;
	}


	
	private void checkResultados(List<Resultado> resultadosParciales2) {
		List<Integer> minutos = getMinutos(resultadosParciales2);
		List<Integer> ordenados = new ArrayList<Integer>(minutos);
		Collections.sort(ordenados);
		
		checkCondicion("Minutos no crecientes", minutos.equals(ordenados));
		
		List<Integer> sumas = getSumasGoles(resultadosParciales2);
		ordenados = new ArrayList<Integer>(sumas);
		Collections.sort(ordenados);

		checkCondicion("Suma goles no crecientes", sumas.equals(ordenados));

		Set<Integer> sinRepetidos = new HashSet<>(sumas);
		checkCondicion("Existen resultados repetidos", sumas.equals(sinRepetidos));
	}

	//[0-0-0,...]
	private List<Resultado> parseaResultadosParciales(String formato) {
		String [] splits = formato.replace("[", "").replace("]", "").split(",");
		List<Resultado> lista =new ArrayList<Resultado>();
		for(String split:splits)
			lista.add(Resultado.parseaResultado(split.trim()));
		return lista;
	}

	public Integer getGolesLocal() {
		if (resultadosParciales.isEmpty()) {
			throw new UnsupportedOperationException();
		}
		return resultadosParciales.get(resultadosParciales.size()-1).golesLocal();
	}
	public Integer getGolesVisitante() {
		if (resultadosParciales.isEmpty()) {
			throw new UnsupportedOperationException();
		}
		return resultadosParciales.get(resultadosParciales.size()-1).golesVisitante();
	}
	public List<Integer> getMinutos(){
		return getMinutos(this.resultadosParciales);
	}

	public int hashCode() {
		return Objects.hash(equipoLocal, equipoVisitante, fechaPartido);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(equipoLocal, other.equipoLocal) && Objects.equals(equipoVisitante, other.equipoVisitante)
				&& Objects.equals(fechaPartido, other.fechaPartido);
	}
	public int compareTo(Partido o) {
		int cmp = fechaPartido.compareTo(o.fechaPartido);
		if (cmp == 0) {
			cmp = equipoLocal.compareTo(o.equipoLocal);
		}
		if (cmp == 0) {
			cmp = equipoVisitante.compareTo(o.equipoVisitante);
		}
		return cmp;
	}
	
	public LocalDate getFechaPartido() {
		return fechaPartido;
	}

	public String getEquipoLocal() {
		return equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public Integer getNumeroEspectadores() {
		return numeroEspectadores;
	}

	public Competicion getCompeticion() {
		return competicion;
	}

	public List<Resultado> getResultadosParciales() {
		return resultadosParciales;
	}

	
	@Override
	public String toString() {
		return "Partido [fechaPartido=" + fechaPartido + ", equipoLocal=" + equipoLocal + ", equipoVisitante="
				+ equipoVisitante + ", numeroEspectadores=" + numeroEspectadores + ", competicion=" + competicion
				+ ", resultadosParciales=" + resultadosParciales + "]";
	}
	
	
}
