package CaracteristicasDeVotacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Comparadores.ComparadorDeVotosRecibidosMayorMenor;
import EntidadesHumanas.Candidato;
import EntidadesHumanas.Votante;
import MisExcepciones.MesaDeVotoExcepcion;

/**
 * Clase que representa una mesa de votación (MesaDeVoto).
 * 
 * Esta clase gestiona los candidatos y votantes, así como el proceso de votación.
 */
public class MesaDeVoto implements Mesas, OperacionesSobreVotantesEnMesa,
									OperacionesSobreCandidatos{
    
    // =======================
    // Atributos de Instancia
    // =======================
    
    /*
     * Tipo de votación: anónima, no anónima, cuántas opciones, a cuántos tópicos máximo
     * se puede votar.
     * Sistema de puntuación por voto: todos igual, por porcentaje de "mérito",
     * Decidir ganador: mostrar un top 3 (Si llegan a haber 3 tópicos o más sobre los que votar)
     */

    /**
     * Control de votaciones, donde cada votante está asociado a un booleano que
     * indica si ha votado o no.
     */
    private Map<Votante, Boolean> controlDeVotaciones;

    /**
     * Mapa que almacena el ranking de resultados de los candidatos.
     */
    private Map<Integer, Candidato> rankingResultados;

    /**
     * Lista de candidatos que participan en la votación.
     */
    private List<Candidato> listaDeCandidatos;

    // =======================
    // Constructor
    // =======================
    
    /**
     * Constructor de una nueva mesa de votación.
     * 
     * @param listaDeCandidatos La lista de candidatos a ser añadidos a la mesa.
     */
    public MesaDeVoto(List<Candidato> listaDeCandidatos) {
        this.listaDeCandidatos = new ArrayList<>();
        this.controlDeVotaciones = new HashMap<>();
        
        // Añadir candidatos a la lista desde la lista proporcionada
        for (Candidato candidato : listaDeCandidatos) {
            this.anyadirCandidato(candidato);
        }
    }

    // =======================
    // Métodos de la Interfaz Mesas
    // =======================
    
    /**
     * Añade un candidato a la lista de candidatos.
     * 
     * @param candidato El candidato a añadir.
     */
    @Override
    public void anyadirCandidato(Candidato candidato) {
        this.listaDeCandidatos.add(candidato);
    }
    
    // =======================
    // Métodos de Consulta
    // =======================
    
    /**
     * Obtiene el mapa de control de votaciones.
     * 
     * @return El mapa de control de votaciones.
     */
    public Map<Votante, Boolean> getControlDeVotaciones() {
        return controlDeVotaciones;
    }

    /**
     * Obtiene el mapa de ranking de resultados de los candidatos.
     * 
     * @return El mapa de ranking de resultados de los candidatos.
     */
    public Map<Integer, Candidato> getRankingResultados() {
        return rankingResultados;
    }

    /**
     * Obtiene la lista de candidatos que participan en la votación.
     * 
     * @return La lista de candidatos.
     */
    public List<Candidato> getListaDeCandidatos() {
        return listaDeCandidatos;
    }

    /**
     * Obtiene el número de votos recibidos por un candidato.
     * 
     * @param candidato El candidato cuyo número de votos se desea conocer.
     * @return El número de votos recibidos por el candidato.
     */
    public int getVotosDeCandidato(Candidato candidato) {
        return candidato.getVotosRecibidos();
    }
    
    // =======================
    // Método para Decidir Ganador
    // =======================
    
    /**
     * Implementación del método para decidir el ganador de la votación.
     * 
     * @return true si el ganador se ha podido decidir, false si no se ha podido decidir
     */
    @Override
    public Map<Integer,Candidato> decidirGanador() throws MesaDeVotoExcepcion {
        Collections.sort(this.listaDeCandidatos, new ComparadorDeVotosRecibidosMayorMenor());
        int contadorRanking = 0;
        
        if(this.votantesHanVotado()) {
        	for (Candidato cand : this.listaDeCandidatos) {
            	this.rankingResultados.put(++contadorRanking, cand);
            }
        	return this.rankingResultados;
        }else{
            throw new MesaDeVotoExcepcion("ERROR: No se puede decidir el ganador porque no todos los votantes han votado.");
        }
    }
    
    // =======================
    // Métodos de Votación
    // =======================
    
    /**
     * Verifica si todos los votantes han votado.
     * 
     * @return true si todos los votantes han votado, false si al menos uno no ha votado.
     */
    @Override
    public boolean votantesHanVotado() {
        boolean res = true;
        for (Votante votante : this.controlDeVotaciones.keySet()) {
            if (this.computarSiVotanteHaVotado(votante)) {
                this.controlDeVotaciones.put(votante, true);
            }else{
                res = false;
            }
        }
        return res;
    }
    
    /**
     * Añade un votante a la mesa de votación.
     * 
     * @param vot El votante a añadir.
     */
    @Override
    public void anyadirVotante(Votante vot) {
        this.controlDeVotaciones.put(vot, false);
    }
    
    /**
     * Añade un votante a la mesa de votación, creando un nuevo objeto Votante.
     * 
     * @param nombreYApellidos El nombre y apellidos del votante.
     * @param votosAsignados El número de votos asignados al votante.
     */
    @Override
    public void anyadirVotante(String nombreYApellidos, int votosAsignados) {
        this.controlDeVotaciones.put(new Votante(nombreYApellidos, votosAsignados), false);
    }

    /**
     * Verifica si un votante ha votado.
     * 
     * @param votante El votante a verificar.
     * @return true si el votante ha votado, false en caso contrario.
     */
    @Override
    public boolean computarSiVotanteHaVotado(Votante votante) {
        if (!this.controlDeVotaciones.containsKey(votante)) {
            return false; // El votante no está en la mesa
        }
        return votante.getVotos() == 0; // El votante ha votado
    }

    /**
     * Obtiene la lista de votantes de la mesa.
     */
    @Override
    public List<Votante> getVotantes() {
        List<Votante> votantes = new ArrayList<>();
        for (Votante votante : this.controlDeVotaciones.keySet()) {
            votantes.add(votante);
        }
        return votantes;
    }

    /**
     * Busca un candidato en la mesa de votación por su nombre.
     * 
     * @param nombre El nombre del candidato a buscar.
     * @return El candidato si se encuentra en la mesa, null en caso contrario.
     */
    public Candidato getCandidato(String nombre) {
        for (Candidato candidato : this.listaDeCandidatos) {
            if (candidato.getNombreYApellidos().equalsIgnoreCase(nombre)) {
                return candidato;
            }
        }
        return null;
    }
}

