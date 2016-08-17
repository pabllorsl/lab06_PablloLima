package lp2.lab06;

import lp2.lab06.exceptions.VerificadorExceptions;

public class Jogo {

	private String nome;
	private double preco;
	private int maiorScore;
	private int vezesJogado;
	private int vezesZerado;

	public Jogo(String nome, double preco) throws Exception {
		VerificadorExceptions.verificaStringNulaVazia(nome, "Nome");
		VerificadorExceptions.verificaDoubleNegativo(preco, "Preco");
		this.nome = nome;
		this.preco = preco;
		maiorScore = 0;
		vezesJogado = 0;
		vezesZerado = 0;
	}

	public boolean registraJogada(int score, boolean jogoZerado) {
		vezesJogado += 1;

		if (score > maiorScore) {
			maiorScore = score;
		}

		if (jogoZerado) {
			vezesZerado += 1;
		}

		return true;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getMaiorScore() {
		return maiorScore;
	}

	public int getVezesJogado() {
		return vezesJogado;
	}

	public int getVezesZerado() {
		return vezesZerado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object objeto) {
		if (!(objeto instanceof Jogo)) {
			return false;
		}
		Jogo jogo = (Jogo) objeto;
		return this.getNome().equalsIgnoreCase(jogo.getNome());
	}

	@Override
	public String toString() {
		return "Jogo [nome=" + nome + ", preco=" + preco + ", maiorScore=" + maiorScore + ", vezesJogado=" + vezesJogado
				+ ", vezesZerado=" + vezesZerado + "]";
	}

}
