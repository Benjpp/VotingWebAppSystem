package EntidadesHumanas;

public class VotoEnBlanco {
	private static int votosEnBlanco = 0;
	
	public static void incrementarVotosEnBlanco() {
		votosEnBlanco++;
	}
	
	public static int getVotosEnBlanco() {
		return votosEnBlanco;
	}
	
}
