package MisExcepciones;

public class MesaDeVotoExcepcion extends Exception {
        
        public MesaDeVotoExcepcion(){
            super();    
        }
        public MesaDeVotoExcepcion(String mensaje){
            super(mensaje);
        }
}
