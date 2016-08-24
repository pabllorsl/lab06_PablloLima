/* 115111825 - Pabllo Rodolfo Santos de Lima: LAB 6 - Turma 1 */

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

}
