
public class JogoDaVelha {
	public static void main(String[] args) {
		IA robo = new IA();
		Partida g = new Partida(robo);
		int cont = 1;
		System.out.println(robo.isSerio());
		while(cont < 6) {
			g.Rodadas(cont);
			cont++;
		}
		g.mostrarTabela();
	}
}

