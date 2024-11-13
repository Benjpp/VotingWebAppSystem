package MisExcepciones;

public class CandidatoExcepcion extends Exception {
    public CandidatoExcepcion() {
        super();
    }

    public CandidatoExcepcion(String mensaje) {
        super(mensaje);
    }
}
