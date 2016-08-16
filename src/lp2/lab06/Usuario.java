package lp2.lab06;

import java.util.HashSet;

public class Usuario {

	private String nome;
	private String login;
	private HashSet<Jogo> jogosComprados;
	private double saldo;

	public Usuario(String nome, String login) {
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new HashSet<Jogo>();
		this.saldo = 0.0;
	}

	public boolean compraJogo(Jogo jogo) {
		if (this.getSaldo() >= jogo.getPreco()) {
			this.setSaldo(this.getSaldo() - jogo.getPreco());
			jogosComprados.add(jogo);
			return true;
		} else {
			return false;
		}
	}

	public boolean adicionaDinheiro(double valor) {
		this.setSaldo(this.getSaldo() + valor);
		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public HashSet<Jogo> getJogosComprados() {
		return jogosComprados;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double valor) {
		this.saldo = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if (!(objeto instanceof Usuario)) {
			return false;
		}
		Usuario usuario = (Usuario) objeto;
		return this.getLogin().equalsIgnoreCase(usuario.getLogin());
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", login=" + login + ", jogosComprados=" + jogosComprados + ", saldo=" + saldo
				+ "]";
	}

}
