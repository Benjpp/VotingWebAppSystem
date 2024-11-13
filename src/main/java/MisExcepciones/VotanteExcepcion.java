
package MisExcepciones;

public class VotanteExcepcion extends Exception {
    public VotanteExcepcion(){
        super();    
    }
    public VotanteExcepcion(String mensaje){
        super(mensaje);
    }
}