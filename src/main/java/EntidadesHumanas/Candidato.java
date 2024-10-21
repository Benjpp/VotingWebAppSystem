package EntidadesHumanas;

import java.util.Objects;

public class Candidato {
	
	/*
	 * Cada candidato deberá poder recibir votos, cuando lo reciba se actualizara el valor de su hashmap y el valor de los 
	 * votos restantes del votante
	 */
	
	/*
	 * En un hashmap introducire los candidatos acompañado de los votos que ha recibido
	 */
	
	private static int numTotalDeCandidatos = 0;
	
	private String nombreYApellidos;
	
	private int votosRecibidos;
	
	public Candidato (String nombreYApellidos) {
		this.nombreYApellidos = nombreYApellidos;
		this.votosRecibidos = 0;
		
		numTotalDeCandidatos += 1;
	}
	
	public int getNumDeCandidatos() {
		return numTotalDeCandidatos;
	}
	
	public String getNombreYApellidos() {
		return this.nombreYApellidos;
	}
	
	public int getVotosRecibidos() {
		return this.votosRecibidos;
	}
	
	public void incrementarVotos() {
		this.votosRecibidos += 1;
	}
	
	public void decrementarVotos() {
		this.votosRecibidos -= 1;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.nombreYApellidos, this.votosRecibidos);
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = false;
		
		if(o instanceof Candidato) {
			res = ((Candidato)o).getNombreYApellidos().equalsIgnoreCase(this.nombreYApellidos) && 
					((Candidato)o).getVotosRecibidos() == this.votosRecibidos;
		}
		
		return res;
	}
	
	@Override
	public String toString() {
		return this.nombreYApellidos;
	}
	
}
