package lp2.lab06;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario pabllo;
	private Jogo overwatch;
	private HashSet<Jogo> conjunto;

	@Before
	public void setUp() {
		pabllo = new Usuario("Pabllo", "pabllo.lima");
		overwatch = new Jogo("Overwatch", 159.99);
		conjunto = new HashSet<Jogo>();
	}

	@Test
	public void testConstrutor() {
		assertEquals("Pabllo", pabllo.getNome());
		assertEquals("pabllo.lima", pabllo.getLogin());
		assertTrue(pabllo.getJogosComprados().isEmpty()); // assertEquals(new HashSet<Jogo>(0), pabllo.getJogosComprados());
		assertEquals(0, pabllo.getSaldo(), 0.05);
	}

	@Test
	public void testCompraJogoSemSaldo() {
		assertEquals(false, pabllo.compraJogo(overwatch));
	}

	@Test
	public void testCompraJogoComSaldo() {
		assertEquals(true, pabllo.adicionaDinheiro(200));
		assertEquals(200, pabllo.getSaldo(), 0.05);
		assertEquals(true, pabllo.compraJogo(overwatch));
		assertEquals(40.01, pabllo.getSaldo(), 0.05);

		conjunto.add(overwatch);
		assertEquals(conjunto, pabllo.getJogosComprados());
	}

	@Test
	public void testEquals() {
		assertEquals(pabllo, pabllo);

		Usuario pablloChara = new Usuario("Pabllo", "pabllo.alves");
		assertNotEquals(pabllo, pablloChara);

		Usuario fabiana = new Usuario("Fabiana", "fabiana.alves");
		assertNotEquals(pabllo, fabiana);
	}

	@Test
	public void testToString() {
		assertEquals("Usuario [nome=Pabllo, login=pabllo.lima, jogosComprados=[], saldo=0.0]", pabllo.toString());
	}

}
