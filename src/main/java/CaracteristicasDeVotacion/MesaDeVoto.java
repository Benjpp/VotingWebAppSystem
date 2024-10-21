package CaracteristicasDeVotacion;

import java.util.ArrayList;
import java.util.List;

import EntidadesHumanas.Candidato;
import EntidadesHumanas.Votante;

public class MesaDeVoto {
	
	/*
	 * Tipo de votación: anónima, no anónima, cuántas opciones, a cuantos tópicos máximo
	 * se puede votar.
	 * Sistema de puntuación por voto: todos igual, por porcentaje de "mérito",
	 * Decidir ganador: mostrar un top 3 (Si llegan a haber 3 tópicos o más sobre los que votar)
	 * de los ganadores.
	 */
	
	/*
	 *Cada votante va acompañado de un boolean que indica true si ya ha casteado
	 *todos sus posibles votos
	 */
		
	private List <Candidato> listaDeCandidatos;
	
	public MesaDeVoto (List<Candidato> listaDeCandidatos) {
		this.listaDeCandidatos = new ArrayList<>();
		
		for (Candidato candidato : listaDeCandidatos) {
			this.anyadirCandidato(candidato);
		}
	}

	public void anyadirCandidato (Candidato candidato) {
		this.listaDeCandidatos.add(candidato);
	}

	
	public int getVotosDeCandidato(Candidato candidato) {
		return candidato.getVotosRecibidos();
	}

	
	public void sumarVotoACandidatoYRestarVotosAVotante(Votante votante, String candidato) {
		
	}
	
	
	
}
