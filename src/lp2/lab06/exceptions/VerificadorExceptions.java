/* 115111825 - Pabllo Rodolfo Santos de Lima: LAB 6 - Turma 1 */

package lp2.lab06.exceptions;

public class VerificadorExceptions {

	public static void verificaStringNulaVazia(String string, String tipo) throws Exception {
		if (string == null) {
			throw new Exception(tipo + " nao pode ser nulo.");
		} else if (string.trim().isEmpty()) {
			throw new Exception(tipo + " nao pode ser vazio.");
		}
	}

	public static void verificaDoubleNegativo(double valor, String tipo) throws Exception {
		if (valor < 0) {
			throw new Exception(tipo + " nao pode ser negativo.");
		}
	}

	public static void verificaDoubleInvalido(double valor, String tipo) throws Exception {
		if (valor == 0) {
			throw new Exception(tipo + " nao pode ser igual a zero.");
		} else if (valor < 0) {
			throw new Exception(tipo + " nao pode ser negativo.");
		}
	}
	
	public static void verificaSaldoInsuficiente(double saldo, double precoJogo) throws Exception {
		if (saldo < precoJogo) {
			throw new Exception("Saldo insuficiente para comprar o jogo.");
		}
	}

}
