package CaracteristicasDeVotacion;

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
}

