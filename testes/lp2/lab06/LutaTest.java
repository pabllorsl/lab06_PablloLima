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

}
