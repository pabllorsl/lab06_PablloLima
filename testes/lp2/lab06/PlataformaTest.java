/* 115111825 - Pabllo Rodolfo Santos de Lima: LAB 6 - Turma 1 */

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

}
