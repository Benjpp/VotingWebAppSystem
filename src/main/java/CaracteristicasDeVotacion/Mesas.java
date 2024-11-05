package CaracteristicasDeVotacion;
import EntidadesHumanas.Candidato;
import EntidadesHumanas.Votante;

public interface Mesas {
	
	public void anyadirCandidato(Candidato c);
	public void anyadirVotante(Votante v);
	public void decidirGanador();
	public boolean votantesHanVotado();
}
