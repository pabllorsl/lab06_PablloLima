package lp2.lab06;

public class Noob extends Usuario {

	public Noob(String nome, String login) {
		super(nome, login);
	}

	@Override
	public boolean compraJogo(Jogo jogo) {
		if (super.getSaldo() >= jogo.getPreco()) {
			this.setSaldo(super.getSaldo() - jogo.getPreco() * 0.1);
			return true;
		} else {
			return false;
		}
	}

}
