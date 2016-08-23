package lp2.lab06;

import java.util.HashSet;

import lp2.lab06.exceptions.VerificadorExceptions;

public abstract class Usuario {

	private String nome;
	private String login;
	private HashSet<Jogo> jogosComprados;
	private double saldo;
	protected double desconto;
	protected int x2p;

	public Usuario(String nome, String login) throws Exception {
		VerificadorExceptions.verificaStringNulaVazia(nome, "Nome");
		VerificadorExceptions.verificaStringNulaVazia(login, "Login");
		this.nome = nome;
		this.login = login;
		this.jogosComprados = new HashSet<Jogo>();
		this.saldo = 0.0;
		this.desconto = 0.0;
	}

	public boolean compraJogo(Jogo jogo) throws Exception {
		VerificadorExceptions.verificaSaldoInsuficiente(this.getSaldo(), jogo.getPreco());
		atualizaSaldo(this.getSaldo(), jogo.getPreco());
		contemJogo(jogo);
		adicionaJogo(jogo);
		return true;
	}

	public boolean contemJogo(Jogo jogo) throws Exception {
		if (jogosComprados.contains(jogo)) {
			throw new Exception("O jogo ja foi comprado.");
		} else {
			return true;
		}
	}

	public boolean adicionaDinheiro(double valor) throws Exception {
		VerificadorExceptions.verificaDoubleInvalido(valor, "Valor");
		this.setSaldo(this.getSaldo() + valor);
		return true;
	}

	private boolean adicionaJogo(Jogo jogo) {
		jogosComprados.add(jogo);
		return true;
	}

	private void atualizaSaldo(double saldo, double precoJogo) {
		this.setSaldo(saldo - (precoJogo - (precoJogo * this.desconto)));
	}

	public boolean registraJogada(String nomeDoJogo, int score, boolean zerou) throws Exception {
		procuraJogo(nomeDoJogo).registraJogada(score, zerou);
		return true;
	}

	public Jogo procuraJogo(String nome) throws Exception {
		for (Jogo jogo : jogosComprados) {
			if (jogo.getNome().equalsIgnoreCase(nome)) {
				return jogo;
			}
		}
		throw new Exception("Jogo nao encontrado.");
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public HashSet<Jogo> getJogosComprados() {
		return jogosComprados;
	}

	public double getSaldo() {
		return saldo;
	}

	private void setSaldo(double valor) {
		this.saldo = valor;
	}

	public double getDesconto() {
		return desconto;
	}

	public int getX2p() {
		return x2p;
	}

	public void setX2p(int x2p) {
		this.x2p = x2p;
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
