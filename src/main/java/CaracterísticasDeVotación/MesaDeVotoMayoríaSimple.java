package CaracterísticasDeVotación;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import EntidadesHumanas.Votante;

public class MesaDeVotoMayoríaSimple implements MesaDeVoto{
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
	
	private Map <Votante, Boolean> listaDeVotantes = new HashMap<>();  
	private Map <String, Integer> listaDeCandidaatos = new HashMap<>();
	
	public MesaDeVotoMayoríaSimple (ArrayList<String> listaDeCandidatos) {
		for (String candidato: listaDeCandidatos) {
			this.listaDeCandidaatos.put(candidato, 0);
		}
	}

	@Override
	public void anyadirVotante(Votante votante) {
		this.listaDeVotantes.put(votante, votante.getVotos() > 0 ? true: false);
	}

	@Override
	public int getVotoDeCandidato(String candidato) {
		// TODO Auto-generated method stub
		return this.listaDeCandidaatos.get(candidato);
	}

	@Override
	public void sumarVotoACandidatoYRestarVotosAVotante(Votante votante, String candidato) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
