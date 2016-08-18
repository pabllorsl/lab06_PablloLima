package lp2.lab06;

public class Veterano extends Usuario {

	public Veterano(String nome, String login) throws Exception {
		super(nome, login);
		this.desconto = 0.2;
		this.x2p = 1000;
	}

	@Override
	public boolean compraJogo(Jogo jogo) throws Exception {
		if (super.compraJogo(jogo)) {
			super.setX2p(super.getX2p() + 15 * (int) jogo.getPreco());
			return true;
		} else {
			return false;
		}
	}

}
