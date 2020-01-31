
public class Partida {
	private IA robo;
	private String tabela[][] = new String[3][3];
	
	public Partida(IA robo) {
		this.setRobo(robo);
		preechendoVetor();
	}
	
	private void preechendoVetor() {
		for(int i = 0; i < 3; i++) {
			for(int x = 0; x < 3; x++) {
				tabela[i][x] = "-";
			}
		}
	}
	
	public void mostrarTabela() {
		for(int i = 0; i < 3; i++) {
			for(int x = 0; x < 3; x++) {
				if(x + 1 == 3) {
					System.out.println(tabela[i][x]);
					continue;
				}
				System.out.print(tabela[i][x] + " | ");
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
