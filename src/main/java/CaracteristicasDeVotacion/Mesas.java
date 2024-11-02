package CaracteristicasDeVotacion;
import EntidadesHumanas.Candidato;

public interface Mesas {
	
	public void anyadirCandidato(Candidato c);
	public void decidirGanador();
	public boolean votantesHanVotado();
}
