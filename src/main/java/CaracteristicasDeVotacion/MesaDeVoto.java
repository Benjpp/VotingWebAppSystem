package CaracterísticasDeVotación;

import java.util.HashMap;
import java.util.Map;

import EntidadesHumanas.Votante;

public interface MesaDeVoto {
	/*
	 * En un hashmap introducire los candidatos acompañado de los votos que ha recibido
	 */
	
	/*
	 * Se deberá poder acceder a los votos de cuaalquier candidato que se pida
	 */
	
	int getVotoDeCandidato(String candidato); 
	
	/*
	 * Cada candidato deberá poder recibir votos, cuando lo reciba se actualizara el valor de su hashmap y el valor de los 
	 * votos restantes del votante
	 */
	
	void sumarVotoACandidatoYRestarVotosAVotante (Votante votante, String candidato);
		
	void anyadirVotante(Votante votante);
	
	
}
