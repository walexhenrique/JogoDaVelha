import java.util.Random;

public class IA {
	private boolean serio;
	
	public IA() {
		this.setSerio(); //Já define se a IA vai jogar com força total!
	}

	public boolean isSerio() {
		return serio;
	}
	
	public String[][] jogarIA(String[][] t, int rodada){
		
		if(this.isSerio()) {
			
			switch (rodada) {
				case 1:
					t = primeiraRodada(t);
					break;
	
				default:
					t = tomadaDeDecisao(t);
					break;
			}
			
		}else {
			//Vai procurar um número aleatório para jogar!
			Random computer = new Random();
			int computador = 0;
			do {
				computador = computer.nextInt(9);
			} while(!t[computador / 3][computador % 3].equals("-"));
			t[computador / 3][computador % 3] = "X";
		}
		
		return t;
	}
	
	public String[][] primeiraRodada(String[][] v) {
		for(int i = 0; i < 3; i++) {
			for(int x = 0; x < 3; x++) {
				
				if(v[i][x].equals("O")) {
					
					if(i == 1 && x == 1) { //Jogou no meio!
						Random computer = new Random();
						switch (computer.nextInt(4)) {
							case 0:
								v[0][0] = "X";//Marcando X no canto superior esquerdo!
								break;
							case 1:
								v[0][2] = "X";//Marcando X no canto superior direito!
								break;
							case 2:
								v[2][0] = "X";//Marcado X no canto inferior esquerdo!
							default:
								v[2][2] = "X";//Marcando X no canto inferior direito!
								break;
						}
						return v;
					}else if((i == 0 && x == 0) || (i == 0 && x == 2) || (i == 2 && x == 0) || (i == 2 && x == 2)) {
						//Se ele jogou nos cantos
						
						v[1][1] = "X";//Jogar no meio!
						
						return v;
					}else {//se ele jogou nas bordas!
						
						v[1][1] = "X";//Jogar no meio!
						
						return v;
					}
					
				}
				
			}
		}
		return v;
	}
	
	public String[][] jogandoRodada(String[][] v){
		
		return tomadaDeDecisao(v);
	}
	
	public String[][] tomadaDeDecisao(String[][] v){
		//Bloquear vitoria na parte superior
		if(v[0][0].equals("O") && v[0][1].equals("O") && v[0][2].equals("-")) {
			v[0][2] = "X";
			return v;
		}else if(v[0][0].equals("O") && v[0][1].equals("-") && v[0][2].equals("O")) {
			v[0][1] = "X";
			return v;
		}else if(v[0][0].equals("-") && v[0][1].equals("O") && v[0][2].equals("O")) {
			v[0][0] = "X";
			return v;
		}
		
		if(v[1][0].equals("O") && v[1][1].equals("O") && v[1][2].equals("-")) {
			v[1][2] = "X";
			return v;
		}else if(v[1][0].equals("O") && v[1][1].equals("-") && v[1][2].equals("O")) {
			v[1][1] = "X";
			return v;
		}else if(v[1][0].equals("-") && v[1][1].equals("O") && v[1][2].equals("O")) {
			v[1][0] = "X";
			return v;
		}

		
		//Bloquear vitoria na parte esquerda
		if(v[0][0].equals("O") && v[1][0].equals("O") && v[2][0].equals("-")) {
			v[2][0] = "X";
			return v;
		}else if(v[0][0].equals("O") && v[1][0].equals("-") && v[2][0].equals("O")) {
			v[1][0] = "X";
			return v;
		}else if(v[0][0].equals("-") && v[1][0].equals("O") && v[2][0].equals("O")) {
			v[0][0] = "X";
			return v;
		}
		//Bloquear vitoria na parte do meio descendo
		if(v[0][1].equals("O") && v[1][1].equals("O") && v[2][1].equals("-")) {
			v[2][1] = "X";
			return v;
		}else if(v[0][1].equals("O") && v[1][1].equals("-") && v[2][1].equals("O")) {
			v[1][1] = "X";
			return v;
		}else if(v[0][1].equals("-") && v[1][1].equals("O") && v[2][1].equals("O")) {
			v[0][1] = "X";
			return v;
		}
		
		
		//Bloquear vitoria na parte direita
		if(v[0][2].equals("O") && v[1][2].equals("O") && v[2][2].equals("-")) {
			v[2][2] = "X";
			return v;
		}else if(v[0][2].equals("O") && v[1][2].equals("-") && v[2][2].equals("O")) {
			v[1][2] = "X";
			return v;
		}else if(v[0][2].equals("-") && v[1][2].equals("O") && v[2][2].equals("O")) {
			v[0][2] = "X";
			return v;
		}
		
		//Bloquear vitoria na parte inferior
		if(v[2][0].equals("O") && v[2][1].equals("O") && v[2][2].equals("-")) {
			v[2][2] = "X";
			return v;
		}else if(v[2][0].equals("O") && v[2][1].equals("-") && v[2][2].equals("O")) {
			v[2][1] = "X";
			return v;
		}else if(v[2][0].equals("-") && v[2][1].equals("O") && v[2][2].equals("O")) {
			v[2][0] = "X";
			return v;
		}
		
		//Bloquear vitória diagonal esquerda para direita
		if(v[0][0].equals("O") && v[1][1].equals("O") && v[2][2].equals("-")) {
			v[2][2] = "X";
			return v;
		}else if(v[0][0].equals("O") && v[1][1].equals("-") && v[2][2].equals("O")) {
			v[1][1] = "X";
			return v;
		}else if(v[0][0].equals("-") && v[1][1].equals("O") && v[2][2].equals("O")) {
			v[0][0] = "X";
			return v;
		}
		
		//Bloquear vitória diagonal direita para esquerda 
		if(v[2][0].equals("O") && v[1][1].equals("O") && v[0][2].equals("-")) {
			v[0][2] = "X";
			return v;
		}else if(v[2][0].equals("O") && v[1][1].equals("-") && v[0][2].equals("O")) {
			v[1][1] = "X";
			return v;
		}else if(v[2][0].equals("-") && v[1][1].equals("O") && v[0][2].equals("O")) {
			v[2][0] = "X";
			return v;
		}
		for(int i = 0; i < 3; i++) {
			for(int x = 0; x < 3; x++) {
				if(v[i][x].equals("-")) {
					v[i][x] = "X";
					return v;
				}
			}
		}
		
		return v;
	}
	

	private void setSerio() {
		Random g = new Random(); 
		int valor = g.nextInt(2); // Pega um número de 0 a 1 para escolher se a máquina vai jogar sério ou não!
		boolean amigoOuInimigo;
		
		switch (valor) {
			case 0:
				amigoOuInimigo = false; //Não vai enfrentar o player com força máxima! 
				System.out.println("Sorte sua! Você pode ganhar!");
				break;
			default:
				amigoOuInimigo = true; //Não vai ser possivel o player ganhar!
				System.out.println("A Máquina vai com força total!");
				break;
		}
		
		this.serio = amigoOuInimigo;
	}
	
	
}
