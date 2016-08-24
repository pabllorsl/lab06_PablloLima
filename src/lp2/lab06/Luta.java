/* 115111825 - Pabllo Rodolfo Santos de Lima: LAB 6 - Turma 1 */

package lp2.lab06;

public class Luta extends Jogo {

	public Luta(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int score, boolean jogoZerado) throws Exception {
		int x2pExtra = 0;

		if (score < 0 || score > 100000) {
			throw new Exception("Score deve ser entre 0 e 100000 (inclusivos).");
		}

		if (score > super.getMaiorScore()) {
			x2pExtra = score / 1000;
		}

		super.registraJogada(score, jogoZerado);

		return x2pExtra;
	}

}
