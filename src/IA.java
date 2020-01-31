import java.util.Random;

public class IA {
	private boolean serio;
	private Partida jogo;
	
	
	public IA() {
		this.setSerio(); //Já define se a IA vai jogar com força total!
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
		int valor = g.nextInt(2); // Pega um número de 0 a 1 para escolher se a máquina vai jogar sério ou não!
		boolean amigoOuInimigo;
		
		switch (valor) {
			case 0:
				amigoOuInimigo = false; //Não vai enfrentar o player com força máxima! 
				break;
			default:
				amigoOuInimigo = true; //Não vai ser possivel o player ganhar!
				break;
		}
		
		this.serio = amigoOuInimigo;
	}
	
	
}
