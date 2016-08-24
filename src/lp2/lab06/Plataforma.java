/* 115111825 - Pabllo Rodolfo Santos de Lima: LAB 6 - Turma 1 */

package lp2.lab06;

public class Plataforma extends Jogo {

	public Plataforma(String nome, double preco) throws Exception {
		super(nome, preco);
	}

	@Override
	public int registraJogada(int score, boolean jogoZerado) throws Exception {
		return super.registraJogada(score, jogoZerado) + super.getVezesJogado() * 20;
	}

}
