package EntidadesHumanas;

/**
 * Clase que representa los votos en blanco (VotoEnBlanco).
 */
public class VotoEnBlanco {
    
    // =======================
    // Atributos Estáticos
    // =======================
    private static int votosEnBlanco = 0;

    // =======================
    // Métodos Estáticos
    // =======================
    /**
     * Método que incrementa el contador de votos en blanco.
     */
    public static void incrementarVotosEnBlanco() {
        votosEnBlanco++;
    }
    
    /**
     * Método que obtiene el número total de votos en blanco.
     * 
     * @return Total de votos en blanco.
     */
    public static int getVotosEnBlanco() {
        return votosEnBlanco;
    }
}

