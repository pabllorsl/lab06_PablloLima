package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoTest {

	private Jogo overwatch;

	@Before
	public void setUp() throws Exception {
		overwatch = new Jogo("Overwatch", 159.99);
	}

	@Test
	public void testConstrutor() {
		testGetNome();
		testGetPreco();
		testGetMaiorScore();
		testGetVezesJogado();
		testGetVezesZerado();
	}

	@Test
	public void testRegistraJogada() {
		overwatch.registraJogada(100, false);
		assertEquals(1, overwatch.getVezesJogado());
		assertEquals(100, overwatch.getMaiorScore());
		assertEquals(0, overwatch.getVezesZerado());

		overwatch.registraJogada(200, true);
		assertEquals(2, overwatch.getVezesJogado());
		assertEquals(200, overwatch.getMaiorScore());
		assertEquals(1, overwatch.getVezesZerado());
	}

	@Test
	public void testGetNome() {
		assertEquals(overwatch.getNome(), "Overwatch");
	}

	@Test
	public void testGetPreco() {
		assertEquals(overwatch.getPreco(), 159.99, 0.05);
	}

	@Test
	public void testGetMaiorScore() {
		assertEquals(overwatch.getMaiorScore(), 0);
	}

	@Test
	public void testGetVezesJogado() {
		assertEquals(overwatch.getVezesJogado(), 0);
	}

	@Test
	public void testGetVezesZerado() {
		assertEquals(overwatch.getVezesZerado(), 0);
	}

	@Test
	public void testEquals() {
		assertEquals(overwatch, overwatch);

		Jogo ow = new Jogo("Overwatch", 159.99);
		assertEquals(overwatch, ow);

		Jogo hots = new Jogo("Heroes of the Storm", 0.00);
		assertNotEquals(overwatch, hots);
	}

	@Test
	public void testToString() {
		assertEquals("Nome: Overwatch\nPreco: 159.99\nMaior score: 0\nVezes jogado: 0\nVezes zerado: 0",
				overwatch.toString());

	}

}
