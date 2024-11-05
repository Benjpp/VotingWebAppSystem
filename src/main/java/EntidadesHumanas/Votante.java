package EntidadesHumanas;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

/**
 * Clase que representa a un votante (Votante).
 */
public class Votante {

    // =======================
    // Atributos Estáticos
    // =======================
    private static int totalDeVotantes = 0;

    // =======================
    // Atributos de Instancia
    // =======================
    private String nombreYApellidos;
    private int votosDisponibles;
    private List<Candidato> candidatosVotados; 

    // =======================
    // Constructores
    // =======================
    public Votante(String nombreYApellidos, int votosAsignados) {
        this.nombreYApellidos = nombreYApellidos;
        this.votosDisponibles = votosAsignados;
        this.candidatosVotados = new ArrayList<>();
        totalDeVotantes += 1;
    }

    // =======================
    // Métodos Estáticos
    // =======================
    public static int getNumTotalDeVotantes() {
        return totalDeVotantes;
    }

    // =======================
    // Métodos de Instancia
    // =======================
    /**
     * Método que verifica si un candidato ya ha sido votado.
     * 
     * @param candidato El candidato a verificar.
     * @return Verdadero si el candidato ya ha sido votado, falso en caso contrario.
     */
    private boolean candidatoVotado(Candidato candidato) {
        return this.candidatosVotados.contains(candidato);
    }

    /**
     * Método que emite un voto para un candidato dado.
     * 
     * @param candidato El candidato para el que se vota.
     * @return Verdadero si el voto fue emitido con éxito, falso en caso contrario.
     */
    public boolean castVote(Candidato candidato) {
        boolean votado = this.candidatoVotado(candidato);
        
        if (!votado && this.votosDisponibles > 0) {
            candidato.incrementarVotos();
            this.votosDisponibles -= 1;
            System.out.println(this.nombreYApellidos + " ha votado de forma exitosa a " + candidato.toString());
        }
        
        return !votado && this.votosDisponibles > 0;
    }

    /**
     * Método que elimina un voto para un candidato dado.
     * 
     * @param candidato El candidato para el que se desea eliminar el voto.
     * @return Verdadero si el voto fue eliminado con éxito, falso en caso contrario.
     */
    public boolean removeVote(Candidato candidato) {
        boolean votado = this.candidatoVotado(candidato);
        
        if (votado) {
            candidato.decrementarVotos();
            this.votosDisponibles += 1;
            this.candidatosVotados.remove(candidato);
        }
        
        return votado;
    }

    /**
     * Método que emite un voto en blanco.
     * 
     * @return Verdadero si el voto en blanco fue emitido con éxito, falso en caso contrario.
     */
    public boolean castBlankVote() {
        if (this.votosDisponibles > 0) {
            VotoEnBlanco.incrementarVotosEnBlanco();
            return true;
        }
        return false;
    }

    // =======================
    // Métodos Getters
    // =======================
    public String getNombre() {
        return this.nombreYApellidos;
    }

    public int getVotos() {
        return this.votosDisponibles;
    }

    public String nombreYApellidos() {
        return this.nombreYApellidos;
    }

    // =======================
    // Sobreescrituras
    // =======================
    @Override
    public String toString() {
        return this.nombreYApellidos;
    }

    @Override
    public boolean equals(Object o) {
        boolean res = false;

        if (o instanceof Votante) {
            res = ((Votante) o).getNombre().equalsIgnoreCase(this.nombreYApellidos) 
                && (((Votante) o).getVotos() == this.votosDisponibles);
        }

        return res;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nombreYApellidos, this.votosDisponibles);
    }
}
