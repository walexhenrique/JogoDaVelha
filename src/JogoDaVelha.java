
public class JogoDaVelha {
	public static void main(String[] args) {
		int jogoDaVelha[][] = new int[3][3];
		IA robo = new IA();
		Partida g = new Partida(robo);
		g.mostrarTabela();
	}
}
