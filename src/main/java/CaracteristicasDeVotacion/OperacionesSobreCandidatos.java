package CaracteristicasDeVotacion;
import java.util.Map;

import EntidadesHumanas.Candidato;
import MisExcepciones.MesaDeVotoExcepcion;

public interface OperacionesSobreCandidatos {
	
	/**
     * Decide el ganador de la votación basándose en los votos recibidos por los candidatos.
     * La lógica de decisión debe ser implementada por las clases que implementen esta interfaz.
     * 
     * @return true si se pudo decidir el ganador, false si no se pudo decidir el ganador
     */
    public Map<Integer, Candidato> decidirGanador() throws MesaDeVotoExcepcion;
}
