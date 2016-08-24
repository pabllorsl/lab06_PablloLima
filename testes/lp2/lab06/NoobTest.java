/* 115111825 - Pabllo Rodolfo Santos de Lima: LAB 6 - Turma 1 */

package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NoobTest {

	private Usuario pabllo;
	private Jogo mortalKombatX;
	private Jogo streetFighterV;

	@Before
	public void setUp() throws Exception {
		pabllo = new Noob("Pabllo", "pabllo.lima");
		mortalKombatX = new Luta("Mortal Kombat X", 119.90);
		streetFighterV = new Luta("Street Fighter V", 99.99);
	}

	@Test
	public void testCompraJogoComSaldo() throws Exception {
		try {

			pabllo.adicionaDinheiro(500);
			assertEquals(500, pabllo.getSaldo(), 0.05);
			assertEquals(0, pabllo.getX2p());

			pabllo.compraJogo(mortalKombatX);
			assertEquals(392.09, pabllo.getSaldo(), 0.05);
			assertEquals(1190, pabllo.getX2p());

			pabllo.compraJogo(streetFighterV);
			assertEquals(302.099, pabllo.getSaldo(), 0.05);
			assertEquals(2180, pabllo.getX2p());

		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

}
