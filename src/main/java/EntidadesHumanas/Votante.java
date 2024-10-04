package EntidadesHumanas;

public class Votante {
	private String nombreYApellidos;
	private int votos;
	/*El nombre y apellidos se mostrará de acuerdo al siguiente formato
	 * "Primer Apellido" + " " + "Segundo Apellido" + ", " + "Nombre"
	 */
	public Votante (String nombreYApellidos) {
		/* Se deberá crear un método para obtener los nombres y apellidos del votante
		 * a través de un mensaje que solicite dichos datos
		 */
		
		this.nombreYApellidos = nombreYApellidos;
	}
	
	public int getVotos() {
		return this.votos;
	}
	
	public String nombreYApellidos() {
		return this.nombreYApellidos;
	}
	
	public void castVote() {
		
		votos--;
	}
	
	
}
