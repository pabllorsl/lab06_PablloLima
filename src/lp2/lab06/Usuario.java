package lp2.lab06;

import java.util.HashSet;

import lp2.lab06.exceptions.VerificadorExceptions;

public class Usuario {

	private String nome;
	private String login;
	private HashSet<Jogo> jogosComprados;
	private double saldo;
	protected double desconto;

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
		adicionaJogo(jogo);
		return true;
	}

	public boolean adicionaDinheiro(double valor) throws Exception {
		VerificadorExceptions.verificaDoubleInvalido(valor, "Valor");
		this.setSaldo(this.getSaldo() + valor);
		return true;
	}

	public boolean adicionaJogo(Jogo jogo) {
		jogosComprados.add(jogo);
		return true;
	}

	public void atualizaSaldo(double saldo, double precoJogo) {
		this.setSaldo(saldo - (precoJogo - (precoJogo * this.desconto)));
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

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
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
