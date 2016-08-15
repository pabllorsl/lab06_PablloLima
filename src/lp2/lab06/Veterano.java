package lp2.lab06;

public class Veterano extends Usuario {

	public Veterano(String nome, String login) {
		super(nome, login);
	}

	@Override
	public boolean compraJogo(Jogo jogo) {
		if (super.getSaldo() >= jogo.getPreco()) {
			this.setSaldo(super.getSaldo() - jogo.getPreco() * 0.2);
			return true;
		} else {
			return false;
		}
	}

}
