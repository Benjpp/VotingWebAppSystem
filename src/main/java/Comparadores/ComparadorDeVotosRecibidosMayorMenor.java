package Comparadores;

import java.util.Comparator;

import EntidadesHumanas.Candidato;

public class ComparadorDeVotosRecibidosMayorMenor implements Comparator<Candidato>{

	@Override
	public int compare(Candidato o1, Candidato o2) {
	
		return Integer.compare(o1.getVotosRecibidos(), o2.getVotosRecibidos());
	}

}
