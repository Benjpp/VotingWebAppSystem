package EntidadesHumanas;

import java.util.List;
import java.util.ArrayList;

public class Votante {
	
	private static int totalDeVotantes = 0;
	
	private String nombreYApellidos;
	
	private int votosDisponibles;
	
	/*El nombre y apellidos se mostrará de acuerdo al siguiente formato
	 * "Primer Apellido" + " " + "Segundo Apellido" + ", " + "Nombre"
	 */
	
	private List<Candidato> candidatosVotados; 
	
	/*
	 *Metodo que devuelve falso si un candidato ya ha sido votado, es decir, si se encuentra en this.candidatosVotados, y devolverá true
	 *en caso contrario
	 */
	
	private boolean candidatoVotado (Candidato candidato) {
		return this.candidatosVotados.contains(candidato);
	}
	
	public Votante (String nombreYApellidos, int votosAsignados) {
		
		/* Se deberá crear un método para obtener los nombres y apellidos del votante
		 * a través de un mensaje que solicite dichos datos
		 * Inicializar los votos disponibles a lo que el anfitrión de la mesa quiera 
		 */
		
		this.nombreYApellidos = nombreYApellidos;
		this.votosDisponibles = votosAsignados;
		this.candidatosVotados = new ArrayList<>();
		
		totalDeVotantes += 1;
	}
	
	public int getNumTotalDeVotantes() {
		return totalDeVotantes;
	}
	
	public String getNombre() {
		return this.nombreYApellidos;
	}
	
	public int getVotos() {
		return this.votosDisponibles;
	}
	
	public String nombreYApellidos() {
		return this.nombreYApellidos;
	}
	
	public boolean castVote(Candidato candidato) {
		boolean votado = this.candidatoVotado(candidato);
		
		if(!votado && this.votosDisponibles > 0) {
			
			candidato.incrementarVotos();
			this.votosDisponibles -= 1;
			System.out.println(this.nombreYApellidos + " ha votado de forma exitosa a " + candidato.toString());
			
		}
		
		return !votado && this.votosDisponibles > 0;
	}
	
	public boolean removeVote(Candidato candidato) {
		boolean votado = this.candidatoVotado(candidato);
		
		if(votado) {
			
			candidato.decrementarVotos();
			this.votosDisponibles += 1;
			this.candidatosVotados.remove(candidato);
			
		}
		
		return votado;
	}
	
	@Override
	public String toString() {
		return this.nombreYApellidos;
	}
	
}
