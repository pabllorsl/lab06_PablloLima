package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NoobTest {

	private Usuario pabllo;
	private Jogo mortalKombatX;

	@Before
	public void setUp() throws Exception {
		pabllo = new Noob("Pabllo", "pabllo.lima");
		mortalKombatX = new Luta("Mortal Kombat X", 119.90);
	}

	@Test
	public void testCompraJogoComSaldo() {
		try {
			pabllo.adicionaDinheiro(200);
			pabllo.compraJogo(mortalKombatX);
			assertEquals(92.09, pabllo.getSaldo(), 0.05);
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

}
