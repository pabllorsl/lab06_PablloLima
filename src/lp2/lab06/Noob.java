package lp2.lab06;

public class Noob extends Usuario {

	public Noob(String nome, String login) throws Exception {
		super(nome, login);
		desconto = 0.1;
	}

	@Override
	public boolean compraJogo(Jogo jogo) throws Exception {
		if (super.compraJogo(jogo)) {
			return true;
		} else {
			return false;
		}
	}

}
