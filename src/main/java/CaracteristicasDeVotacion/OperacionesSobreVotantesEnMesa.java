package CaracteristicasDeVotacion;

import java.util.List;

import EntidadesHumanas.Votante;
/**
 * Interfaz que define operaciones relacionadas con la gestión de votantes en una mesa de votación.
 * Esta interfaz permite computar si un votante ha ejercido su derecho al voto.
 */
public interface OperacionesSobreVotantesEnMesa {
    
    /**
     * Computa si un votante ha votado. Actualiza el hashMap control de votaciones en MesaDeVoto segun haya votado ya o no.
     *
     * @param votante El votante cuyo estado de voto se desea verificar.
     * @return true si el votante existe y se ha podido hacer el computo, false si el votante no existe.
     */
    public boolean computarSiVotanteHaVotado(Votante votante);
    
    /**
     * Verifica si todos los votantes han votado.
     *
     * @return true si todos los votantes han votado, false si al menos uno no ha votado.
     */
    public boolean votantesHanVotado();

    /**
     * Rettorna en un ArrayList los votantes de la mesa
     */
    public List<Votante> getVotantes();
}

