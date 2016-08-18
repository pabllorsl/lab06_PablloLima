package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JogoNotAbstractTest {

	private Jogo overwatch;

	@Before
	public void setUp() throws Exception {
		overwatch = new JogoNotAbstract("Overwatch", 159.99);
	}

	@Test
	public void testConstrutor() {
		try {
			assertEquals("Overwatch", overwatch.getNome());
			assertEquals(159.99, overwatch.getPreco(), 0.05);
			assertEquals(0, overwatch.getMaiorScore());
			assertEquals(0, overwatch.getVezesJogado());
			assertEquals(0, overwatch.getVezesZerado());
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testContrutorWithException() {
		try {
			new JogoNotAbstract(null, 159.99);
			fail("Deveria ter lancado uma Exception de nome nulo");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo.", e.getMessage());
		}

		try {
			new JogoNotAbstract("", 159.99);
			fail("Deveria ter lancado uma Exception de nome vazio");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser vazio.", e.getMessage());
		}

		try {
			new JogoNotAbstract("Overwatch", -159.99);
			fail("Deveria ter lancado uma Exception de preco negativo");
		} catch (Exception e) {
			assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}
	}

	@Test
	public void testRegistraJogada() {
		try {
			overwatch.registraJogada(100, false);
			assertEquals(1, overwatch.getVezesJogado());
			assertEquals(100, overwatch.getMaiorScore());
			assertEquals(0, overwatch.getVezesZerado());

			overwatch.registraJogada(200, true);
			assertEquals(2, overwatch.getVezesJogado());
			assertEquals(200, overwatch.getMaiorScore());
			assertEquals(1, overwatch.getVezesZerado());
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testEquals() {
		try {
			assertEquals(overwatch, overwatch);

			Jogo ow = new JogoNotAbstract("Overwatch", 59.99);
			assertEquals(ow, overwatch);

			Jogo hots = new JogoNotAbstract("Heroes of the Storm", 0.0);
			assertNotEquals(hots, overwatch);
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testToString() {
		assertEquals("Jogo [nome=Overwatch, preco=159.99, maiorScore=0, vezesJogado=0, vezesZerado=0]",
				overwatch.toString());

	}

}
