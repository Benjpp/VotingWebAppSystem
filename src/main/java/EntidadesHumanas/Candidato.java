package EntidadesHumanas;

import MisExcepciones.CandidatoExcepcion;
import java.util.Objects;

/**
 * Clase que representa a un candidato (Candidato).
 */
public class Candidato {
    
    // =======================
    // Atributos Estáticos
    // =======================
    private static int numTotalDeCandidatos = 0;
    
    // =======================
    // Atributos de Instancia
    // =======================
    private String nombreYApellidos;
    private int votosRecibidos;

    // =======================
    // Constructores
    // =======================
    public Candidato(String nombreYApellidos) {
        this.nombreYApellidos = nombreYApellidos;
        this.votosRecibidos = 0;
        
        numTotalDeCandidatos += 1;
    }

    // =======================
    // Métodos Estáticos
    // =======================
    public int getNumDeCandidatos() {
        return numTotalDeCandidatos;
    }
    
    // =======================
    // Métodos de Instancia
    // =======================
    public String getNombreYApellidos() {
        return this.nombreYApellidos;
    }
    
    public int getVotosRecibidos() {
        return this.votosRecibidos;
    }
    
    public void incrementarVotos() {
        this.votosRecibidos += 1;
    }
    
    public void decrementarVotos() throws CandidatoExcepcion {
        if(this.votosRecibidos < 0){
            throw new CandidatoExcepcion("ERROR: No se puede decrementar más votos de los que ya tiene el candidato.");
        }
        this.votosRecibidos -= 1;
    }

    // =======================
    // Sobreescrituras
    // =======================
    @Override
    public int hashCode() {
        return Objects.hash(this.nombreYApellidos, this.votosRecibidos);
    }
    
    @Override
    public boolean equals(Object o) {
        boolean res = false;
        
        if (o instanceof Candidato) {
            res = ((Candidato) o).getNombreYApellidos().equalsIgnoreCase(this.nombreYApellidos) && 
                   ((Candidato) o).getVotosRecibidos() == this.votosRecibidos;
        }
        
        return res;
    }
    
    @Override
    public String toString() {
        return this.nombreYApellidos;
    }
}
