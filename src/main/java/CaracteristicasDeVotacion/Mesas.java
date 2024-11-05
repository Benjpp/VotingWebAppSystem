package CaracteristicasDeVotacion;

import EntidadesHumanas.Candidato;
import EntidadesHumanas.Votante;

/**
 * Interfaz que define las operaciones básicas relacionadas con la gestión de mesas de votación.
 * Esta interfaz permite añadir candidatos y votantes, decidir el ganador de una votación y 
 * verificar si todos los votantes han ejercido su derecho al voto.
 */
public interface Mesas {
    
    /**
     * Añade un candidato a la mesa de votación.
     *
     * @param candidato El candidato a añadir a la lista de candidatos.
     */
    public void anyadirCandidato(Candidato candidato);
    
    /**
     * Añade un votante a la mesa de votación.
     *
     * @param votante El votante a añadir.
     */
    public void anyadirVotante(Votante votante);
    
    /**
     * Añade un votante a la mesa de votación, creando un nuevo objeto Votante 
     * a partir de los parámetros proporcionados.
     *
     * @param nombreYApellidos El nombre y apellidos del votante.
     * @param votosAsignados El número de votos asignados al votante.
     */
    public void anyadirVotante(String nombreYApellidos, int votosAsignados);
    
}

