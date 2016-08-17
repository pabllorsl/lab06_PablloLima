package lp2.lab06;

public class Veterano extends Usuario {

	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
		desconto = 0.2;
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
