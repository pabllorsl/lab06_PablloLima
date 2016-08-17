package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlataformaTest {

	private Jogo speedRunners;

	@Before
	public void setUp() throws Exception {
		speedRunners = new Plataforma("Speed Runners", 13.90);
	}

	@Test
	public void testConstrutor() {
		try {
			assertEquals("Speed Runners", speedRunners.getNome());
			assertEquals(13.90, speedRunners.getPreco(), 0.05);
			assertEquals(0, speedRunners.getMaiorScore());
			assertEquals(0, speedRunners.getVezesJogado());
			assertEquals(0, speedRunners.getVezesZerado());
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testContrutorWithException() {
		try {
			new Plataforma(null, 13.90);
			fail("Deveria ter lancado uma Exception de nome nulo");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo.", e.getMessage());
		}

		try {
			new Plataforma("", 13.90);
			fail("Deveria ter lancado uma Exception de nome vazio");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser vazio.", e.getMessage());
		}

		try {
			new Plataforma("Speed Runners", -13.90);
			fail("Deveria ter lancado uma Exception de preco negativo");
		} catch (Exception e) {
			assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}
	}

	@Test
	public void testRegistraJogada() {
		try {
			speedRunners.registraJogada(100, false);
			assertEquals(1, speedRunners.getVezesJogado());
			assertEquals(100, speedRunners.getMaiorScore());
			assertEquals(0, speedRunners.getVezesZerado());

			speedRunners.registraJogada(200, true);
			assertEquals(2, speedRunners.getVezesJogado());
			assertEquals(200, speedRunners.getMaiorScore());
			assertEquals(1, speedRunners.getVezesZerado());
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testEquals() {
		try {
			assertEquals(speedRunners, speedRunners);

			Jogo sr = new Plataforma("Speed Runners", 5.99);
			assertEquals(sr, speedRunners);

			Jogo starbound = new Plataforma("Starbound", 24.99);
			assertNotEquals(starbound, speedRunners);
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testToString() {
		assertEquals("Jogo [nome=Speed Runners, preco=13.9, maiorScore=0, vezesJogado=0, vezesZerado=0]",
				speedRunners.toString());

	}

}
