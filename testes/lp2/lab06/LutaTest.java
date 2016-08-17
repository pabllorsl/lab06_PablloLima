package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LutaTest {

	private Jogo mortalKombatX;

	@Before
	public void setUp() throws Exception {
		mortalKombatX = new Luta("Mortal Kombat X", 119.90);
	}

	@Test
	public void testConstrutor() {
		try {
			assertEquals("Mortal Kombat X", mortalKombatX.getNome());
			assertEquals(119.90, mortalKombatX.getPreco(), 0.05);
			assertEquals(0, mortalKombatX.getMaiorScore());
			assertEquals(0, mortalKombatX.getVezesJogado());
			assertEquals(0, mortalKombatX.getVezesZerado());
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testContrutorWithException() {
		try {
			new Luta(null, 119.90);
			fail("Deveria ter lancado uma Exception de nome nulo");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser nulo.", e.getMessage());
		}

		try {
			new Luta("", 119.90);
			fail("Deveria ter lancado uma Exception de nome vazio");
		} catch (Exception e) {
			assertEquals("Nome nao pode ser vazio.", e.getMessage());
		}

		try {
			new Luta("Mortal Kombat X", -119.90);
			fail("Deveria ter lancado uma Exception de preco negativo");
		} catch (Exception e) {
			assertEquals("Preco nao pode ser negativo.", e.getMessage());
		}
	}

	@Test
	public void testRegistraJogada() {
		try {
			mortalKombatX.registraJogada(100, false);
			assertEquals(1, mortalKombatX.getVezesJogado());
			assertEquals(100, mortalKombatX.getMaiorScore());
			assertEquals(0, mortalKombatX.getVezesZerado());

			mortalKombatX.registraJogada(200, true);
			assertEquals(2, mortalKombatX.getVezesJogado());
			assertEquals(200, mortalKombatX.getMaiorScore());
			assertEquals(1, mortalKombatX.getVezesZerado());
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testEquals() {
		try {
			assertEquals(mortalKombatX, mortalKombatX);

			Jogo mkx = new Luta("Mortal Kombat X", 59.99);
			assertEquals(mkx, mortalKombatX);

			Jogo sf5 = new Luta("Street Fighter V", 99.99);
			assertNotEquals(sf5, mortalKombatX);
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

	@Test
	public void testToString() {
		assertEquals("Jogo [nome=Mortal Kombat X, preco=119.9, maiorScore=0, vezesJogado=0, vezesZerado=0]",
				mortalKombatX.toString());

	}

}
