
package CaracteristicasDeVotacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import EntidadesHumanas.Candidato;
import EntidadesHumanas.Votante;

public class MesaDeVoto implements Mesas{
	
	/*
	 * Tipo de votación: anónima, no anónima, cuántas opciones, a cuantos tópicos máximo
	 * se puede votar.
	 * Sistema de puntuación por voto: todos igual, por porcentaje de "mérito",
	 * Decidir ganador: mostrar un top 3 (Si llegan a haber 3 tópicos o más sobre los que votar)
	 * de los ganadores.
	 */
	
	/*
	 *Cada votante va acompañado en un hashmap de un boolean que indica true si ya ha casteado
	 *todos sus posibles votos
	 */
	
	private Map <Votante, Boolean> controlDeVotaciones;
	private List <Candidato> listaDeCandidatos;
	
	/*
	 * Constructor de una nueva MesaDeVoto, se inicializan los atributos de instancia a listas vacias
	 * 
	 * @param listaDeCandidatos 
	 * 		Se va pidiendo al usuario que vaya insertando los candidatos
	 * 		y se guardan en un ArrayList
	 */
	
	public MesaDeVoto (List<Candidato> listaDeCandidatos) {
		this.listaDeCandidatos = new ArrayList<>();
		this.controlDeVotaciones = new HashMap<>();
		
		for (Candidato candidato : listaDeCandidatos) {
			this.anyadirCandidato(candidato);
		}
	}
	
	/*
	 * Implementacion de uno de los métodos de la interfaz Mesas
	 * 
	 * @param candidato 
	 * 		A añadir a la lista que se inserta como una entrada de usuario en
	 * 		el constructor
	 */
	
	@Override
	public void anyadirCandidato (Candidato candidato) {
		this.listaDeCandidatos.add(candidato);
	}
	
	/*
	 * Getter
	 * 
	 * @param candidato 
	 * 		Cuyos votos se quieren saber
	 * 
	 * @return los votos del candidato pasado como parámetro 
	 */
	
	public int getVotosDeCandidato(Candidato candidato) {
		return candidato.getVotosRecibidos();
	}
	
	/*
	 * Implementación de uno de los métodos de la interfaz Mesas
	 * en el cual se decide el candidato ganador de  la votación
	 */
	
	@Override
	public void decidirGanador() {
		
	}
	
	/*
	 * Implementación de uno de los métodos de la interfaz Mesas el cual sirve
	 * para confirmar que todos los votantes hayan votado
	 * 
	 * @return verdadero si todos los votantes han votado,
	 * o retorna falso si al menos uno no ha votado
	 */
	
	@Override
	public boolean votantesHanVotado() {
		for (boolean bool: this.controlDeVotaciones.values()) {
			if(bool ^ true) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void anyadirVotante(Votante vot) {
		this.controlDeVotaciones.put(vot, false);
	}
	
	
}
