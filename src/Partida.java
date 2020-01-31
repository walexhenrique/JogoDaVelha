import java.util.Scanner;
public class Partida {
	private IA robo;
	private String[][] tabela;
	
	public Partida(IA robo) {
		this.setRobo(robo);
		this.tabela = new String[3][3];
		this.preechendoVetor();
		
	}
	
	public void Rodadas(int c) {
		
		if(!this.resultado(this.tabela)) {
			this.mostrarTabela();
			this.colocar();
			if(!this.resultado(this.tabela)) {
				this.robo.jogarIA(this.tabela, c);
			}
		}
		return;
	}
	
	public void colocar() {
		Scanner tecla = new Scanner(System.in);
		int n = 0;
		do {
			System.out.println("Digite um número de 0 a 8 que está vázio");
			n = tecla.nextInt();
		}	while(!this.tabela[n / 3][n % 3].equals("-"));
		
		this.tabela[n / 3][n % 3] = "O";	
	}
	
	private void preechendoVetor() {
		for(int i = 0; i < 3; i++) {
			for(int x = 0; x < 3; x++) {
				this.tabela[i][x] = "-";
			}
		}
	}
	
	public boolean resultado(String[][] v) {
		if(!v[0][0].equals("-") && !v[0][1].equals("-") && !v[0][2].equals("-") && !v[1][0].equals("-") && !v[1][1].equals("-") && !v[1][2].equals("-") && !v[2][0].equals("-") && !v[2][1].equals("-") && !v[2][2].equals("-")) {
			String q = "X"; //variavel para se verificar
			int ganhador = 2;
			for(int i = 0; i < 2; i++) {
				if(v[0][0].equals(q) && v[0][1].equals(q) && v[0][2].equals(q)) {
					//Parte de cima
					ganhador = i;
				}else if(v[1][0].equals(q) && v[1][1].equals(q) && v[1][2].equals(q)) {
					//Meio
					ganhador = i;
				}else if(v[2][0].equals(q) && v[2][1].equals(q) && v[2][2].equals(q)) {
					//baixo
					ganhador = i;
				}else if(v[0][0].equals(q) && v[1][0].equals(q) && v[2][0].equals(q)) {
					//esquerda descendo
					ganhador = i;
				}else if(v[0][1].equals(q) && v[1][1].equals(q) && v[2][1].equals(q)) {
					//meio descendo
					ganhador = i;
				}else if(v[0][2].equals(q) && v[1][2].equals(q) && v[2][2].equals(q)) {
					//direita descendo
					ganhador = i;
				}else if(v[0][0].equals(q) && v[1][1].equals(q) && v[2][2].equals(q)) {
					//diagonal direita pra esquerda
					ganhador = i;
				}else if(v[2][0].equals(q) && v[1][1].equals(q) && v[0][2].equals(q)) {
					//diagonal esquerda pra direita
					ganhador = i;
				}
				q = "O";
			}
			
			switch (ganhador) {
				case 0:
					System.out.println("A máquina ganhou!");
					break;
				case 1:
					System.out.println("Você ganhou!");
					break;
				default:
					System.out.println("Empate");
					break;
			}
			return true;
		}else {
			String q = "X"; //variavel para se verificar
			int ganhador = 2;
			for(int i = 0; i < 2; i++) {
				if(v[0][0].equals(q) && v[0][1].equals(q) && v[0][2].equals(q)) {
					//Parte de cima
					ganhador = i;
				}else if(v[1][0].equals(q) && v[1][1].equals(q) && v[1][2].equals(q)) {
					//Meio
					ganhador = i;
				}else if(v[2][0].equals(q) && v[2][1].equals(q) && v[2][2].equals(q)) {
					//baixo
					ganhador = i;
				}else if(v[0][0].equals(q) && v[1][0].equals(q) && v[2][0].equals(q)) {
					//esquerda descendo
					ganhador = i;
				}else if(v[0][1].equals(q) && v[1][1].equals(q) && v[2][1].equals(q)) {
					//meio descendo
					ganhador = i;
				}else if(v[0][2].equals(q) && v[1][2].equals(q) && v[2][2].equals(q)) {
					//direita descendo
					ganhador = i;
				}else if(v[0][0].equals(q) && v[1][1].equals(q) && v[2][2].equals(q)) {
					//diagonal direita pra esquerda
					ganhador = i;
				}else if(v[2][0].equals(q) && v[1][1].equals(q) && v[0][2].equals(q)) {
					//diagonal esquerda pra direita
					ganhador = i;
				}
				q = "O";
			}
			
			switch (ganhador) {
				case 0:
					System.out.println("A máquina ganhou!");
					break;
				case 1:
					System.out.println("Você ganhou!");
					break;
				default:
					break;
			}
			if(ganhador != 2) {
				return true;
			}
		
		}
		return false;
	}
	
	public void mostrarTabela() {
		for(int i = 0; i < 3; i++) {
			for(int x = 0; x < 3; x++) {
				if(x + 1 == 3) {
					System.out.println(this.tabela[i][x]);
					continue;
				}
				System.out.print(this.tabela[i][x] + " | ");
			}
		}
	}

	public IA getRobo() {
		return robo;
	}

	public void setRobo(IA robo) {
		this.robo = robo;
	}
	
}
