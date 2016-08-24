/* 115111825 - Pabllo Rodolfo Santos de Lima: LAB 6 - Turma 1 */

package lp2.lab06;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VeteranoTest {

	private Usuario pabllo;
	private Jogo mortalKombatX;

	@Before
	public void setUp() throws Exception {
		pabllo = new Veterano("Pabllo", "pabllo.lima");
		mortalKombatX = new Luta("Mortal Kombat X", 119.90);
	}

	@Test
	public void testCompraJogoComSaldo() {
		try {
			pabllo.adicionaDinheiro(200);
			pabllo.compraJogo(mortalKombatX);
			assertEquals(104.08, pabllo.getSaldo(), 0.05);
		} catch (Exception e) {
			fail("Nao deveria ter lancado Exception");
		}
	}

}
