import java.util.Random;

public class IA {
	private boolean serio;
	private Partida jogo;
	
	
	public IA() {
		this.setSerio(); //J� define se a IA vai jogar com for�a total!
	}
	

	public Partida getJogo() {
		return jogo;
	}


	private void setJogo(Partida jogo) {
		this.jogo = jogo;
	}


	public boolean isSerio() {
		return serio;
	}

	private void setSerio() {
		Random g = new Random(); 
		int valor = g.nextInt(2); // Pega um n�mero de 0 a 1 para escolher se a m�quina vai jogar s�rio ou n�o!
		boolean amigoOuInimigo;
		
		switch (valor) {
			case 0:
				amigoOuInimigo = false; //N�o vai enfrentar o player com for�a m�xima! 
				break;
			default:
				amigoOuInimigo = true; //N�o vai ser possivel o player ganhar!
				break;
		}
		
		this.serio = amigoOuInimigo;
	}
	
	
}
