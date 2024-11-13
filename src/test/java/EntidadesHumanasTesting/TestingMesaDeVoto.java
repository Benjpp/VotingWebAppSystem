package EntidadesHumanasTesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import EntidadesHumanas.Votante;
import EntidadesHumanas.Candidato;
import CaracteristicasDeVotacion.MesaDeVoto;
import MisExcepciones.VotanteExcepcion;
import MisExcepciones.CandidatoExcepcion;
import MisExcepciones.MesaDeVotoExcepcion;
public class TestingMesaDeVoto {
	
	List<Votante> votantes = new ArrayList<Votante>();
	List<Candidato> candidatos = new ArrayList<Candidato>();
	Map<Integer, Candidato> rankingResultados = new HashMap<>();
	MesaDeVoto mesaDeVoto;
	@BeforeEach
	public void setUp() throws VotanteExcepcion, CandidatoExcepcion{
		candidatos.add(new Candidato("Candidato1"));
		candidatos.add(new Candidato("Candidato2"));
		candidatos.add(new Candidato("Candidato3"));

		mesaDeVoto = new MesaDeVoto(candidatos);
		mesaDeVoto.anyadirVotante("Votante1", 2);
		mesaDeVoto.anyadirVotante("Votante2", 2);
		mesaDeVoto.anyadirVotante("Votante3", 2);
		mesaDeVoto.anyadirVotante("Votante4", 1);

		votantes = mesaDeVoto.getVotantes();
		votantes.get(0).castVote("Candidato1", mesaDeVoto);
		votantes.get(0).castVote("Candidato2", mesaDeVoto);
		votantes.get(0).castVote("Candidato3", mesaDeVoto);
		votantes.get(1).castVote("Candidato1", mesaDeVoto);
		votantes.get(1).castVote("Candidato2", mesaDeVoto);
		votantes.get(2).castVote("Candidato1", mesaDeVoto);
		votantes.get(2).castVote("Candidato2", mesaDeVoto);
		votantes.get(3).castVote("Candidato1", mesaDeVoto);
	}

	@AfterEach
	public void tearDown(){
		votantes.clear();
		candidatos.clear();
		mesaDeVoto = null;
	}
	
	@Test
	void testInsercionCorrectaDeVotantesYCandidatos(){
		assertTrue(votantes.size() == Votante.totalDeVotantes && candidatos.size() == 3 );
	}

	@Test
	void testVotosSeCastean(){
		int sumaDeVotosEsperada = 0;
		for(Candidato c : candidatos){
			sumaDeVotosEsperada += c.getVotosRecibidos();
		}

		boolean votantesHanVotado = mesaDeVoto.votantesHanVotado();
		boolean votantesHanVotadoPropio = true;
		for(Votante v : votantes){
			if(!(v.getVotos() == 0)){
				votantesHanVotadoPropio = false;
			}
		}

		assertTrue(sumaDeVotosEsperada == 7 && votantesHanVotado && votantesHanVotadoPropio);
	}

	@Test
	void testGanadorSeDecideCorrectamente() throws MesaDeVotoExcepcion{
		rankingResultados = mesaDeVoto.decidirGanador();
		Candidato candidatoGanador = rankingResultados.get(1);
		Candidato candidatoGanadorPropio = candidatos.get(0);
		for(Candidato c : candidatos){
			if(c.getVotosRecibidos() > candidatoGanadorPropio.getVotosRecibidos()){
				candidatoGanadorPropio = c;
			}
		}
		assertEquals(candidatoGanador, candidatoGanadorPropio);

	}
	

}
