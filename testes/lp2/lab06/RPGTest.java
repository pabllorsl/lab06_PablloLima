package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RPGTest {

	private Jogo massEffect;

	@Before
	public void setUp() throws Exception {
		massEffect = new RPG("Mass Effect", 7.49);
	}

	@Test
	public void testConstrutor() {
		try {
			assertEquals("Mass Effect", massEffect.getNome());
			assertEquals(7.49, massEffect.getPreco(), 0.05);
			assertEquals(0, massEffect.getMaiorScore());
			assertEquals(0, massEffect.getVezesJogado());
			assertEquals(0, massEffect.getVezesZerado());
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testContrutorWithException() {
		try {
			new RPG(null, 7.49);
			fail("Deveria ter lancado uma Exception de nome nulo");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo.", e.getMessage());
		}

		try {
			new RPG("", 7.49);
			fail("Deveria ter lancado uma Exception de nome vazio");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser vazio.", e.getMessage());
		}

		try {
			new RPG("Mass Effect", -7.49);
			fail("Deveria ter lancado uma Exception de preco negativo");
		} catch (Exception e) {
			assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}
	}

	@Test
	public void testRegistraJogada() {
		try {
			massEffect.registraJogada(100, false);
			assertEquals(1, massEffect.getVezesJogado());
			assertEquals(100, massEffect.getMaiorScore());
			assertEquals(0, massEffect.getVezesZerado());

			massEffect.registraJogada(200, true);
			assertEquals(2, massEffect.getVezesJogado());
			assertEquals(200, massEffect.getMaiorScore());
			assertEquals(1, massEffect.getVezesZerado());
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testEquals() {
		try {
			assertEquals(massEffect, massEffect);

			Jogo me = new RPG("Mass Effect", 2.99);
			assertEquals(me, massEffect);

			Jogo deusExMD = new RPG("Deus Ex: Mankind Divided", 129.99);
			assertNotEquals(deusExMD, massEffect);
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testToString() {
		assertEquals("Jogo [nome=Mass Effect, preco=7.49, maiorScore=0, vezesJogado=0, vezesZerado=0]",
				massEffect.toString());

	}

}
